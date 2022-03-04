<template>
  <div>
    <p>
      <button v-on:click="list(1)" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-refresh"></i>
        刷新
      </button>
    </p>
    <pagination ref="pagination" v-bind:list="list" v-bind:itemCount="8"></pagination>
    <table id="simple-table" class="table  table-bordered table-hover">
      <thead>
      <tr>
         <th>id</th>

         <th>会员名称</th>

         <th>绿植名称</th>

         <th>领取时间</th>
        <th>操作</th>
      </tr>

      </thead>

      <tbody>
      <tr v-for="memberPlant in memberPlants">
              <td>{{memberPlant.id}}</td>
              <td>{{memberPlant.memberId}}</td>
              <td>{{memberPlant.plantId}}</td>
              <td>{{memberPlant.at}}</td>
        <td>

          <div class="hidden-sm hidden-xs btn-group">
            <button v-on:click="del(memberPlant.id)" class="btn btn-xs btn-danger">
              <i class="ace-icon fa fa-trash-o bigger-120"></i>
            </button>
          </div>
        </td>
      </tr>
      </tbody>
    </table>
    <div id="form-modal" class="modal fade" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">表单</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
                <div class="form-group">
                  <label class="col-sm-2 control-label">会员id</label>
                  <div class="col-sm-10">
                    <input v-model="memberPlant.memberId" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">绿植id</label>
                  <div class="col-sm-10">
                    <input v-model="memberPlant.plantId" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">报名时间</label>
                  <div class="col-sm-10">
                    <input v-model="memberPlant.at" class="form-control">
                  </div>
                </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button v-on:click="save()" type="button" class="btn btn-primary">保存</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
  </div>
</template>

<script>
import Pagination from "../../components/pagination";

export default {
  name: "business-memberPlant",
  components: {Pagination},
  data: function () {
    return {
      memberPlant: {},
      memberPlants: [],
    }
  },
  mounted() {
    let _this = this;
    _this.$refs.pagination.size = 5;
    _this.list(1);

    //sidebar激活样式方法一
    // this.$parent.activeSidebar("business-memberPlant-sidebar");
  },
  methods: {
    add() {
      //这个add的作用就是点开那个模态框，新增是save
      let _this = this;
      _this.memberPlant = {}
      $("#form-modal").modal('show');
    },
    edit(memberPlant) {
      //这个add的作用就是点开那个模态框，新增是save
      let _this = this;
      _this.memberPlant = $.extend({}, memberPlant);
      $("#form-modal").modal('show');
    },
    list(page) {
      let _this = this;
      Loading.show();
      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/memberPlant/list",
          {
            page: page,
            size: _this.$refs.pagination.size
          }).then((response) => {
        Loading.hide();
        console.log("查询会员领取植物列表结果", response);
        let resp = response.data;
        _this.memberPlants = resp.content.list;
        _this.$refs.pagination.render(page, resp.content.total);
      })
    },
    save() {
      let _this = this;
        // 保存校验
        if (1 != 1
          || !Validator.require(_this.memberPlant.memberId, "会员id")
          || !Validator.require(_this.memberPlant.plantId, "绿植id")
          || !Validator.require(_this.memberPlant.at, "报名时间")
        ) {
          return;
        }

      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/memberPlant/save",
          _this.memberPlant).then((response) => {
        console.log("查询会员领取植物列表结果", response);
        let resp = response.data;
        if (resp.success) {
          $("#form-modal").modal('hide');
          _this.list(1)
          Toast.success("保存成功");
        }else{
          Toast.warning(resp.message);

        }
      })
    },
    del(id) {
      let _this = this;
      Confirm.show("删除会员领取植物后不可恢复!",function () {
        Loading.show();
        _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/memberPlant/delete/" + id).then((response) => {
          console.log("删除会员领取植物列表结果", response);
          let resp = response.data;
          if (resp.success) {
            Toast.success("删除成功");
            _this.list(1);

          }
        })
    });
    }

  }
}
</script>