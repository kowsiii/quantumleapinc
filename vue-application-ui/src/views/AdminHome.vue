<template>
  <div>
    <Navbar />
    <router-view />
    <div class="col-md-6">
      <div class="card card-container">
        Admin!!
        <button v-on:click="logOut">Logout</button>
        <button v-on:click="registerUser">Register New User</button>
      </div>
    </div>
  </div>
</template>
  
  <script>
  import Navbar from '../components/NavBar.vue';

  /*export default {
    name: "AdminHome",
    data () {
        return {
          
        }},

    methods: {
        logOut() {
            this.$store.dispatch("auth/logout",).then(
            () => {
            this.$router.push("/");
            },
            (error) => {
            this.loading = false;
            this.message =
                (error.response &&
                error.response.data &&
                error.response.data.message) ||
                error.message ||
                error.toString();
            }
        );
    },
        registerUser() {
            this.$router.push("/register");
        }
  
  }}*/

  export default {
    name: 'App',
    components: {
      Navbar,
    },
  };
  
  
  </script>