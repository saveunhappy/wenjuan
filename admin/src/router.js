import Vue from 'vue';
import Router from 'vue-router';
import Login from './view/login.vue';
import Admin from './view/admin.vue';
import Welcome from './view/admin/welcome.vue';
import Chapter from './view/admin/chapter.vue';
Vue.use(Router);
export default new Router({
    mode:'history',
    base:process.env.BASE_URL,
    routes:[{
        path: '*',
        redirect:"/login",
    },
        {
            path: "/login",
            component:Login
        },
        {
            path: "/admin",
            component:Admin,
            children:[{
                //子路由不要斜杠开头
                path: "welcome",
                component:Welcome,
            },
                {
                    path: "chapter",
                    component:Chapter,
                }]
        }
    ]
})