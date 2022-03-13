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

         <th>班级</th>

         <th>学号</th>

         <th>姓名</th>

         <th>状态</th>

         <th>学制</th>

         <th>结课考试</th>

         <th>平时成绩</th>

         <th>单元测试</th>

         <th>课堂表现与考勤</th>

         <th>综合成绩</th>
        <th>操作</th>
      </tr>

      </thead>

      <tbody>
      <tr v-for="student in students">
              <td>{{student.id}}</td>
              <td>{{student.className}}</td>
              <td>{{student.studentNumber}}</td>
              <td>{{student.name}}</td>
              <td>{{GENDER_STATUS | optionKV(student.gender)}}</td>
              <td>{{student.schoolSystem}}</td>
              <td>{{student.finalExam}}</td>
              <td>{{student.usualGrade}}</td>
              <td>{{student.unitTest}}</td>
              <td>{{student.classBehave}}</td>
              <td>{{student.finalResult}}</td>
        <td>

          <div class="hidden-sm hidden-xs btn-group">
            <button v-on:click="edit(student)" class="btn btn-xs btn-info">
              <i class="ace-icon fa fa-pencil bigger-120"></i>
            </button>

            <button v-on:click="del(student.id)" class="btn btn-xs btn-danger">
              <i class="ace-icon fa fa-trash-o bigger-120"></i>
            </button>
          </div>
        </td>
      </tr>
      <tr>
        <th>平均分</th>

        <th></th>

        <th></th>

        <th></th>

        <th></th>

        <th></th>
        <th>{{finalExamAvg}}</th>
        <th>{{usualGradeAvg}}</th>
        <th>{{unitTestAvg}}</th>
        <th>{{classBehaveAvg}}</th>

        <th></th>
        <th></th>
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
                  <label class="col-sm-2 control-label">班级</label>
                  <div class="col-sm-10">
                    <input v-model="student.className" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">学号</label>
                  <div class="col-sm-10">
                    <input v-model="student.studentNumber" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">姓名</label>
                  <div class="col-sm-10">
                    <input v-model="student.name" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">状态</label>
                 <div class="col-sm-10">
                  <select v-model="student.gender" class="form-control">
                    <option v-for="o in GENDER_STATUS" v-bind:value="o.key">{{ o.value }}</option>
                  </select>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">学制</label>
                  <div class="col-sm-10">
                    <input v-model="student.schoolSystem" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">结课考试</label>
                  <div class="col-sm-10">
                    <input v-model="student.finalExam" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">平时成绩</label>
                  <div class="col-sm-10">
                    <input v-model="student.usualGrade" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">单元测试</label>
                  <div class="col-sm-10">
                    <input v-model="student.unitTest" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">课堂表现与考勤</label>
                  <div class="col-sm-10">
                    <input v-model="student.classBehave" class="form-control">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">综合成绩</label>
                  <div class="col-sm-10">
                    <input v-model="student.finalResult" class="form-control">
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
  name: "business-student",
  components: {Pagination},
  data: function () {
    return {
      student: {},
      students: [],
      GENDER_STATUS: GENDER_STATUS,
      finalExamAvg:parseFloat(),
      usualGradeAvg:parseFloat(),
      unitTestAvg:parseFloat(),
      classBehaveAvg:parseFloat(),

    }
  },
  mounted() {
    let _this = this;

    _this.$refs.pagination.size = 5;
    _this.list(1);

    //sidebar激活样式方法一
    // this.$parent.activeSidebar("business-student-sidebar");
  },
  methods: {
    add() {
      //这个add的作用就是点开那个模态框，新增是save
      let _this = this;
      _this.student = {}
      $("#form-modal").modal('show');
    },
    edit(student) {
      //这个add的作用就是点开那个模态框，新增是save
      let _this = this;
      _this.student = $.extend({}, student);
      $("#form-modal").modal('show');
    },
    list(page) {
      let _this = this;
      let finalExamAvg = 0;
      let usualGradeAvg = 0;
      let unitTestAvg = 0;
      let classBehaveAvg = 0;
      Loading.show();
      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/student/list",
          {
            page: page,
            size: _this.$refs.pagination.size
          }).then((response) => {
        Loading.hide();
        console.log("查询学生列表结果", response);
        let resp = response.data;
        _this.students = resp.content.list;

        for (let i = 0; i < _this.students.length; i++) {
          console.log("_this.students[i].finalExam",_this.students[i].finalExam);
          finalExamAvg += parseFloat(_this.students[i].finalExam);
          usualGradeAvg += parseFloat(_this.students[i].usualGrade);
          unitTestAvg += parseFloat(_this.students[i].unitTest);
          classBehaveAvg += parseFloat(_this.students[i].classBehave);
        }
        finalExamAvg = finalExamAvg/_this.students.length;
        usualGradeAvg = usualGradeAvg/_this.students.length;
        unitTestAvg = unitTestAvg/_this.students.length;
        classBehaveAvg = classBehaveAvg/_this.students.length;
        console.log("finalExamAvg",finalExamAvg);
        console.log("usualGradeAvg",usualGradeAvg);
        console.log("unitTestAvg",unitTestAvg);
        console.log("classBehaveAvg",classBehaveAvg);
        _this.$refs.pagination.render(page, resp.content.total);
      })
    },
    save() {
      let _this = this;
        // 保存校验
        if (1 != 1
          || !Validator.length(_this.student.className, "班级", 1, 50)
          || !Validator.length(_this.student.studentNumber, "学号", 1, 50)
          || !Validator.length(_this.student.name, "姓名", 1, 32)
        ) {
          return;
        }

      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/student/save",
          _this.student).then((response) => {
        console.log("查询学生列表结果", response);
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
      Confirm.show("删除学生后不可恢复!",function () {
        Loading.show();
        _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/student/delete/" + id).then((response) => {
          console.log("删除学生列表结果", response);
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