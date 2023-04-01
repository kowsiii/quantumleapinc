<template>
    <NavBar :is-vendor="false" />
    <WorkflowsProgress />
</template>

<script>
import  NavBar from "../components/NavBar.vue";
import WorkflowsProgress from "../components/WorkflowsProgress.vue";

export default {
  name: "WorkflowStatus",
  components: {
    NavBar,
    WorkflowsProgress
  },
  created() {
    document.title = "Workflow Status";
  }
};
</script>