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
      &nbsp;
      <button v-on:click="delAll()" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-close"></i>
        清空数据
      </button>
      &nbsp;
      <button v-on:click="openModal()" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-upload"></i>
        导入数据
      </button>
    </p>
    <pagination ref="pagination" v-bind:list="list" v-bind:itemCount="8"></pagination>
    <table id="simple-table" class="table  table-bordered table-hover">
      <thead>
      <tr>
        <th>id</th>

        <th>课程目标</th>

        <th>评价</th>
        <th>操作</th>
      </tr>

      </thead>

      <tbody>
      <tr v-for="courseComment in courseComments">
        <td>{{courseComment.id}}</td>
        <td>{{courseComment.courseTargetName}}</td>
        <td>{{COURSE_COMMENT_STATUS | optionKV(courseComment.courseComment)}}</td>
        <td>

          <div class="hidden-sm hidden-xs btn-group">
            <button v-on:click="edit(courseComment)" class="btn btn-xs btn-info">
              <i class="ace-icon fa fa-pencil bigger-120"></i>
            </button>

            <button v-on:click="del(courseComment.id)" class="btn btn-xs btn-danger">
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
                  <select v-model="courseComment.courseTargetId" class="form-control">
                    <option v-for="o in courseTargets" v-bind:value="o.id">{{ o.target }}</option>
                  </select>

                  <!--                    <input v-model="courseComment.courseTargetId" class="form-control">-->
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">评价</label>
                <div class="col-sm-10">
                  <select v-model="courseComment.courseComment" class="form-control">
                    <option v-for="o in COURSE_COMMENT_STATUS" v-bind:value="o.key">{{ o.value }}</option>
                  </select>
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
    <div id="form-modal2" class="modal fade" tabindex="-1" role="dialog">
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
                  <select v-model="courseComment.courseTargetId" class="form-control" id="course-target-id">
                    <option v-for="o in courseTargets" v-bind:value="o.id" >{{ o.target }}</option>
                  </select>
                </div>
              </div>
            </form>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
              <div class="form-group">
                <label class="col-sm-2 control-label">选择文件</label>
                <div class="col-sm-10">
                  <input type="file" id="file-upload-input">
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button v-on:click="upload()" type="button" class="btn btn-primary">保存</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

  </div>
</template>

<script>
import Pagination from "../../components/pagination";

export default {
  name: "business-courseComment",
  components: {Pagination},
  data: function () {
    return {
      courseComment: {},
      courseComments: [],
      courseCommentsBak: [],
      COURSE_COMMENT_STATUS: COURSE_COMMENT_STATUS,
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
    // this.$parent.activeSidebar("business-courseComment-sidebar");
  },
  methods: {

    add() {
      //这个add的作用就是点开那个模态框，新增是save
      let _this = this;
      _this.courseComment = {}
      $("#form-modal").modal('show');
    },
    edit(courseComment) {
      let _this = this;
      _this.courseComment = $.extend({}, courseComment);
      $("#form-modal").modal('show');
    },
    list(page) {
      let _this = this;
      Loading.show();
      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/courseComment/list",
          {
            page: page,
            size: _this.$refs.pagination.size
          }).then((response) => {
        Loading.hide();
        console.log("查询课程目标列表结果", response);
        let resp = response.data;
        _this.courseComments = resp.content.list;
        _this.courseCommentsBak = resp.content.list;
        console.log("_this.courseCommentsBak",_this.courseCommentsBak);
        _this.$refs.pagination.render(page, resp.content.total);
      });
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
        // _this.courseTargetsBak = resp.content.list;
        // console.log("_this.courseTargetsBak",_this.courseTargetsBak);
        // for (let i = 0; i < _this.courseCommentsBak.length  ; i++) {
        //   for (let j = 0; j < _this.courseTargetsBak.length; j++) {
        //     if(_this.courseCommentsBak[i].courseTargetId === _this.courseTargetsBak[j].id){
        //       _this.courseCommentsBak[i].courseTargetId = _this.courseTargetsBak[j].target;
        //       console.log("_this.courseCommentsBak.get(j).courseTargetId",_this.courseCommentsBak[i].courseTargetId);
        //       console.log(" _this.courseTargetsBak.get(i).target", _this.courseTargetsBak[j].target);
        //     }
        //   }
        // }


      })
    },
    save() {
      let _this = this;
      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/courseComment/save",
          _this.courseComment).then((response) => {
        console.log("查询课程目标列表结果", response);
        let resp = response.data;
        if (resp.success) {
          $("#form-modal").modal('hide');
          _this.list(1);
          Toast.success("保存成功");
          // _this.list(1);
        }else{
          Toast.warning(resp.message);

        }
      })
    },
    del(id) {
      let _this = this;
      Confirm.show("删除课程目标后不可恢复!",function () {
        Loading.show();
        _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/courseComment/delete/" + id).then((response) => {
          console.log("删除课程目标列表结果", response);
          let resp = response.data;
          if (resp.success) {
            Toast.success("删除成功");
            _this.list(1);

          }
        })
      });
    },
    delAll(){
      let _this = this;
      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/courseComment/deleteAll").then((response) => {
        let resp = response.data;
        console.log("delAll",resp);
        if (resp.success) {
          Toast.success("清除成功");
        }
        _this.list(1);
      })
    },

    openModal() {
      let _this = this;
      $("#form-modal2").modal('show');
    },
    upload() {
      let _this = this;

      let formData = new window.FormData();
      let myselect = document.querySelector("#course-target-id");
      let index=myselect.selectedIndex;
      console.log("myselect.options[index].value;",myselect.options[index].value);
      formData.append("file",document.querySelector("#file-upload-input").files[0]);
      // formData.append("courseTargetId",document.querySelector("#course-target-id").getAttribute("value"));
      formData.append("courseTargetId",myselect.options[index].value);
      _this.$ajax.post(process.env.VUE_APP_SERVER + "/business/admin/courseComment/upload",formData).then((response) => {
        console.log("导入数据", response);
        let resp = response.data;
        if (resp.success) {
          $("#form-modal2").modal('hide');
          Toast.success("导入成功");
        }
        _this.list(1);
      })
    },

  }
}
</script>