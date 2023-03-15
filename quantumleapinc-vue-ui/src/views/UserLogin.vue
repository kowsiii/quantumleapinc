<template>
  <Form @submit="handleLogin">
  <div class="col-md-6">
    <div class="card card-container">
      <label for="email">Email/Username:</label>
      <Field type="text" id="email" name="username" v-model="email"></Field><br><br>
      <label for="password">Password:</label>
      <Field type="password" id="password" name="password" v-model="password"></Field><br><br>
      <button>Submit</button> 
    </div>
  </div>
</Form>
</template>

<script>
import { Form, Field } from "vee-validate";
export default {
  name: "UserLogin",
  data () {
      return {
        email:"",
        password:""

      }
    },
  components: {
    Form,
    Field,

  },
    created() {
    if (this.$store.state.auth.status.loggedIn) {
      this.$router.push("/home");
    }
  },
  methods: {
    handleLogin(user) {
      this.loading = true;
      console.log(user)

      this.$store.dispatch("auth/login", user).then(
        () => {
          this.$router.push("/home");
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
  }

}

</script>