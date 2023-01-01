<template>
  <div class="app">
    <h1>home</h1>
    <!-- 显示当前时间插件 -->
    <el-calendar v-model="value">
    </el-calendar>
  </div>
</template>

<script >
export default {
  data () {
    return {
      value: new Date()
    }
  }
}
</script>