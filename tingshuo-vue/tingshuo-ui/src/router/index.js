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
    meta: { title: '主页' },
    component: () => import('../views/Home/index.vue'),
    //多个菜单下面的子集
    children: [
      {
        path: '/index',
        name: 'index',
        meta: { title: '首页' },
        component: () => import('../views/Home/index/index.vue'),
      },
      {
        path: '/user',
        name: 'user',
        meta: { title: '用户' },
        component: () => import('../views/Home/user/index.vue')
      },
      {
        path: '/showlog/list',
        name: 'showlog',
        meta: { title: '查看日志' },
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
//基础的路由拦截：前置路由守卫 to 去哪，from 离开，next管道钩子
router.beforeEach(function (to, from, next) {
  if (!sessionStorage.getItem("userId")) {
    if (to.path != '/login') {
      next('/login');
    }
  };
  next();
})
export default router
