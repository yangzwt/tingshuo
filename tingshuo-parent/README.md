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

2. 优化：访问日志查询优化
# 13.项目打包
已经完成
# 14.完成定时任务
1. 使用org.quartz-scheduler定时任务：支持页面修改和启动，初版完成。
2. 完成定时任务开发，支持数据输入。
# 15.认证授权使用spring-security

# 16.使用sleuth + zipkin 进行日志记录(链路追踪)
**1.**使用sleuth 进行收集日志，并将日志进行打印

**2.**需要在服务端，进行pom.xml文件引入和application.yml配置相关依赖即可
# 进行日志采集
	spring:
		sleuth:
			sampler:
        		probability: 1.0 #日志采用级别1.0 表示全部采集
    	zipkin:
        	base-url: http://localhost:9411 # 指定zipkin服务器的地址和端口号
			sender:
				type: web ## 设置用http方式传输数据
## 注意日志讲解
	INFO [tingshuo-test,e7a55e23964bdac3,e7a55e23964bdac3,true] 22824 --- [nio-8080-exec-1] com.zaxxer.hikari.HikariDataSource: HikariPool-1 - Start completed.

### tingshuo-test : 微服务名称
### e7a55e23964bdac3 -表示tranceld 一条链路中只要一个Tranceld
### e7a55e23964bdac3 -表示spanid
### true -表示 将信息输出到zipkin上面进行页面展示，默认为false 是否将数据输出到其他服务中。
### 22824 -表示唯一线程id
**3**.设置用http方式传输数据
## 改为postgresql 
###配置文件: 
    zipkin-server-shared.yml
zipkin默认支持mysql
## 修改为
    postgresql:
		host: ${PG_HOST:localhost}
		port: ${PG_TCP_PORT:3306}
		username: ${PG_USER:}
		password: ${PG_PASS:}
		db: ${PG_DB:zipkin}
		max-active: ${PG_MAX_CONNECTIONS:10}
		use-ssl: ${PG_USE_SSL:false}
