# 项目简介

tingshuo-ui

技术选型：

1. Vue2.5.1+
2. Vue-router
3. Element-UI
4. Axios
5. Echars



## 	1.项目创建

安装脚手架

通过vue脚手架创建vue create tingshuo-ui

或cmd命令行执行 vue ui

C:\Users\YangZong>vue ui
🚀  Starting GUI...
🌠  Ready on http://localhost:8001

访问地址：http://localhost:8001/project/select



## 2.引入element-ui

 npm i elements-ui -S或npm i elements-ui --save

 安装本地环境

 package.js文件中

 "dependencies": {

   "core-js": "^3.8.3",

   "element-ui": "^2.15.12",//安装element-ui

  }

 引入main.js

 import ElementUI from 'element-ui';

 import 'element-ui/lib/theme-chalk/index.css';

 Vue.use(ElementUI)

 测试是否成功

## 3.安装个性化字体

​	npm install font-awesome --save

## 4.安装路由

npm install vue-router --save

查看本地

"dependencies": { "vue-router": "^4.1.6" }

在src文件夹下创建router文件夹,再创建index.js文件以及创建路由组件

注意：const routes = []

/配置路由 const routes 不能写成 routers

const router = new VueRouter({

 	mode: 'hash',
 	
 	//可以配置hash和history

​	 routes

})

export default router

## 5.安装axios 

​	发送真实请求

## 6.页面布局

页面菜单固定

选择菜单时，主页展示对应的菜单内容

页面导航布局

左侧菜单。头部信息、面包屑、居中内容展示、右侧退出和消息提醒等

页面面包屑

面包屑：1.获取URL地址；2.将地址转换为中文名称

使用技术：watch监听路由，获取路由的对象：this.$route.matched

## 7.用户退出

​	this.$router.push("/login");

   //退出时清空缓存信息

   sessionStorage.removeItem("userId");

   sessionStorage.removeItem("userInfo");

注意：$router和$route的区别：$route获取路由对象，$router获取路由实例，包括路由的跳转方法，钩子函数等，也包含一些子对象（例如history）
常用的跳转连接的方法：
//常规方法

this.$router.push("/login");
//使用对象的形式 不带参数
this.$router.push({ path:"/login" });
//使用对象的形式，参数为地址栏上的参数
this.$router.push({ path:"/login",query:{username:"jack"} }); 
使用对象的形式 ，参数为params 不会显示在地址栏
this.$router.push({ name:'user' , params: {id:123} });

$ route是一个跳转的路由对象（路由信息对象），每一个路由都会有一个$route对象，是一个局部的对象。
1.$route.path
字符串，等于当前路由对象的路径，会被解析为绝对路径，如 “/home/news” 。

2.$route.params
对象，包含路由中的动态片段和全匹配片段的键值对。

3.route. query对象，包含路由中查询参数的键值对 。 例如 ，对于/home/news/detai l/01?favorite=yes ， 会 得 到 route.query 对象，包含路由中查询参数的键值对。例如，对于 /home/news/detail/01?favorite=yes ，会得到route.query对象，包含路由中查询参数的键值对。例如，对于/home/news/detail/01?favorite=yes，会得到route.query.favorite == ‘yes‘ 。

4.$route.router
路由规则所属的路由器（以及其所属的组件）。

5.$route.matched
数组，包含当前匹配的路径中所包含的所有片段所对应的配置参数对象。

6.$route.name
当前路径的名字，如果没有使用具名路径，则名字为空。

在页面上添加以下代码，可以显示这些路由对象的属性：

	/**<div>
	<p>当前路径：{{$route.path}}</p>
	<p>当前参数：{{$route.params | json}}</p>
	<p>路由名称：{{$route.name}}</p>
	<p>路由查询参数：{{$route.query | json}}</p>
	<p>路由匹配项：{{$route.matched | json}}</p>
	</div>*/
## 8.路由拦截

//基础的路由拦截：前置路由守卫 to 去哪，from 离开，next管道钩子

router.beforeEach(function (to, from, next) {

 if (!sessionStorage.getItem("userId")) {

  if (to.path != '/login') {

   next('/login');

  }

 };

 next();

})

## 9.组件递归

## 10.列表展示

1. 包括页面分页插件引用；
2. 支持用户输入查询条件；
3. 用户跑马灯效果即页面轮播效果；

## 11.动态获取菜单



## 12.页面布局样式





# 项目部署              

## 	1.项目安装依赖



```
npm install
```

## 2.项目运行
```
npm run serve
```

## 3.项目打包
```
npm run build
```

### Lints and fixes files
```
npm run lint
```
