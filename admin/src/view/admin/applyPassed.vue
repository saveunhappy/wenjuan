<template>
  <div>
    <p>
      <button v-on:click="add()" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-edit"></i>
        新增
      </button>
      &nbsp;
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

         <th>昵称</th>

         <th>绿植名称</th>

         <th>家庭住址</th>

         <th>用户手机号</th>

         <th>状态</th>

         <th>用户id</th>

         <th>绿植id</th>


        <th>操作</th>
      </tr>

      </thead>

      <tbody>
      <tr v-for="apply in applys">
              <td>{{apply.id}}</td>
              <td>{{apply.name}}</td>
              <td>{{apply.plantName}}</td>
              <td>{{apply.userAddress}}</td>
              <td>{{apply.userTelephone}}</td>
              <td>{{APPLY_STATUS | optionKV(apply.status)}}</td>
              <td>{{apply.userId}}</td>
              <td>{{apply.plantId}}</td>
        <td>

          <div class="hidden-sm hidden-xs btn-group">
            <button v-on:click="edit(apply)" class="btn btn-xs btn-info">
              <i class="ace-icon fa fa-pencil bigger-120"></i>
            </button>

            <button v-on:click="del(apply.id)" class="btn btn-xs btn-danger">
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
                  <label class="col-sm-2 control-label">昵称</label>
                  <div class="col-sm-10">
                    <input v-model="apply.name" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">绿植名称</label>
                  <div class="col-sm-10">
                    <input v-model="apply.plantName" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">家庭住址</label>
                  <div class="col-sm-10">
                    <input v-model="apply.userAddress" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">用户手机号</label>
                  <div class="col-sm-10">
                    <input v-model="apply.userTelephone" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">状态</label>
                 <div class="col-sm-10">
                  <select v-model="apply.status" class="form-control">
                    <option v-for="o in APPLY_STATUS" v-bind:value="o.key">{{ o.value }}</option>
                  </select>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">用户id</label>
                  <div class="col-sm-10">
                    <input v-model="apply.userId" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">绿植id</label>
                  <div class="col-sm-10">
                    <input v-model="apply.plantId" class="form-control">
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
  name: "business-apply",
  components: {Pagination},
  data: function () {
    return {
      apply: {},
      applys: [],
      APPLY_STATUS: APPLY_STATUS,
    }
  },
  mounted() {
    let _this = this;
    _this.$refs.pagination.size = 5;
    _this.list(1,APPLY_STATUS.AGREE.key);

    //sidebar激活样式方法一
    // this.$parent.activeSidebar("business-apply-sidebar");
  },
  methods: {
    add() {
      //这个add的作用就是点开那个模态框，新增是save
      let _this = this;
      _this.apply = {}
      $("#form-modal").modal('show');
    },
    edit(apply) {
      //这个add的作用就是点开那个模态框，新增是save
      let _this = this;
      _this.apply = $.extend({}, apply);
      $("#form-modal").modal('show');
    },
    list(page,status) {
      let _this = this;
      Loading.show();
      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/apply/list",
          {
            page: page,
            size: _this.$refs.pagination.size,
            status:status
          }).then((response) => {
        Loading.hide();
        console.log("查询列表结果", response);
        let resp = response.data;
        _this.applys = resp.content.list;
        _this.$refs.pagination.render(page, resp.content.total);
      })
    },
    save() {
      let _this = this;
        // 保存校验
        if (1 != 1
          || !Validator.length(_this.apply.name, "昵称", 1, 50)
          || !Validator.require(_this.apply.plantName, "绿植名称")
          || !Validator.length(_this.apply.plantName, "绿植名称", 1, 50)
          || !Validator.length(_this.apply.userAddress, "家庭住址", 1, 50)
          || !Validator.length(_this.apply.userTelephone, "用户手机号", 1, 50)
          || !Validator.require(_this.apply.userId, "用户id")
          || !Validator.require(_this.apply.plantId, "绿植id")
        ) {
          return;
        }

      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/apply/save",
          _this.apply).then((response) => {
        console.log("查询列表结果", response);
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
      Confirm.show("删除后不可恢复!",function () {
        Loading.show();
        _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/apply/delete/" + id).then((response) => {
          console.log("删除列表结果", response);
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