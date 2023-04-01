<template>
  <NavBar :user="user" />
  <AssignedWorkflows :status="status" />
</template>

<script>
import NavBar from "../components/NavBar.vue";
import AssignedWorkflows from "../components/AssignedWorkflows.vue";

export default {
  name: "VendorHome",
  components: {
    NavBar,
    AssignedWorkflows
  },
  watch: {
    $route: {
      handler(newRoute) {
        if (newRoute.path === "/vendor/assigned") {
          this.status = "assigned";
          document.title = "Assigned";
        } else if (newRoute.path === "/vendor/completed") {
          this.status = "completed";
          document.title = "Completed";
        } else if (newRoute.path === "/vendor/inprogress") {
          this.status = "inprogress";
          document.title = "In Progress";
        } else if (newRoute.path === "/vendor") {
          this.status = "all";
          document.title = "My Workflows";
        }
      },
      immediate: true, // handle initial route on component mount
    },
  },
  data() {
    return {
      user: 'vendor',
    };
  }
};
</script>
