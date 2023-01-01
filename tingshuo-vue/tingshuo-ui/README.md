# 项目简介

tingshuo-ui

###### 	1.项目创建

​	vue create tingshuo-ui

###### 2.引入element-ui

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

###### 3.安装个性化字体

​	npm install font-awesome --save

###### 4.安装路由

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

###### 5.安装axios 

​	发送真实请求



#### 项目部署

###### 	1.项目安装依赖
```
npm install
```

###### 2.项目运行
```
npm run serve
```

###### 3.项目打包
```
npm run build
```

### Lints and fixes files
```
npm run lint
```
