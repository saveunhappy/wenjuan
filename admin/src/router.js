import Vue from "vue";
import Router from "vue-router";
import Login from "./view/login.vue";
import Admin from "./view/admin.vue";
import Welcome from "./view/admin/welcome.vue";
import Student from "./view/admin/student.vue";
import CourseTarget from "./view/admin/courseTarget.vue";
import CourseComment from "./view/admin/courseComment.vue";
import FinalExam from "./view/admin/finalExam.vue";
import ClassBehave from "./view/admin/classBehave.vue";
import UsualGrade from "./view/admin/usualGrade.vue";
Vue.use(Router);
export default new Router({
    mode:"history",
    base:process.env.BASE_URL,
    routes:[
        {
        path: "*",
        redirect:"/",
    },
        {
            path: "/login",
            component:Login
        },
        {
            path: "/",
            name:"admin",
            component:Admin,
            children:[{
                //子路由不要斜杠开头
                path: "welcome",
                name:"welcome",
                component:Welcome,
            },
                {
                    path: "business/student",
                    name:"business/student",
                    component:Student,
                }
                ,
                {
                    path: "business/courseTarget",
                    name:"business/courseTarget",
                    component:CourseTarget,
                }
                ,
                {
                    path: "business/courseComment",
                    name:"business/courseComment",
                    component:CourseComment,
                }
                ,
                {
                    path: "business/finalExam",
                    name:"business/finalExam",
                    component:FinalExam,
                }
                ,
                {
                    path: "business/classBehave",
                    name:"business/classBehave",
                    component:ClassBehave,
                }
                ,
                {
                    path: "business/usualGrade",
                    name:"business/usualGrade",
                    component:UsualGrade,
                }
                ]
        }
    ]
})