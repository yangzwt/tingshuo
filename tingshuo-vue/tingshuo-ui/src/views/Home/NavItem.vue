<template>
  <div>
    
      <!-- 匹配对应的样式 -->
      <!--default-active="1"-->
      <!-- 无子级 -->
      <el-menu-item :index="basePath" v-if="!item.child">
        <i class="el-icon-menu"></i>
        <span slot="title">{{item.name}}</span>
      </el-menu-item>
     
      <!-- 有子级 -->
      <el-submenu v-else :index="basePath">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span slot="title">{{item.name}}</span>
        </template>
        <!-- 遍历不断自调 -->
        <NavItem v-for="child in item.child" :key="child.url"
                                            :item="child" 
                                            :basePath="child.url"/>
      </el-submenu>

  </div>
</template>
<script>
export default {
  name:'NavItem',
  data() {
    return {
      
    }
  },
  props:['item','basePath']
};
</script>
