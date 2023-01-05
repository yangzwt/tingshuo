<template>
        <div>
            <el-breadcrumb separator="/">
            <el-breadcrumb-item v-for="(v,i) in breadList" :key="i">
                <router-link :to="v.path">
                    {{v.meta.title}}
                </router-link>
            </el-breadcrumb-item>
        </el-breadcrumb>
    </div>
</template>
<!-- 面包屑：1.获取URL地址
    2.将地址转换为中文名称
-->
<script>

export default {
    data(){
        return {
            breadList:[]
        }
    },
    created(){
        //获取路由的对象
        console.log(this.$route.matched);
        this.breadList=this.$route.matched;
    },
    //监听路由变更url
    watch:{
        //to 第一个值  // to , from 分别表示从哪跳转到哪，都是一个对象
        $route(to,from){
            this.breadList=to.matched;
        }
    }
}
</script>