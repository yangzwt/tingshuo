<template>
  <div class="home">
    <h1>home</h1>
    <!-- 显示当前时间插件 -->
    <el-calendar v-model="value"> </el-calendar>
    <!--左侧导航开始-->
    <el-container>
      <Nav></Nav>
      <!--左侧导航结束-->

      <el-container>
        <!-- 头部信息 -->
        <el-header style="text-align: right; font-size: 12px">
          <!--面包屑  -->
          <!-- <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item><a href="/">活动管理</a></el-breadcrumb-item>
            <el-breadcrumb-item>活动列表</el-breadcrumb-item>
            <el-breadcrumb-item>活动详情</el-breadcrumb-item>
          </el-breadcrumb> -->
          <div>
            <el-badge :value="12" class="item">
              <el-button size="small">未读消息</el-button>
            </el-badge>
            <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>查看</el-dropdown-item>
              <el-dropdown-item>新增</el-dropdown-item>
              <el-dropdown-item>删除</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>王小虎</span>
            <el-button class="exit" type="primary">退出系统</el-button>
          </div>
        </el-header>

        <el-main>
          <!-- 主体部分 -->
          <el-table>
            <el-table-column prop="date" label="日期" width="140">
            </el-table-column>
            <el-table-column prop="name" label="姓名" width="120">
            </el-table-column>
            <el-table-column prop="address" label="地址"> </el-table-column>
          </el-table>
          <!--路径到指定页面  -->
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script >
import Nav from "./Nav"; 
export default {
  components: {
    Nav,
  },
  data() {
    return {
      value: new Date(),
    };
  },
};
</script>

<style scoped lang="scss">
.home {
  position: absolute;
  top: 0px;
  left: 0px;
  right: 0px;
  bottom: 0px;
  // background: rgba(224, 234, 235, 0.1);
}
/* .home {
    width: 900px;
    margin: 0 auto;
    padding: 25px 0;
  }
  .home > .banner {
    text-align: center;
    padding: 25px 0;
    margin: 25px 0;
  } */
</style>