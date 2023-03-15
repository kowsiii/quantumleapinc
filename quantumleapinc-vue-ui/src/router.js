import { createWebHistory, createRouter } from "vue-router";


const routes = [
    {
      path: "/",
      name: "login",
      component: () => import('../vue-application-ui/src/views/UserLogin.vue'),
    },
    {
        path: "/home",
        name: "home",
        component: () => import('../vue-application-ui/src/views/AdminHome.vue'),
      },
      {
        path: "/register",
        name: "register",
        component: () => import('../vue-application-ui/src/views/RegisterUser.vue'),
      },
      {
        path: "/login",
        name: "login",
        component: () => import('../vue-application-ui/src/components/LoginComponent.vue'),
      },
    //   {
    //     path: "/formbuilder",
    //     name: "formbuilder",
    //     component: () => import('@/views/FormBuilder.vue'),
    //   },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
  });

export default router;
