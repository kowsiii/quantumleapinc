import { createWebHistory, createRouter } from "vue-router";


const routes = [
    {
      path: "/",
      name: "login",
      component: () => import('@/views/UserLogin.vue'),
    },
    {
        path: "/admin",
        name: "AdminHome",
        component: () => import('@/views/AdminHome.vue'),
      },
      {
        path: "/register",
        name: "register",
        component: () => import('@/views/RegisterUser.vue'),
      },
      {
        path: "/vendor",
        name: "VendorHome",
        component: () => import('@/views/VendorHome.vue'),
      },
      {
        path: "/formbuilder",
        name: "formbuilder",
        component: () => import('@/views/FormBuilder.vue'),
      },
      {
        path: "/test",
        name: "test",
        component: () => import('@/views/TestView.vue'),
      },
      {
        path: "/vendor/assigned",
        name: "assigned",
        component: () => import('@/views/VendorHome.vue'),
      },
      {
        path: "/vendor/completed",
        name: "completed",
        component: () => import('@/views/VendorHome.vue'),
      },
      {
        path: "/vendor/inprogress",
        name: "inprogress",
        component: () => import('@/views/VendorHome.vue'),
      }
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

  // router.beforeEach((to, from, next) => {
  //   const publicPages = ['/login','/formbuilder','/test'];
  //   const authRequired = !publicPages.includes(to.path);
  //   const loggedIn = localStorage.getItem('user');
  
  //   // trying to access a restricted page + not logged in
  //   // redirect to login page
  //   if (authRequired && !loggedIn) {
  //     next('/login');
  //   } else {
  //     next();
  //   }
  // });

export default router;
