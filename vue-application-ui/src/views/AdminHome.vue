<template>
    <NavBar :is-vendor="false"/>
    <AssignedWorkflows :status="status"/>
</template>

<script>
import NavBar from '../components/NavBar.vue';
import AssignedWorkflows from "../components/AssignedWorkflows.vue";

export default {
  name: "AdminHome",
  components:{
    NavBar,
    AssignedWorkflows
  },
  watch: {
    $route: {
      handler(newRoute) {
        if (newRoute.path === "/admin/assigned") {
          this.status = "assigned";
          document.title = "Assigned";
        } else if (newRoute.path === "/admin/completed") {
          this.status = "completed";
          document.title = "Completed";
        } else if (newRoute.path === "/admin/inprogress") {
          this.status = "inprogress";
          document.title = "In Progress";
        } else if (newRoute.path === "/admin") {
          this.status = "all";
          document.title = "My Workflows";
        }
      },
      immediate: true, // handle initial route on component mount
    },
  },
};
</script>