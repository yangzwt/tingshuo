package com.tingshuo.system.utils.web;

import com.tingshuo.common.core.constant.Constants;
import com.tingshuo.common.core.utils.RedisTempUtils;
import com.tingshuo.system.entity.SysUserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.List;

/**
 * 类文件描述:
 * 听说项目统一拦截器
 * @author yangz
 * @version 1.0.0
 * @date 2022年10月29日 15:51
 **/

public class TingShuoInterceptor implements HandlerInterceptor {
    @Value("${tingshuo.url}")
    private String basePath;
    @Autowired
    private RedisTempUtils redisUtils;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //1.判断是否是统一的请求格式
        if (Constants.METHOD_GET.equals(request.getMethod()) || Constants.METHOD_POST.equals(request.getMethod())) {
            String header = request.getHeader("x-forword-tingshuo");
            //2.判断本次URL是否需要登陆。
            String[] filterUrl;
            if (basePath != null) {
                filterUrl = basePath.split(",");
                for (String url : filterUrl) {
                    url.startsWith(basePath + url);

                    return true;

                }
            }
            //3.判断请求头的请求的值，是否在redis中存在
            //if (header != null) {
            if (header == null) {
                String tokenKey = Constants.USER_TOKEN_KEY+Constants.USER_TOKEN_KEY + header;
                String key="name0";
                String s = redisTemplate.opsForValue().get(key).toString();
                System.out.println("用户信息是=s" + s);
                Object o =null;
                //Object o = redisUtils.get(tokenKey).toString();
                if (o == null) {
                    System.out.println("该用户不存在，或者超时了");
                    return true;
                }
                //4.不为空获取用户信息
                SysUserPo sysUserPo = (SysUserPo) o;
                System.out.println("用户信息是=" + sysUserPo);
                //5.为当前用户增加到期时间

                redisUtils.setExpire(tokenKey, Constants.TOKEN_EXPIRE);
                //6.URL权限认证校验
                return checkUrl(response, request.getRequestURI(), sysUserPo, "ip", request.getMethod(), printParams(request));
            }
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
    public static String printParams(HttpServletRequest request) {
        Enumeration enu = request.getParameterNames();
        StringBuffer sb = new StringBuffer("[");
        if (enu != null) {
            while (enu.hasMoreElements()) {
                String key = (String) enu.nextElement();
                String value = request.getParameter(key);
                sb.append(key + "=" + value + ",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * URL权限认证校验
     * @return
     */
    public boolean checkUrl(HttpServletResponse response,String uri,SysUserPo sysUserPo,String ip,String method,String params) {
        String USER_PERMISSION_URL_KEY = String.format(Constants.USER_PERMISSION_URL_KEY, sysUserPo.getUserId());
        List<String> apiList = null;
        String urlJsonStr =(String) redisUtils.get(USER_PERMISSION_URL_KEY);

        // 1.从Redis获取用户权限URL集合
        if (urlJsonStr != null && urlJsonStr.length() > 0) {
            //apiList = JSON(urlJsonStr, List.class, String.class);
        }

        // 2.获取数据库中用户权限URL集合，并缓存
        if (apiList == null || apiList.size() <= 0) {
            //apiList = menuClient.queryApiList(sysUserPo.getUserId());
            //urlJsonStr = JsonUtils.toJson(apiList);
            redisUtils.set(USER_PERMISSION_URL_KEY, urlJsonStr);
            //logger.info("[{}] DB Permission URL：{}", cur, apiList.toString());
        }

        // 3.访问权限校验
        for (String url : apiList) {
            if (uri.startsWith(basePath + url)) {
                // 拥有权限访问
                //logs(user.getId(), user.getAccount().getAccount(), user.getName(), ip, uri, method, params, body, "登陆验证接口", "权限校验完毕，通过请求.");
                //logger.info("[{}] Result：{}", cur, "OK , 权限校验完毕.");
                //logger.info("[{}] Result：{}", cur, "OK , 本次请求通过，即将进入接口...");
                return true;
            }
        }

        // 没有权限访问
        //logs(user.getId(), user.getAccount().getAccount(), user.getName(), ip, uri, method, params, body, "登陆验证接口", "本次请求权限不足.");
        //logger.info("[{}] Result：{}", cur, "Error , 本次请求权限不足.");
        //Result result = Result.ERROR(ERROR_CODE.ERR_URL_PERMISSION_DENIED);
        //handlerErrorReq(response, result);
        return false;
    }
}
