<template>

    <!-- <el-menu

        default-active="1"
        class="el-menu-vartical-demo"
        router> -->
    <el-menu
      :default-active="$route.path"
      exact
      class="el-menu-vartical-demo"
      background-color="#000000"
      text-color="#fff"
      active-text-color="#ffd04b"
      router>
      <NavItem v-for="v in items" :key="v.url"
                                  :item="v" 
                                  :basePath="v.url"/>

      
    </el-menu>
    
 
</template>
<script>
import NavItem from './NavItem.vue';
export default {
  data() {
    return {
      id: 0,
      items: [
        {
          name: "首页",
          url: "/index"
        },
        {
          name: "系统管理",
          url: "",
          child: [
            {
              name: "用户管理",
              url: "/user"
            },
            {
              name: "角色管理",
              url: "/role"
            },
            {
              name: "菜单管理",
              url: "/menu"
            },
            {
              name: "部门管理",
              url: "/dept"
            },
            {
              name: "字典管理",
              url: "/dict"
            }
          ],
        },
        {
          name: "日志管理",
          url: "/showlog",
          child: [
            {
              name: "操作日志",
              url: "/showlog/list"
            },
            {
              name: "访问日志",
              url: "/showlog/list"
            }
          ],
        },
        {
          name: "OA管理",
          url: "/oa",
          child: [
            {
              name: "请假管理",
              url: "/leave"
            },
            {
              name: "出差管理",
              url: "/evection"
            }
          ],
        },
        {
          name: "财务管理",
          url: "/money",
          child: [
            {
              name: "理财管理",
              url: "/leave"
            },
            {
              name: "入账管理",
              url: "/evection"
            },
            {
              name: "出账管理",
              url: "/evection"
            }
          ],
        },
        {
          name: "监控管理",
          url: "/money",
          child: [
            {
              name: "服务监控",
              url: "/leave"
            },
            {
              name: "磁盘监控",
              url: "/evection"
            },
            {
              name: "数据库监控",
              url: "/evection"
            }
          ],
        },
        {
          name: "博客管理",
          url: "/money",
          child: [
            {
              name: "我的博客",
              url: "/leave"
            },
            {
              name: "我的草稿",
              url: "/evection"
            }
          ],
        },
        {
          name: "学习管理",
          url: "/money",
          child: [
            {
              name: "学习资源",
              url: "/leave"
            },
            {
              name: "学习账号",
              url: "/evection"
            }
          ],
        },
        {
          name: "健康管理",
          url: "/money",
          child: [
            {
              name: "我的健康",
              url: "/leave"
            },
            {
              name: "就医记录",
              url: "/evection"
            }
          ],
        },
      ],
    };
  },
  components:{NavItem}
};
</script>
