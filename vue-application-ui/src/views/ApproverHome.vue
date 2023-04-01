<template>
    <NavBar :user="user" />
    <CompletedWorkflows :status="status" />
</template>
<script>
import NavBar from "../components/NavBar.vue";
import CompletedWorkflows from "../components/CompletedWorkflows.vue";

export default {
    name: "approverHome",
    data() {
        return {
            user: 'approver',
        };
    },
    watch: {
        $route: {
        handler(newRoute) {
            if (newRoute.path === "/approver/awaiting") {
            this.status = "awaiting";
            document.title = "Awaiting";
            } else if (newRoute.path === "/approver/approved") {
            this.status = "approved";
            document.title = "Approved";
            } else if (newRoute.path === "/approver") {
            this.status = "all";
            document.title = "All";
            } 
        },
        immediate: true, // handle initial route on component mount
        },
    }
};
</script>