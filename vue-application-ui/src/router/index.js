import { createWebHistory, createRouter } from "vue-router";


const routes = [
    {
      path: "/",
      name: "login1",
      component: () => import('@/views/UserLogin.vue'),
    },
    {
        path: "/home",
        name: "home",
        component: () => import('@/views/AdminHome.vue'),
      },
      {
        path: "/register",
        name: "register",
        component: () => import('@/views/RegisterUser.vue'),
      },
      {
        path: "/login",
        name: "login",
        component: () => import('@/components/LoginComponent.vue'),
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
      },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
  });

export default router;
