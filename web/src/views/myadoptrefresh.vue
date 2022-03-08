<template>
  <main role="main">
    <div class="album py-5 bg-light">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <pagination ref="pagination" v-bind:list="listPlants"></pagination>
          </div>
        </div>
        <br>
        <div class="row">
          <div v-for="plant in plants" class="col-md-4">
            <div class="card mb-4 shadow-sm">
                <img class="img-fluid" v-bind:src="plant.image">
              <div class="card-body">
                <h4 class="">{{plant.name}}</h4>
                <p class="card-text" style="width:300px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">{{plant.summary}}</p>
                <div class="d-flex justify-content-between align-items-center">

                  <div class="btn-group">
                    <p class="course-head-button-links">
                      &nbsp;&nbsp;&nbsp;&nbsp;
                      &nbsp;&nbsp;&nbsp;&nbsp;
                      &nbsp;&nbsp;&nbsp;&nbsp;
                      &nbsp;&nbsp;&nbsp;&nbsp;
                      &nbsp;&nbsp;&nbsp;
                      <button  class="btn btn-lg btn-success btn-shadow disabled" v-on:click="cancelAdopt(plant.id)">取消领养</button>
                    </p>
                  </div>


                </div>
              </div>
            </div>


<!--            <the-plant v-bind:plant="o"></the-plant>-->
          </div>
          <h3 v-show="plants.length === 0">没有领养的植物</h3>
        </div>
      </div>
    </div>

  </main>
</template>

<script>
import ThePlant from "@/components/the-plant";
import Pagination from "@/components/pagination";
import TheLogin from "@/components/login";
export default {
  name: "myadoptrefresh",
  components: {Pagination, ThePlant,TheLogin},
  data: function (){
    return{
      loginMember: {},
      plants:[],
      PLANT_STATUS:PLANT_STATUS,
    }
  },
  mounted() {
    let _this = this;
    _this.loginMember = Tool.getLoginMember()||{};
    _this.$refs.pagination.size=6
    _this.listPlants(1, _this.loginMember.id);

  },
  methods: {
    listPlants(page){
      let _this = this;
      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/web/memberPlant/myadopt",{
        page: page,
        size: _this.$refs.pagination.size,
        memberId:_this.loginMember.id
      }).then((response) => {
        console.log("查询用户列表结果", response);
        let resp = response.data;
        if(resp.success){
          _this.plants = resp.content.list;
          _this.$refs.pagination.render(page,resp.content.total);
          console.log(resp)
        }
      })
    },
    cancelAdopt(plantId){
      let _this = this;
      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/web/memberPlant/cancelAdopt",{
        size: _this.$refs.pagination.size,
        memberId:_this.loginMember.id,
        plantId:plantId
      }).then((response) => {
        console.log("查询用户列表结果", response);
        let resp = response.data;
        if(resp.success){
          console.log(resp);
          Toast.success("取消领养成功");
          _this.$router.push("/myadopt");
          // _this.$router.go(0);
        }
      })

    },
  }
}
</script>

<style scoped>
.title1{
  margin-bottom: 2rem;
  color: #fafafa;
  letter-spacing: 0;
  text-shadow: 0px 1px 0px #999, 0px 2px 0px #888, 0px 3px 0px #777, 0px 4px 0px #666, 0px 5px 0px #555, 0px 6px 0px #444, 0px 7px 0px #333, 0px 8px 7px #001135;
  font-size: 2rem;
}
</style>