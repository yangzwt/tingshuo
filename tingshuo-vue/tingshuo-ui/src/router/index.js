import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter)
//配置路由 const routes 不能写成 routers
//配置静态路由
const routes = [
  {
    path: '/',
    //name: "Home",
    //component: Home,
    //重定向到某个页面
    redirect: '/home'

  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/home',
    name: 'home',
    component: () => import('../views/Home/index.vue'),
    //多个菜单下面的子集
    children: [
      {
        path: '/index',
        name: 'index',
        component: () => import('../views/Home/index/index.vue'),
      },
      {
        path: '/user',
        name: 'user',
        component: () => import('../views/Home/user/index.vue')
      },
      {
        path: '/showlog/list',
        name: 'showlog',
        component: () => import('../views/Log/log.vue')
      }
    ]
  },
]

const router = new VueRouter({
  mode: 'hash',
  //可以配置hash和history
  routes
})
export default router
