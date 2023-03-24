<template>
    

    <div>
    <AdminNavBar />
    <router-view />
    <div class="col-md-6">
      <div class="card card-container">
        Admin!!
        <button v-on:click="logOut">Logout</button>
        <button v-on:click="registerUser">Register New User</button>
      </div>
    </div>
  </div>
  <div>
      <button @click="logOut" type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">Sign out</button>
    
    </div>
</template>

<style>
.input-container {
  position: relative;
}

.input-container label {
  position: absolute;
  top: 50%;
  left: 0;
  transform: translateY(-50%);
  color: #888;
  pointer-events: none;
  transition: all 0.2s ease;
}

.input-container input:focus + label,
.input-container input:not(:placeholder-shown) + label {
  top: 10px;
  font-size: 12px;
  color: #555;
}

</style>

  
  <script>
  import AdminNavBar from '../components/AdminNavBar.vue';

  export default {
    name: "AdminHome",
    components:{
      AdminNavBar
    },
    data () {
        return {
          
        }},

    methods: {
        logOut() {
            this.$store.dispatch("auth/logout",).then(
            () => {
            console.log("true");
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
  
  }}
  
  
  </script>