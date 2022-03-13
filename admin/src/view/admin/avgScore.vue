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

         <th>结课考试平均分</th>

         <th>平时成绩平均分</th>

         <th>单元测试平均分</th>

         <th>课堂表现与考勤平均分</th>
        <th>操作</th>
      </tr>

      </thead>

      <tbody>
      <tr v-for="avgScore in avgScores">
              <td>{{avgScore.id}}</td>
              <td>{{avgScore.finalExamAvg}}</td>
              <td>{{avgScore.usualGradeAvg}}</td>
              <td>{{avgScore.unitTestAvg}}</td>
              <td>{{avgScore.classBehave}}</td>
        <td>

          <div class="hidden-sm hidden-xs btn-group">
            <button v-on:click="edit(avgScore)" class="btn btn-xs btn-info">
              <i class="ace-icon fa fa-pencil bigger-120"></i>
            </button>

            <button v-on:click="del(avgScore.id)" class="btn btn-xs btn-danger">
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
                  <label class="col-sm-2 control-label">结课考试平均分</label>
                  <div class="col-sm-10">
                    <input v-model="avgScore.finalExamAvg" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">平时成绩平均分</label>
                  <div class="col-sm-10">
                    <input v-model="avgScore.usualGradeAvg" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">单元测试平均分</label>
                  <div class="col-sm-10">
                    <input v-model="avgScore.unitTestAvg" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">课堂表现与考勤平均分</label>
                  <div class="col-sm-10">
                    <input v-model="avgScore.classBehave" class="form-control">
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
  name: "business-avgScore",
  components: {Pagination},
  data: function () {
    return {
      avgScore: {},
      avgScores: [],
    }
  },
  mounted() {
    let _this = this;
    _this.$refs.pagination.size = 5;
    _this.list(1);

    //sidebar激活样式方法一
    // this.$parent.activeSidebar("business-avgScore-sidebar");
  },
  methods: {
    add() {
      //这个add的作用就是点开那个模态框，新增是save
      let _this = this;
      _this.avgScore = {}
      $("#form-modal").modal('show');
    },
    edit(avgScore) {
      //这个add的作用就是点开那个模态框，新增是save
      let _this = this;
      _this.avgScore = $.extend({}, avgScore);
      $("#form-modal").modal('show');
    },
    list(page) {
      let _this = this;
      Loading.show();
      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/avgScore/list",
          {
            page: page,
            size: _this.$refs.pagination.size
          }).then((response) => {
        Loading.hide();
        console.log("查询平均分列表结果", response);
        let resp = response.data;
        _this.avgScores = resp.content.list;
        _this.$refs.pagination.render(page, resp.content.total);
      })
    },
    save() {
      let _this = this;
        // 保存校验
        if (1 != 1
        ) {
          return;
        }

      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/avgScore/save",
          _this.avgScore).then((response) => {
        console.log("查询平均分列表结果", response);
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
      Confirm.show("删除平均分后不可恢复!",function () {
        Loading.show();
        _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/avgScore/delete/" + id).then((response) => {
          console.log("删除平均分列表结果", response);
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