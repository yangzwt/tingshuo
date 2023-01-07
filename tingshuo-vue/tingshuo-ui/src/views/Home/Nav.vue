<template>

    <!-- <el-menu

        default-active="1"
        class="el-menu-vartical-demo"
        router> -->
    <el-menu
      :default-active="$route.path"
      exact
      class="el-menu-vartical-demo"
      background-color="#545c64"
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
          name: "用戶管理",
          url: "/user"
        },
        {
          name: "日志管理",
          url: "/showlog",
          child: [
            {
              name: "日志展示",
              url: "/showlog/list"
            }
          ],
        },
      ],
    };
  },
  components:{NavItem}
};
</script>
