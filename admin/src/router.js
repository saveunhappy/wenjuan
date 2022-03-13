import Vue from "vue";
import Router from "vue-router";
import Login from "./view/login.vue";
import Admin from "./view/admin.vue";
import Welcome from "./view/admin/welcome.vue";
import Course from "./view/admin/course.vue";
import Chapter from "./view/admin/chapter.vue";
import Section from "./view/admin/section.vue";
import User from "./view/admin/user.vue";
import Member from "./view/admin/member.vue";
import Plant from "./view/admin/plant.vue";
import ApplyPassed from "./view/admin/applyPassed.vue";
import ApplyDeny from "./view/admin/applyDeny.vue";
import UserLog from "./view/admin/userLog.vue";
import MemberPlant from "./view/admin/memberPlant.vue";
import Student from "./view/admin/student.vue";
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
                    path: "business/course",
                    name:"business/course",
                    component:Course,
                }
                ,
                {
                    path: "business/chapter",
                    name:"business/chapter",
                    component:Chapter,
                }
                ,
                {
                    path: "business/section",
                    name:"business/section",
                    component:Section,
                },
                {
                    path: "business/user",
                    name:"business/user",
                    component:User,
                }
                ,
                {
                    path: "business/member",
                    name:"business/member",
                    component:Member,
                }
                ,
                {
                    path: "business/plant",
                    name:"business/plant",
                    component:Plant,
                }
                ,
                {
                    path: "business/applyPassed",
                    name:"business/applyPassed",
                    component:ApplyPassed,
                }
                ,
                {
                    path: "business/applyDeny",
                    name:"business/applyDeny",
                    component:ApplyDeny,
                }
                ,
                {
                    path: "business/userLog",
                    name:"business/userLog",
                    component:UserLog,
                }
                ,
                {
                    path: "business/memberPlant",
                    name:"business/memberPlant",
                    component:MemberPlant,
                }
                ,
                {
                    path: "business/student",
                    name:"business/student",
                    component:Student,
                }
                ]
        }
    ]
})