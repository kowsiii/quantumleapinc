<template>
    <div>

      <button @click="logOut">Go to FormBuilder</button>
    </div>

    <div class="input-container">
  <input type="text" id="input-field" placeholder="Enter your name">
  <label for="input-field">Enter your name</label>
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

  export default {
    name: "AdminHome",
    components:{
      
    },
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
  
  }}
  
  </script>