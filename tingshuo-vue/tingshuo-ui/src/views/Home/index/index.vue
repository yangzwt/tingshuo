<template>
  <div id="app">
    <h1>首页</h1>
    <!-- 跑马灯效果-即轮播图 -->
    <Carousel></Carousel>
  </div>
</template>
<script>
import Carousel from "@/views/Home/Carousel";
export default {
  components: {
    Carousel,
  },
  data() {
    return {};
  },
};
</script>
