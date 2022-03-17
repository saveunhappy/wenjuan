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

         <th>课程目标</th>

         <th>权重</th>

         <th>结课考试</th>

         <th>实际平均分</th>
        <th>操作</th>
      </tr>

      </thead>

      <tbody>
      <tr v-for="finalExam in finalExamsBak">
              <td>{{finalExam.id}}</td>
              <td>{{finalExam.courseTargetId}}</td>
              <td>{{finalExam.weight}}</td>
              <td>{{finalExam.goalGrade}}</td>
              <td>{{finalExam.actualAvgGrade}}</td>
        <td>

          <div class="hidden-sm hidden-xs btn-group">
            <button v-on:click="edit(finalExam)" class="btn btn-xs btn-info">
              <i class="ace-icon fa fa-pencil bigger-120"></i>
            </button>

            <button v-on:click="del(finalExam.id)" class="btn btn-xs btn-danger">
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
                  <label class="col-sm-2 control-label">课程目标</label>
                  <div class="col-sm-10">
                    <select v-model="finalExam.courseTargetId" class="form-control">
                      <option v-for="o in courseTargets" v-bind:value="o.id">{{ o.target }}</option>
                    </select>
<!--                    <input v-model="finalExam.courseTargetId" class="form-control">-->
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">权重</label>
                  <div class="col-sm-10">
                    <input v-model="finalExam.weight" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">结课考试</label>
                  <div class="col-sm-10">
                    <input v-model="finalExam.goalGrade" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">实际平均分</label>
                  <div class="col-sm-10">
                    <input v-model="finalExam.actualAvgGrade" class="form-control">
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
  name: "business-finalExam",
  components: {Pagination},
  data: function () {
    return {
      finalExam: {},
      finalExams: [],
      finalExamsBak: [],

      courseTarget: {},
      courseTargets: [],
      courseTargetsBak: [],
    }
  },
  mounted() {
    let _this = this;
    _this.$refs.pagination.size = 1000;
    _this.list(1);
    _this.listCourseTarget(1);
    //sidebar激活样式方法一
    // this.$parent.activeSidebar("business-finalExam-sidebar");
  },
  methods: {
    add() {
      //这个add的作用就是点开那个模态框，新增是save
      let _this = this;
      _this.finalExam = {}
      $("#form-modal").modal('show');
    },
    edit(finalExam) {
      //这个add的作用就是点开那个模态框，新增是save
      let _this = this;
      _this.finalExam = $.extend({}, finalExam);
      $("#form-modal").modal('show');
    },
    list(page) {
      let _this = this;
      Loading.show();
      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/finalExam/list",
          {
            page: page,
            size: _this.$refs.pagination.size
          }).then((response) => {
        Loading.hide();
        console.log("查询结课考试列表结果", response);
        let resp = response.data;
        _this.finalExams = resp.content.list;
        _this.finalExamsBak = resp.content.list;
        _this.$refs.pagination.render(page, resp.content.total);
      })
    },
    listCourseTarget(page) {
      let _this = this;
      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/courseTarget/list",
          {
            page: page,
            size: _this.$refs.pagination.size
          }).then((response) => {
        console.log("查询课程所有！！", response);
        let resp = response.data;
        _this.courseTargets = resp.content.list;
        _this.courseTargetsBak = resp.content.list;
        console.log("_this.courseTargetsBak",_this.courseTargetsBak);
        for (let i = 0; i < _this.finalExamsBak.length  ; i++) {
          for (let j = 0; j < _this.courseTargetsBak.length; j++) {
            if(_this.finalExamsBak[i].courseTargetId === _this.courseTargetsBak[j].id){
              _this.finalExamsBak[i].courseTargetId = _this.courseTargetsBak[j].target;
              console.log("_this.finalExamsBak.get(j).courseTargetId",_this.finalExamsBak[i].courseTargetId);
              console.log(" _this.courseTargetsBak.get(i).target", _this.courseTargetsBak[j].target);
            }
          }
        }
      })
    },
    save() {

      let _this = this;
      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/finalExam/save",
          _this.finalExam).then((response) => {
        console.log("查询结课考试列表结果", response);
        let resp = response.data;
        if (resp.success) {
          $("#form-modal").modal('hide');
          _this.list(1)
          Toast.success("保存成功");
          _this.$router.go(0);
        }else{
          Toast.warning(resp.message);

        }
      })
    },
    del(id) {
      let _this = this;
      Confirm.show("删除结课考试后不可恢复!",function () {
        Loading.show();
        _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/finalExam/delete/" + id).then((response) => {
          console.log("删除结课考试列表结果", response);
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