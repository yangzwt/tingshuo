# 项目开发注意事项
# 1. springboot和SpringCloud版本对应关系
    https://start.spring.io/actuator/info
# 2.spring官网地址,查看springboot版本
    https://spring.io/projects/spring-boot#learn
# 3.tingshuo 微服务架构采用oracle12c pdb库
# 4.数据源连接时，12c，需要注意连接数据源，pom加载ojdbc8时需要特别注意
# 5.数据库使用pg数据库10.17
# 6.使用@Test进行代码初步测试12.12
# 7.提交tingshuo-项目的vue前端基础架构文件夹12.12 pm22:01
# 8.使用分页时注意事项
##com.github.pagehelper 和 pagehelper-spring-boot-starter
## 需要剔除 mybatis和mybatis-spring依赖 
# 9.完成基本分页查询操作：2021年12月14日22:50:59 
# 10.完成分层开发，待实现登录流程 2021年12月15日21:35:26
# 11.基础业务开发:
	
1. 完成用户基本信息查询；

2. 完成基本用户登录操作；

3. 完成角色分页查询操作；

4. 完成菜单查询操作； 

5. 完成机构部门查询操作；

6. 完成岗位信息查询操作；

7. 完成字典信息查询操作；

8. 完成系统参数设置查询操作；

9. 完成系统通告消息分页查询操作；

10. 完成系统操作日志分页查询操作；

11. 完成系统登录日志分页查询操作；

# 12.项目优化

#####优化内容
1. Api接口不用写@RestController，改为@RequestMapping("/")即可，业务实现类只需要写@RestController("/"),即可，减少代码冗余并美观。

2.  优化：访问日志查询优化