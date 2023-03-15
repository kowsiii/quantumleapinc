<template>
    
    <div class="col-md-6">
        <Form @submit="handleRegister">
      <div class="card card-container">
        <label for="email">Email/Username:</label>
        <Field type="text" id="email" name="username" v-model="email"></Field><br><br>
        <label for="password">Password:</label>
        <Field type="password" id="password" name="password" v-model="password"></Field><br><br>
        <label for="role">Role:</label>
        <Field as="select" id="role" name="role" v-model="selectedrole">
            <option value="admin">Admin</option>
            <option value="user">User</option>
        </Field><br><br>
        <button>Submit</button> 
      </div>
    </Form>
    <div
        v-if="message"
        class="alert"
        :class="successful ? 'alert-success' : 'alert-danger'"
      >
        {{ message }}
      </div>
    </div>
  
  
  </template>
  
  <script>
  import { Form, Field } from "vee-validate";
  export default {
    name: "RegisterUser",

    data () {
        return {
          email:"",
          password:"",
          selectedrole:"",
          successful: false,
        loading: false,
        message: "",
        }
      },
    components: {
      Form,
      Field,
  
    },
  
    methods: {
        handleRegister(user) {
      this.message = "";
      this.successful = false;
      this.loading = true;

      this.$store.dispatch("auth/register", user).then(
        (data) => {
        console.log(user)
          this.message = data.message;
          this.successful = true;
          this.loading = false;
        },
        (error) => {
          this.message =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();
          this.successful = false;
          this.loading = false;
        }
      );
    },
    }
  
  }
  
  </script>