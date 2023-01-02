<template>
  <div class="login">
    <h1>听说微服务管理学习系统</h1>
    <h2 class="title" style="padding-left:22px;">login</h2>
    <div>
      <!-- rules 表示添加校验的内容 -->
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <!-- prop需要校验的参数值 -->
        <el-form-item label="用户名称" prop="userId">
          <el-input v-model="ruleForm.userId" auto-complete="off" placeholder="用户名称"></el-input>
        </el-form-item>
        <el-form-item label="用户密码" prop="password">
          <el-input type="password" v-model="ruleForm.password" auto-complete="off" placeholder="用户密码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login()">登录</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<!-- 方法 -->
<script>
//导出方法
export default {
  name: "Login",
  //函数、闭包：局部变量全局化
  data() {
    return {
      ruleForm: {
        userId: "",
        password: "",
      },
      rules: {
        userId: [
          { required: true, message: "请输入用户名称", trigger: "blur" },
          { min: 1, max: 5, message: "长度在 1 到 5 个字符", trigger: "blur" },
        ],
        password: [
          { required: true, message: "请输入用户密码", trigger: "blur" },
          { min: 1, max: 5, message: "长度在 1 到 5 个字符", trigger: "blur" },
        ],
      },
      msg:''
    };
  },
  methods: {
    // login(formName) {
    //   this.$refs[formName].validate((valid) => {
    //     if (valid) {
    //       alert("submit!");
    //     } else {
    //       console.log("error submit!!");
    //       return false;
    //     }
    //   });
    // },
    login() {
      let {userId,password}=this.ruleForm;
      this.$http({
        method:'post',
        url:'/login',
        data:{userId:userId,password:password}
      }).then(res=>{//res后端接口返回的结果
        console.log(res);
        let {code,msg}=res.data;// eslint-disable-line no-unused-vars
        if(code=='200'){
          console.log(res);
          //缓存用户到浏览器
          sessionStorage.setItem("userId",userId);
          //将用户基本信息存储到浏览器中
          sessionStorage.setItem("userInfo",JSON.stringify(res.data));
          //跳转到指定页面
          this.$router.push('/home');
          
        }else{
        alert(msg);
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>


<!-- 样式文件 -->
<style lang="scss" scoped>
  .login-container {
    -webkit-border-radius: 5px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    background-clip: padding-box;
    margin: 100px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
    .title {
      margin: 0px auto 30px auto;
      text-align: center;
      color: #505458;
    }
    .remember {
      margin: 0px 0px 35px 0px;
    }
  }
