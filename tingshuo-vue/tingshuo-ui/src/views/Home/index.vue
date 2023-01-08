<template>
  <div class="home">
    <h1>home</h1>
    <!-- 显示当前时间插件 -->
    <!-- <el-calendar v-model="value"> </el-calendar> -->
    <!--左侧导航开始-->
    <el-container>
      <Nav></Nav>
      <!--左侧导航结束-->
      <el-container>
        <!-- 头部信息 -->
        <el-header style="text-align: right; font-size: 12px">
          <!--面包屑  -->
          <Breadcrumb></Breadcrumb>
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
            <el-button class="exit" type="primary" @click="goExit()"
              >退出系统</el-button
            >
          </div>
        </el-header>

        <el-main>
          <!-- 主体部分 -->
          <!--路径到指定页面  -->
          <router-view></router-view>
          <!-- 跑马灯效果-即轮播图 -->
          <Carousel></Carousel>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script >
import Nav from "./Nav";
import Breadcrumb from "./Breadcrumb";
import Carousel from "./Carousel";
export default {
  components: {
    Nav,
    Breadcrumb,
    Carousel
  },
  data() {
    return {
      value: new Date(),
    };
  },
  methods: {
    goExit() {
      this.$router.push("/login");
      //退出时清空缓存信息
      sessionStorage.removeItem("userId");
      sessionStorage.removeItem("userInfo");
    },
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