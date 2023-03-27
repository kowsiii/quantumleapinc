<template>
    <NavBar :is-vendor="false" />
    <div class="container-fluid py-4 px-20">
        <div class="row">
            <div class="col-md-10 mb-4">
                <h4 class="text-2xl font-bold dark:text-white">Manage Workflows</h4>
            </div>
        </div>
        <AllWorkflows />
    </div>
</template>

<script>
import NavBar from "../components/NavBar.vue";
import AllWorkflows from "../components/AllWorkflows.vue";

export default {
  name: "ManageWorkflows",
  components: {
    NavBar,
    AllWorkflows
  },
}
</script>