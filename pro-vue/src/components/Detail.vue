<template>
  <div id="details">
    <!-- 头部 -->
    <div class="page-header">
      <div class="title">
        <p></p>
        <div class="list">
          <ul>
            <li>
              <router-link to>概述</router-link>
            </li>
            <li>
              <router-link to>客服</router-link>
            </li>
            <li>
              <router-link to>关于我们</router-link>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <!-- 头部END -->

    <!-- 主要内容 -->
    <div class="main">
      <!-- 左侧商品轮播图 -->
      <div class="block">
        <el-image :src="url"></el-image>
      </div>
      <!-- 左侧商品轮播图END -->

      <!-- 右侧内容区 -->
      <div class="content">
        <h1 class="name">{{ address }}</h1>
        <p class="intro"></p>
        <p class="store">楼层质量有保障</p>
        <div class="price">
          <span>{{ price }}</span>
        </div>
        <div>{{ roomDescribe }}</div>
        <div class="pro-list">
          <span class="pro-name">
            类型:<span>{{ type }}</span></span
          >
          <span class="pro-price">
            面积:<span>{{ area }}</span>
          </span>
          <p class="price-sum">
            所剩套数:<span>{{ total }}</span>
          </p>
        </div>
        <!-- 内容区底部按钮 -->
        <div class="button">
          <el-button class="shop-cart">点击喜欢</el-button>
        </div>
        <!-- 内容区底部按钮END -->
        <div class="pro-policy">
          <ul>
            <li><i class="el-icon-circle-check"></i> 首付最低一万</li>
            <li><i class="el-icon-circle-check"></i> 期房现房双重选择</li>
            <li><i class="el-icon-circle-check"></i> 月供最底2000</li>
          </ul>
        </div>
      </div>
      <!-- 右侧内容区END -->
    </div>
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
    <!-- 主要内容END -->
  </div>
</template>
<script>
export default {
  name: "Detail",
  data() {
    return {
      url: "../../static/img/img.jpeg",
      address: "",
      id: "",
      price: "",
      area: "",
      total: "",
      type: "",
    };
  },
  created() {
    this.getList();
  },
  methods: {
    getList() {
      this.id = this.$route.query.roomId;
      this.axios
        .post("/api/findRoomById", {
          roomId: this.id,
        })
        .then((response) => {
          this.type = response.data[0].type;
          this.address = response.data[0].address;
          this.price = response.data[0].price;
          this.area = response.data[0].area;
          this.total = response.data[0].total;
          this.roomDescribe = response.data[0].roomDescribe;
        });
    },
  },
};
</script>
<style scoped>
/* 头部CSS */
#details .page-header {
  height: 64px;
  margin-top: -20px;
  z-index: 4;
  background: #fff;
  border-bottom: 1px solid #e0e0e0;
  -webkit-box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.07);
  box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.07);
}

#details .page-header .title {
  width: 1225px;
  height: 64px;
  line-height: 64px;
  font-size: 18px;
  font-weight: 400;
  color: #212121;
  margin: 0 auto;
}

#details .page-header .title p {
  float: left;
}

#details .page-header .title .list {
  height: 64px;
  float: right;
}

#details .page-header .title .list li {
  float: left;
  margin-left: 20px;
}

#details .page-header .title .list li a {
  font-size: 14px;
  color: #616161;
}

#details .page-header .title .list li a:hover {
  font-size: 14px;
  color: #ff6700;
}

/* 头部CSS END */

/* 主要内容CSS */
#details .main {
  width: 1225px;
  height: 560px;
  padding-top: 30px;
  margin: 0 auto;
}

#details .main .block {
  float: left;
  width: 560px;
  height: 560px;
}

#details .el-carousel .el-carousel__indicator .el-carousel__button {
  background-color: rgba(163, 163, 163, 0.8);
}

#details .main .content {
  float: left;
  margin-left: 25px;
  width: 640px;
}

#details .main .content .name {
  height: 30px;
  line-height: 30px;
  font-size: 24px;
  font-weight: normal;
  color: #212121;
}

#details .main .content .intro {
  color: #b0b0b0;
  padding-top: 10px;
}

#details .main .content .store {
  color: #ff6700;
  padding-top: 10px;
}

#details .main .content .price {
  display: block;
  font-size: 18px;
  color: #ff6700;
  border-bottom: 1px solid #e0e0e0;
  padding: 25px 0 25px;
}

#details .main .content .price .del {
  font-size: 14px;
  margin-left: 10px;
  color: #b0b0b0;
  text-decoration: line-through;
}

#details .main .content .pro-list {
  background: #f9f9fa;
  padding: 30px 60px;
  margin: 50px 0 50px;
}

#details .main .content .pro-list span {
  line-height: 30px;
  color: #616161;
}

#details .main .content .pro-list .pro-price {
  float: right;
}

#details .main .content .pro-list .pro-price .pro-del {
  margin-left: 10px;
  text-decoration: line-through;
}

#details .main .content .pro-list .price-sum {
  color: #ff6700;
  font-size: 24px;
  padding-top: 20px;
}

#details .main .content .button {
  height: 55px;
  margin: 10px 0 20px 0;
}

#details .main .content .button .el-button {
  float: left;
  height: 55px;
  font-size: 16px;
  color: #fff;
  border: none;
  text-align: center;
}

#details .main .content .button .shop-cart {
  width: 340px;
  background-color: #ff6700;
}

#details .main .content .button .shop-cart:hover {
  background-color: #f25807;
}

#details .main .content .button .like {
  width: 260px;
  margin-left: 40px;
  background-color: #b0b0b0;
}

#details .main .content .button .like:hover {
  background-color: #757575;
}

#details .main .content .pro-policy li {
  float: left;
  margin-right: 20px;
  color: #b0b0b0;
}

.footer {
  background: #2f2f2f;
  height: 100px;
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
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

/* 主要内容CSS END */
</style>
