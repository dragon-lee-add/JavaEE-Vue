<template>
    <div>
      <!--中间登录框-->
      <div class="content">
        <div class="login">
            <h3>客户登录</h3>
            <el-form :model="loginForm" status-icon :rules="rules" ref="loginForm" label-width="100px"
              class="demo-loginForm">
              <el-form-item label="账 号" prop="userId">
                <el-input type="text" v-model="loginForm.userId" autocomplete="off" placeholder="电话/身份证号"></el-input>
              </el-form-item>
              <el-form-item label="密 码" prop="passWord">
                <el-input type="password" v-model="loginForm.passWord" autocomplete="off"  placeholder="6位数">
                </el-input>
              </el-form-item>
              <el-form-item prop="rememberPwd">
                <div class="remberBox">
                  <el-checkbox v-model="loginForm.remember" />
                  记住密码
                </div>
              </el-form-item>
              <el-form-item class="box">
                <el-button type="primary" @click="submitForm('loginForm')" size="small ">登录</el-button>
                <el-button type="primary" @click="registerBtn()" size="small">注册</el-button>
              </el-form-item>
            </el-form>
        </div>
      </div>
    </div>
  </template>
  
  <script>
    export default {
      name: 'Login',
      data() {
        return {
          underline: false,
          loginForm: {
            userId: '',
            passWord: '',
            remember: false
          },
          rules: {
            userId: [
              { required: true, message: '请输入账号', trigger: 'blur' },
              { min: 5, max: 12, message: '长度在 5 到 12 个字符', trigger: 'blur' }
            ],
            passWord: [
              { required: true, message: '请输入密码', trigger: 'blur' },
              { min: 5, max: 16, message: '长度在 5 到 16个字符', trigger: 'blur' }
            ],
  
          },
        };
      },
      created() {
        let account = sessionStorage.getItem("userId")
        let password = sessionStorage.getItem("passWord")
        // 如果存在赋值给表单，并且将记住密码勾选
        if (account) {
          this.loginForm.userId = account
          this.loginForm.passWord = password
          this.loginForm.remember = true
        }
      },
      methods: {
        submitForm(formName) {
          this.$refs[formName].validate((valid) => {
            if (valid) {
              let _this = this;
              this.axios.post('/api/loginClient', {
                userId: _this.loginForm.userId,
                passWord: _this.loginForm.passWord
              }).then(response => {
                 console.log(response.data.code)
                if (response.data.code==200) {
                //   if (this.loginForm.remember == true) {
                //     sessionStorage.setItem("userId", this.loginForm.userId);
                //     sessionStorage.setItem("passWord", this.loginForm.passWord);
                //   }
                  sessionStorage.setItem("userId", this.loginForm.userId);
                  sessionStorage.setItem('isLogin', 1);//登录判断,自定义赋值
                  //页面跳转
                  this.$router.push("/");
                  this.$message({
                    message: '恭喜你，登录成功',
                    type: 'success'
                  });
                }
                else {
                  this.$message.error('请检查用户名或密码');
                }
              })
            } else {
              return false;
            }
          });
        },
        resetForm(formName) {
          this.$refs[formName].resetFields();
        },
        registerBtn() {
          this.$router.push("/Register");
        }
      }
    }
  </script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
    /deep/ .el-form-item__content {
      line-height: 5px;
    }
  
    /deep/ .el-form-item__label {
      font-size: 18px;
      font-weight: bold;
    }
  
    .el-divider {
      background-color: rgb(180, 174, 174);
      margin-left: 120px;
    }

    h3 {
      text-align: center;
      margin-bottom: 10px;
    }
  
    .background {
      width: 100%;
      height: 100%;
      background-size: 100% 100%;
      position: fixed;
      z-index: -1;
    }
  
    .content {
      height: 350px;
      width: 100%;
      background: rgba(171, 175, 177, 0.3);
      position: absolute;
      top: 25%;
    }
  
    .login {
      position: absolute;
      top: 50%;
      left: 50%;
      -webkit-transform: translate(-50%, -50%);
      -moz-transform: translate(-50%, -50%);
      -ms-transform: translate(-50%, -50%);
      -o-transform: translate(-50%, -50%);
      transform: translate(-50%, -50%);
      width: 360px;
      padding: 16px;
      border-radius: 15px;
      box-shadow: 5px 5px 5px #aeccee;
      background-color: rgb(246, 250, 250);
    }
  
  
    .el-form {
      font-size: 25px;
      font-weight: bold;
    }
  
    
    
  
  </style>