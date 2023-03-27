<template>
  <NavBar :is-vendor="true" />
  <MyWorkflows :status="status" />
</template>

<script>
import NavBar from "../components/NavBar.vue";
import MyWorkflows from "../components/MyWorkflows.vue";

export default {
  name: "VendorHome",
  components: {
    NavBar,
    MyWorkflows,
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
};
</script>
