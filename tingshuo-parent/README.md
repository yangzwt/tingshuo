# 项目开发注意事项
# 0. 使用的springboot和springcloud版本：
    springboot +2.3.0.RELEASE+Hoxton.SR12
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
**3.**设置用http方式传输数据
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
#17.使用ribbon进行负载均衡
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
    </dependency>
#注意：
##1.负载使用的是客户端调用其他服务时配置bean

    @Bean
    @LoadBalanced
    public RestTemplate rebbionRestTemplate(){
        return new RestTemplate();
    }
##2.调用服务注意事项

    ##tingshuo-activity 是注册中心服务名称
    @Autowired
    RestTemplate restTemplate;
    
    @RequestMapping(value = "/helloTest",method = RequestMethod.GET)
    public String helloTest(){
        return restTemplate.getForObject("http://tingshuo-activity/hello",String.class);
    }
##3.application.yml配置详情
    #代表注册中心上服务的名字
    tingshuo-activity:
        #使用ribbon 负载均衡
        ribbon:
            #配置随机策略
            NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
            #服务地址
            listOfServers: http://192.168.31.215:8888,http://192.168.31.215:9999
#18.使用openfeign 远程调用
##注意
###1.使用时客户端，在入口新增
    @EnableFeignClients
    表示开启openfeign进行远程调用
###2.在pom引入
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-openfeign</artifactId>
    </dependency>
###3.引入接口调用方法：
    例如：
    //声明调用注册中心的服务端的id
    @FeignClient("tingshuo-activity")
    public interface ProductClient {
        //调用服务端的业务方法，请求参数要和服务端保持一致
        @GetMapping("/getString")
        String product();
    }
###4.新增hystrix进行服务熔断保护
    配置文件新增
    #开启熔断hystix支持
    feign:
        hystrix:
            enabled: true
    #调用其他服务接口的地方，新增fallback=容错的类
    @FeignClient(value = "注册中心的其他服务名",fallback = ProductClientHystrix.class)
    //继承调用服务的接口方法，实现
    @Component
    public class ProductClientHystrix implements ProductClient
###5.使用hystrix Dashboard 实现数据的可视化监控(单个地址监控)
    注意事项
    1.pom.xml新增
     <!--hystrix的监控依赖-->
       <dependency>
           <groupId>org.springframework.cloud</groupId>
           <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
       </dependency>
       <!--hystrix-dashboard服务监控-->
       <dependency>
           <groupId>org.springframework.cloud</groupId>
           <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
       </dependency>
    2.启动类信息
    @EnableHystrixDashboard
    @EnableCircuitBreaker
    特别注意boot2.0以上，手动声明bean
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet  =new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletRegistrationBean= new ServletRegistrationBean(hystrixMetricsStreamServlet);
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.addUrlMappings("/actuator/hystrix.stream");
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }
    3.配置文件新增
    #开启监控页面
    hystrix:
        dashboard:
            #监控的服务器ip
            proxy-stream-allow-list: "192.168.31.215"
    4.使用方法地址
    http://ip+port/hystrix
    输入
    http://ip+port/actuator/hystrix.stream即可
###6.使用turbine聚合监控数据(监控多个服务地址)
    1.pom.xml引入
    <!--使用turbine聚合监控数据-->
       <dependency>
           <groupId>org.springframework.cloud</groupId>
           <artifactId>spring-cloud-netflix-turbine</artifactId>
       </dependency>
    2.启动类新增
    @EnableTurbine
    3.配置文件
    #开启监控服务中心列表，表明监控哪些服务
    turbine:
        app-config: tingshuo-activity,tingshuo-test
        #聚合哪些集群，默认为default，多个,隔开
        aggregator:
            cluster-config: default

        # 集群名称，默认为应用名
​        cluster-name-expression: new String("default")
​    4.使用方式和上面一致
#19.使用config配置中心
#20.使用Apollo配置中心，支持动态实时更新
##1.配置文件使用
​    #app
​    app:
​        id: app001
​        #Apollo配置中心配置
​    apollo:
​        #将服务信息，缓存到本地目录
​        cache-dir: I:/app/
​        #指定使用那个集群
​        cluster: default
​        #连接服务器的地址信息 即注册中心地址
​        meta: http://localhost:8080
​        #是否开启 spring参数自动更新
​        autoUpdateInjectedSpringProperties: true
​            bootstrap:
​            #是否开启apollo
​                enabled: true
​            #设置namespace
​                namespaces: application
​                eagerLoad:
​            #将Apollo 加载提到初始化日志系统之前
​                    enabled: true
##2.pom.xml
​    <!--Apollo配置中心配置-->
​       <dependency>
​           <groupId>com.ctrip.framework.apollo</groupId>
​           <artifactId>apollo-client</artifactId>
​           <version>1.9.2</version>
​       </dependency>
##3.启动类新增支持
​    @EnableApolloConfig

### 23.安装elk

#### 1.Windows安装

下载elasticsearch、elasticsearch-head、kibana-7.6.2、logstash、filebate、kafaka安装包

##### 1.1、跨越访问设置

修改es的config目录下的elasticsearch.yml文件，添加

http.cors.enabled: true
http.cors.allow-origin: "*"

启动：I:\14elk\elasticsearch-7.6.2\bin\elasticsearch.bat

http://127.0.0.1:9200

##### 1.2、安装elasticsearch-head

全局安装：npm install -g grunt-cli

进入head的安装目录，运行npm install

启动：npm run start 

http://127.0.0.1:9100/

##### 1.3、安装kibana

修改汉化版

I:\14elk\kibana-7.6.2\config\kibana.yml

#i18n.locale: "en"
i18n.locale: "zh-CN"

启动：I:\14elk\kibana-7.6.2\bin\kibana.bat 

http://localhost:5601/

#### 2.linux安装

24.改用本地gitlab开发
2024年9月27日22:09:47
25.改用docker镜像部署