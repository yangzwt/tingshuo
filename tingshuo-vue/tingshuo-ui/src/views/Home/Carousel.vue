<template>
  <div>
    <el-carousel :interval="4000" type="card" height="200px">
      <el-carousel-item v-for="item in items" :key="item">
        <img :src ="item"/>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>
<script>
export default {
  data() {
    return {
      items: [
        //图片必须要加require+webpace会被解析成字符串
        require("@/assets/1.jpeg"),
        require("@/assets/2.jpeg"),
        require("@/assets/3.jpeg"),
        require("@/assets/4.jpeg"),
        require("@/assets/5.jpeg"),
        
      ],
    };
  },
};
</script>

<style>
/* .el-carousel__item h3 {
  color: #f60e06;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
} */
</style>