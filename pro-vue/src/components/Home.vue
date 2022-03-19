<template>
  <div class="content">
    <div class="topbar">
      <div class="nav">
        <ul class="ul-1">
          <li>
            <el-link href="#" target="_blank" :underline="false">官方商城</el-link>
            <el-divider direction="vertical" class="sep"></el-divider>
            <el-link href="#" target="_blank" :underline="false">MIUI</el-link>
            <el-divider direction="vertical" class="sep"></el-divider>
            <el-link href="#" target="_blank" :underline="false">云服务</el-link>
            <el-divider direction="vertical" class="sep"></el-divider>
            <el-link href="#" target="_blank" :underline="false">天星数科</el-link>
            <el-divider direction="vertical" class="sep"></el-divider>
            <el-link href="#" target="_blank" :underline="false">下载app</el-link>
            <el-divider direction="vertical" class="sep"></el-divider>
            <el-link href="#" target="_blank" :underline="false">协议规则</el-link>
            <el-divider direction="vertical" class="sep"></el-divider>
            <el-link href="#" target="_blank" :underline="false">Select Location</el-link>
          </li>
        </ul>
        <ul class="ul-2">
          <li v-if="!isLogin">
            <el-button type="text" @click="login">登录</el-button>
            <el-button type="text" @click="register">注册</el-button>
          </li>
          <li v-else>
            <el-popover placement="top-end" width="200" trigger="hover" :visible-arrow="false">
              <p>确定退出登录吗？</p>
              <div style="text-align: right; margin: 10px 0 0">
                <el-button size="mini" type="text" @click="visible = false">取消</el-button>
                <el-button type="primary" size="mini" @click="logout">确定</el-button>
              </div>
              <el-button type="text" slot="reference">
                欢迎{{name}}
              </el-button>
            </el-popover>
            <el-popover placement="top-end" width="200" trigger="hover" :visible-arrow="false" class="shopCart-li"
              content="暂无消息通知">
              <el-button type="text" slot="reference">
                <i class="el-icon-bell"></i>
                消息通知
              </el-button>
            </el-popover>
          </li>
        </ul>
      </div>
    </div>
    <!--轮播-->
    <div >
      <div class="carousel"> 
        <el-carousel :interval="4000" type="card" height="350px">
          <el-carousel-item v-for="(item,index) in List" :key="index">
            <el-image :src="item.image" style="height: 100%;width: 100%;"></el-image>
          </el-carousel-item>
        </el-carousel>
      </div>
    </div>
    <!--中间-->

    <div class="content-box">
      <div id="box">
        <h2 style="margin-bottom: 10px">房型展示</h2>
        <ul class="box-card">
          <li v-for="(item,index) in listGood" :key="index">
            <el-card>
              <div @click="homeDetail(item.roomId)">
                <el-image style="width: 100px; height: 100px;border-radius: 30%;" :src="url"></el-image>
                <p>面积：{{item.area}}</p>
                <p>价格：{{item.price}}</p>
                <p>房型：{{item.type}}</p>
                <p>位置：{{item.address}}</p>
              </div>
            </el-card>
          </li>
        </ul>
      </div>
    </div>

    <!-- 底栏容器 -->
    <div class="footer">
      <div class="footer-nav">
        <ul class="footer-li1">
          <li>
            <p>xx集团 版权所有</p>
            <p>渝ICP备05003852号-2</p>
          </li>
        </ul>
        <ul class="footer-li2">
          <li>
            <p>法律声明</p>
            <p>服务热线</p>
            <p>廉洁举报</p>
          </li>
        </ul>
      </div>
    </div>

    <!-- 底栏容器END -->
  </div>
</template>


<script>
  export default {
    data() {
      return {
        List: [],
        listGood: [],
        url: '../../static/img/img.jpeg',
        aa: "",
        name: ""
      }
    },
    created() {
      this.getSwiper();
      this.getList();
      this.isLogin = sessionStorage.getItem("isLogin");
      this.name = sessionStorage.getItem("userId");
    },
    methods: {
      getSwiper() {
        this.axios.get('../static/js/swiper.json', {
        }).then(response => {
          this.List = response.data.list

        })
      },
      getList() {
        this.axios.get('/api/findAllRoomVue', {
        }).then(response => {
          this.listGood = response.data
        })
      },
      homeDetail(roomId) {
        let isLogin = Boolean(sessionStorage.getItem("isLogin"));
        if (isLogin == true) {
          this.$router.push({ name: "Detail", query: { roomId } });
        } else {
          this.$notify({
            title: '提示',
            message: "请先注册登录"
          });
        }
      },
      login() {
        this.$router.push("/Login");
      },
      register() {
        this.$router.push("/Register");
      },
      logout() {
        location.reload();
        sessionStorage.removeItem("isLogin");
        sessionStorage.removeItem("userId");
      }
    },
  }
</script>

<style scoped>
  a:hover {
    text-decoration: none;
  }

  /*顶部*/
  .topbar {
    height: 40px;
    background-color: #3d3d3d;
  }

  .topbar .nav {
    width: 1225px;
    margin: 0 auto;

  }

  .topbar .nav .ul-1 {
    float: left;
  }

  .topbar .nav .ul-2 {
    float: right;

  }

  .topbar .nav li {
    /* float: left; */
    height: 40px;
    color: #b0b0b0;
    font-size: 14px;
    text-align: center;
    line-height: 40px;
    margin-left: 20px;
  }

  .topbar .nav .sep {
    color: #b0b0b0;
    font-size: 12px;
    margin: 0 5px;
  }

  .topbar .nav li .el-button {
    color: #b0b0b0;
  }

  .topbar .nav .el-button:hover {
    color: #fff;
  }

  .topbar .nav li a {
    color: #b0b0b0;
  }

  .topbar .nav a:hover {
    color: #fff;
  }

  .shopCart-li {
    display: inline-block;
    margin-left: 20px;
    height: 100%;
    width: 80px;
    background-color: #797575;
  }

  /*
*轮播图
*/
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

  .carousel {
    margin-top: 20px;
    width: 100%;
  }

  .box-card :hover {
    transform: scale(1.1);
    transition: all 1s ease 0s;
    -webkit-transform: scale(1.1);
    -webkit-transform: all 1s ease 0s;
  }

  /*
*底层
*/
  .footer {
    background: #2f2f2f;
    height: 80px;
    position: fixed;
    bottom: 0;
    right: 0;
    left: 0;
   
  }

  .footer-nav {
    width: 1225px;
    margin: 0 auto;
  }

  .footer li {
    height: 100px;
    color: #f5eeee;
    font-size: 18px;
    text-align: center;
    line-height: 100px;
    margin-left: 20px;
  }

  .footer p {
    display: inline;
  }

  .footer-li1 {
    float: left;
  }

  .footer-li2 {
    float: right;
  }


  .content-box {

    width: 700px;
    margin: auto;
    margin-bottom: 10px;
   
  }

  #box {
    width: 100%;
    padding: 5px;
    background-color: #fff7f7;

  }

  #box ul {
    display: flex;
    flex-wrap: wrap;
  }

  #box li {
    padding: 3px;
    list-style: none;
    margin-right: 15px;

  }

  #box img {
    width: 200px;
    height: 150px;
  }
</style>