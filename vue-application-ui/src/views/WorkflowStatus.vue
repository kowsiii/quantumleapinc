<template>
    <NavBar :user="user" />
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
  },
  data() {
    return {
      user: 'vendor',
    };
  }
};
</script>