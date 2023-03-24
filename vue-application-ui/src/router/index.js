import { createWebHistory, createRouter } from "vue-router";


const routes = [
    {
      path: "/",
      name: "login1",
      component: () => import('@/views/UserLogin.vue'),
    },
    {
        path: "/admin_home",
        name: "admin_home",
        component: () => import('@/views/AdminHome.vue'),
      },
      {
        path: "/register",
        name: "register",
        component: () => import('@/views/RegisterUser.vue'),
      },
      {
        path: "/vendor",
        name: "vendor",
        component: () => import('@/views/VendorHome.vue'),
      },
      {
        path: "/formbuilder",
        name: "formbuilder",
        component: () => import('@/views/FormBuilder.vue'),
      },
      {
        path: "/formgenerator",
        name: "formgenerator",
        component: () => import('@/views/FormGenerator.vue'),
      },{
        path: "/vendor_home",
        name: "vendor_home",
        component: () => import('@/views/VendorHome.vue'),
      }
      // {
      //   path: "/login",
      //   name: "login",
      //   component: () => import('@/views/UserLogin.vue'),
      // },
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
