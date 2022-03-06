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
          <div v-for="o in plants" class="col-md-4">
            <the-plant v-bind:plant="o"></the-plant>
          </div>
          <h3 v-show="plants.length === 0">没有待领养的植物</h3>
        </div>
      </div>
    </div>

  </main>
</template>

<script>
import ThePlant from "@/components/the-plant";
import Pagination from "@/components/pagination";
export default {
  name: "list",
  components: {Pagination, ThePlant},
  data: function (){
    return{
      plants:[],
    }
  },
  mounted() {
    let _this = this;
    _this.$refs.pagination.size=6
    _this.listPlants(1);
  },
  methods: {
    listPlants(page){
      let _this = this;
      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/web/plant/list",{
        page: page,
        size: _this.$refs.pagination.size
      }).then((response) => {
        console.log("查询用户列表结果", response);
        let resp = response.data;
        if(resp.success){
          _this.plants = resp.content.list;
          _this.$refs.pagination.render(page,resp.content.total);
          console.log(resp)
        }
      })
    }
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