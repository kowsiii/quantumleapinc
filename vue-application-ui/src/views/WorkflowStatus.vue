<template>
    <NavBar :is-vendor="false" />
    <div class="container-fluid py-4 px-20">
        <div class="row">
            <div class="col-md-10 mb-4">
                <h4 class="text-2xl font-bold dark:text-white">Workflow Status</h4>
            </div>
        </div>
        <WorkflowsProgress />
    </div>
</template>

<script>
import  NavBar from "../components/NavBar.vue";
import WorkflowsProgress from "../components/WorkflowsProgress.vue";

export default {
  name: "WorkflowStatus",
  components: {
    NavBar,
    WorkflowsProgress
  }
};
</script>