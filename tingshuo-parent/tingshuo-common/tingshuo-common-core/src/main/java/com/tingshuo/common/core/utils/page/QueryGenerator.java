package com.tingshuo.common.core.utils.page;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * 类文件描述:
 *
 * @author yangzong
 * @version 1.0.0
 * @date 2021年09月04日 21:40
 **/

public class QueryGenerator {
    /**
     * 封装统一查询方法
     * 获取查询条件构造器QueryWrapper实例 通用查询条件已被封装完成
     * @param searchObj 查询实体
     * @param parameterMap request.getParameterMap()
     * @param <T>
     * @return QueryWrapper实例
     */
    public static <T> QueryWrapper<T> initQueryWrapper(T searchObj, Map<String, String[]> parameterMap){
        long start = System.currentTimeMillis();
        QueryWrapper<T> queryWrapper = new QueryWrapper<T>();
        installMplus(queryWrapper, searchObj, parameterMap);
        System.out.printf(("---查询条件构造器初始化完成,耗时:"+(System.currentTimeMillis()-start)+"毫秒----"));
        return queryWrapper;
    }

    /**
     * 组装Mybatis Plus 查询条件
     * <p>使用此方法 需要有如下几点注意:
     * <br>1.使用QueryWrapper 而非LambdaQueryWrapper;
     * <br>2.实例化QueryWrapper时不可将实体传入参数
     * <br>错误示例:如QueryWrapper<JeecgDemo> queryWrapper = new QueryWrapper<JeecgDemo>(jeecgDemo);
     * <br>正确示例:QueryWrapper<JeecgDemo> queryWrapper = new QueryWrapper<JeecgDemo>();
     * <br>3.也可以不使用这个方法直接调用 {@link #initQueryWrapper}直接获取实例
     */
    public static <T> void installMplus(QueryWrapper<T> queryWrapper, T searchObj, Map<String, String[]> parameterMap){

    } /*{


		*//*
		 * 注意:权限查询由前端配置数据规则 当一个人有多个所属部门时候 可以在规则配置包含条件 orgCode 包含 #{sys_org_code}
		但是不支持在自定义SQL中写orgCode in #{sys_org_code}
		当一个人只有一个部门 就直接配置等于条件: orgCode 等于 #{sys_org_code} 或者配置自定义SQL: orgCode = '#{sys_org_code}'
		*//*

        //区间条件组装 模糊查询 高级查询组装 简单排序 权限查询
        PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(searchObj);
        Map<String,SysPermissionDataRuleModel> ruleMap = getRuleMap();

        //权限规则自定义SQL表达式
        for (String c : ruleMap.keySet()) {
            if(oConvertUtils.isNotEmpty(c) && c.startsWith(SQL_RULES_COLUMN)){
                queryWrapper.and(i ->i.apply(getSqlRuleValue(ruleMap.get(c).getRuleValue())));
            }
        }

        String name, type;
        for (int i = 0; i < origDescriptors.length; i++) {
            //aliasName = origDescriptors[i].getName();  mybatis  不存在实体属性 不用处理别名的情况
            name = origDescriptors[i].getName();
            type = origDescriptors[i].getPropertyType().toString();
            try {
                if (judgedIsUselessField(name)|| !PropertyUtils.isReadable(searchObj, name)) {
                    continue;
                }

                Object value = PropertyUtils.getSimpleProperty(searchObj, name);
                // update-begin--Author:taoyan  Date:20200910 for：issues/1671 如果字段加注解了@TableField(exist = false),不走DB查询-------
                //如果字段加注解了@TableField(exist = false),不走DB查询
                //TODO 存在缺陷，这个写法 clazz.getDeclaredField(name) 获取不到继承的父实体字段
                try {
                    if (oConvertUtils.isNotEmpty(value)) {
                        Field field = searchObj.getClass().getDeclaredField(name);
                        if (field != null) {
                            TableField tableField = field.getAnnotation(TableField.class);
                            if (tableField != null && tableField.exist() == false) {
                                continue;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // update-end--Author:taoyan  Date:20200910 for：issues/1671 如果字段加注解了@TableField(exist = false),不走DB查询 -------

                //数据权限查询
                if(ruleMap.containsKey(name)) {
                    addRuleToQueryWrapper(ruleMap.get(name), name, origDescriptors[i].getPropertyType(), queryWrapper);
                }

                // 添加 判断是否有区间值
                String endValue = null,beginValue = null;
                if (parameterMap != null && parameterMap.containsKey(name + BEGIN)) {
                    beginValue = parameterMap.get(name + BEGIN)[0].trim();
                    addQueryByRule(queryWrapper, name, type, beginValue, QueryRuleEnum.GE);

                }
                if (parameterMap != null && parameterMap.containsKey(name + END)) {
                    endValue = parameterMap.get(name + END)[0].trim();
                    addQueryByRule(queryWrapper, name, type, endValue, QueryRuleEnum.LE);
                }
                //多值查询
                if (parameterMap != null && parameterMap.containsKey(name + MULTI)) {
                    endValue = parameterMap.get(name + MULTI)[0].trim();
                    addQueryByRule(queryWrapper, name.replace(MULTI,""), type, endValue, QueryRuleEnum.IN);
                }

                //判断单值  参数带不同标识字符串 走不同的查询
                //TODO 这种前后带逗号的支持分割后模糊查询需要否 使多选字段的查询生效
                if (null != value && value.toString().startsWith(COMMA) && value.toString().endsWith(COMMA)) {
                    String multiLikeval = value.toString().replace(",,", COMMA);
                    String[] vals = multiLikeval.substring(1, multiLikeval.length()).split(COMMA);
                    final String field = oConvertUtils.camelToUnderline(name);
                    if(vals.length>1) {
                        queryWrapper.and(j -> {
                            j = j.like(field,vals[0]);
                            for (int k=1;k<vals.length;k++) {
                                j = j.or().like(field,vals[k]);
                            }
                            //return j;
                        });
                    }else {
                        queryWrapper.and(j -> j.like(field,vals[0]));
                    }
                }else {
                    //根据参数值带什么关键字符串判断走什么类型的查询
                    QueryRuleEnum rule = convert2Rule(value);
                    value = replaceValue(rule,value);
                    // add -begin 添加判断为字符串时设为全模糊查询
                    //if( (rule==null || QueryRuleEnum.EQ.equals(rule)) && "class java.lang.String".equals(type)) {
                    // 可以设置左右模糊或全模糊，因人而异
                    //rule = QueryRuleEnum.LIKE;
                    //}
                    // add -end 添加判断为字符串时设为全模糊查询
                    addEasyQuery(queryWrapper, name, rule, value);
                }

            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        // 排序逻辑 处理
        doMultiFieldsOrder(queryWrapper, parameterMap);

        //高级查询
        doSuperQuery(queryWrapper, parameterMap);
    }*/
}
