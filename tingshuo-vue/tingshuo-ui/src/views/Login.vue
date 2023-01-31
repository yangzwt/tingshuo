<template>
 
    
   <div class="login">
    <div class="background">
      <img src="@/assets/1.jpeg" width="100%" height="100%" alt="" />
    </div>
    <div class="box">
  <!-- rules 表示添加校验的内容 -->
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-position="left" label-width="100px" class="login-form">
        <h1>听说微服务管理学习系统</h1>
        <h2 class="title">login</h2>
        <!-- prop需要校验的参数值 class="el-input__icon"-->
        <el-form-item  label="用户名称" prop="userId">
          <el-input  class="username" v-model="ruleForm.userId" auto-complete="off" placeholder="用户名称"></el-input>
        </el-form-item>
        <el-form-item  label="用户密码" prop="password">
          <el-input  class="userpass" type="password" v-model="ruleForm.password" auto-complete="off" placeholder="用户密码"></el-input>
        </el-form-item>
        <el-form-item>
          <!-- <el-button type="primary" @click="login()">登录</el-button> -->
          <el-button type="primary" v-on:click="login()">登录</el-button>
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
        let {code,msg}=res.data;
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
// 监听回车键执行事件
keyDown (e) {
      // 回车则执行登录方法 enter键的ASCII是13
      if (e.keyCode === 13) {
        this.login() // 需要执行的方法方法
      }
    }
  },
  // 绑定监听事件
  mounted () {
    window.addEventListener('keydown', this.keyDown)
  },
  // 销毁事件
  destroyed () {
    window.removeEventListener('keydown', this.keyDown, false)
  },

};
</script>


<!-- 样式文件 -->
<style lang="scss" scoped>
 .login {
   width:100%;
   margin: 10px auto;
   position: relative;
 }
  .background{
    width: 100%;
    height: 800px;
    z-index:-1;
    position: absolute;
  }   
  .box{
    width:380px;
    height: 300px;
    top:50%;
    left: 50%;
    transform: translate(-50%,-50%);
    z-index: 999;
    position: fixed;
    border: 1px solid gold;
   }
   .login-form {
  //   border-radius: 6px;
  // background: #fc0101;
  // width: 400px;
  // padding: 25px 25px 5px 25px;
  width: 100%;
  margin: auto;
  .el-input {
    height: 38px;
    input {
      height: 38px;
    }
  }
  .input-icon {
    height: 39px;
    width: 14px;
    margin-left: 2px;
  }
}
  // .login-container {
  //   background-color: #da24bc;
  //   color: #ae0e61;
  //   //margin: 100px auto;
  //   width: 800px !important;
   
  //   padding: 35px 35px 15px 35px;
  //   background: #fff;
  //   border: 1px solid #eaeaea;
  // }

    .userpass,.username{
      width: 150px !important;
    }
    h1{
      margin: 0px auto 30px auto;
      text-align: center;
    }
    .title {
      margin: 0px auto 30px auto;
      text-align: center;
      color: #fc0303;
    }
  
    // .title {
     
    //   text-align: center;
    //   color: #f80505;
    // }
   
    
   
   /* .my >>>  .el-input__inner{
      width: 80px !important;
    } 
    .username.el-input__inner{
      width: 80px !important;
    }
    .password.el-input__inner{
      width: 80px !important;
    }
    .remember {
      margin: 0px 0px 35px 0px;
    } */
  
</style>