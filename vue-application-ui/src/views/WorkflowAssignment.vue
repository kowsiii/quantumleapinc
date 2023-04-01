<template>
    <NavBar :is-vendor="false" />
    <AssigningWorkflows />
</template>

<script>
import  NavBar from "../components/NavBar.vue";
import AssigningWorkflows from "../components/AssigningWorkflows.vue";

export default {
  name: "WorkflowAssignment",
  components: {
    NavBar,
    AssigningWorkflows
  },
  created() {
    document.title = "Workflow Assignment";
  }
};
</script>