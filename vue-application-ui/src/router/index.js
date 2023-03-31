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
        path: "/admin/assigned",
        name: "AdminAssigned",
        component: () => import('@/views/AdminHome.vue'),
      },
      {
        path: "/admin/inprogress",
        name: "AdminInProgress",
        component: () => import('@/views/AdminHome.vue'),
      },
      {
        path: "/admin/completed",
        name: "AdminCompleted",
        component: () => import('@/views/AdminHome.vue'),
      },
      {
        path: "/formbuilder",
        name: "formbuilder",
        component: () => import('@/views/FormBuilder.vue'),
      },
      {
        path: "/usermanagement",
        name: "UserManagement",
        component: () => import('@/views/UserManagement.vue'),
      },
      {
        path: "/manageworkflows",
        name: "ManageWorkflows",
        component: () => import('@/views/ManageWorkflows.vue'),
      },
      //This need to change
      {
        path: "/manageworkflows/workflow/workflowstatus",
        name: "WorkflowStatus",
        component: () => import('@/views/WorkflowStatus.vue'),
      },
      //This need to change
      {
        path: "/manageworkflows/workflow/workflowassignment",
        name: "WorkflowAssignment",
        component: () => import('@/views/WorkflowAssignment.vue'),
      },
      {
        path: "/vendor",
        name: "VendorHome",
        component: () => import('@/views/VendorHome.vue'),
      },
      {
        path: "/vendor/assigned",
        name: "VendorAssigned",
        component: () => import('@/views/VendorHome.vue'),
      },
      {
        path: "/vendor/inprogress",
        name: "VendorInProgress",
        component: () => import('@/views/VendorHome.vue'),
      },
      {
        path: "/vendor/completed",
        name: "VendorCompleted",
        component: () => import('@/views/VendorHome.vue'),
      },
      {
        path: "/register",
        name: "register",
        component: () => import('@/views/RegisterUser.vue'),
      },
      {
        path: "/test",
        name: "test",
        component: () => import('@/views/TestView.vue'),
      },
      {
        path: "/text",
        name: "text",
        component: () => import('@/components/formitems/FileUploadInput.vue'),
      }
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
