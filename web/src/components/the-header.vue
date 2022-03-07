<template>
  <header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container">
        <a class="navbar-brand" href="#">
          <i class="ace-icon fa fa-leaf"></i>&nbsp;绿植领养
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <router-link class="nav-link" to="/">主页</router-link>
            </li>
            <li class="nav-item active">
              <router-link class="nav-link" to="/list">全部绿植</router-link>
            </li>
            <li class="nav-item active">
              <router-link class="nav-link" to="/myadopt" v-on:click="adopt()">
              我的领养
              </router-link>
            </li>
            <form class="form-inline my-2 my-lg-0" method="post" action="">
              <input class="form-control mr-sm-2" type="search" placeholder="搜索你喜欢的植物" aria-label="Search" v-model="name">
              <router-link v-bind:to="'list?name=' + name" v-on:click.native="flushCom">
                <button class="btn btn-outline-success my-2 my-sm-0">搜索</button>
              </router-link>
            </form>


          </ul>

          <span v-show="loginMember.id" class="text-white pr-3">您好：{{loginMember.name}}</span>
          <button v-show="loginMember.id" v-on:click="logout()" class="btn btn-outline-light my-2 my-sm-0">退出登录</button>
          <button v-show="!loginMember.id" v-on:click="openLoginModal()" class="btn btn-outline-light my-2 my-sm-0">登录/注册</button>


<!--                    <span  class="text-white pr-3">您好：</span>-->
<!--                    <button  v-on:click="logout()" class="btn btn-outline-light my-2 my-sm-0">退出登录</button>-->
<!--                    <button  v-on:click="openLoginModal()" class="btn btn-outline-light my-2 my-sm-0">登录/注册</button>-->
        </div>
      </div>
    </nav>

<!--    <the-login ref="loginComponent"></the-login>-->
    <the-login ref="loginComponent"></the-login>
  </header>
</template>

<script>
import TheLogin from "@/components/login";
export default {
  name: "theHeader",
  components: {TheLogin},
  data: function () {
    return {
      loginMember: {},
      name:""
    }
  },
  mounted() {
    let _this = this;
    _this.loginMember = Tool.getLoginMember();

    console.log("name=====>>>>>>>>>>>>>>>",name);
  },
  methods: {
    flushCom(){
      let _this = this;
      _this.$router.go(0);
    },

  logout(){
    let _this = this;
    Tool.setLoginMember(null);
    _this.loginMember = {};
    Toast.success("退出登录成功");
    _this.$router.push("/");
  },
    openLoginModal() {
      let _this = this;
      _this.$refs.loginComponent.openLoginModal();
    },
    setLoginMember(loginMember) {
    let _this = this;
    _this.loginMember = loginMember;
    },
    adopt(){
      let _this = this;
      let loginMember = Tool.getLoginMember();
      if (Tool.isEmpty(loginMember)) {
        Toast.warning("请先登录");
        return;
      }
    }

  }
}
</script>

<style scoped>

</style>