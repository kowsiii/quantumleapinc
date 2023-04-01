<template>
    <NavBar :user="user"/>
    <AssignedWorkflows :status="status"/>
</template>

<script>
import NavBar from '../components/NavBar.vue';
import AssignedWorkflows from "../components/AssignedWorkflows.vue";

export default {
  name: "MyWorkflows",
  components:{
    NavBar,
    AssignedWorkflows
  },
  watch: {
    $route: {
      handler(newRoute) {
        if (newRoute.path === "/admin/myworkflows/assigned") {
          this.status = "assigned";
          document.title = "Assigned";
        } else if (newRoute.path === "/admin/myworkflows/completed") {
          this.status = "completed";
          document.title = "Completed";
        } else if (newRoute.path === "/admin/myworkflows/inprogress") {
          this.status = "inprogress";
          document.title = "In Progress";
        } else if (newRoute.path === "/admin/myworkflows/all") {
          this.status = "all";
          document.title = "All";
        }
      },
      immediate: true, // handle initial route on component mount
    },
  },
  data() {
    return {
      user: 'admin',
    };
  }
};
</script>