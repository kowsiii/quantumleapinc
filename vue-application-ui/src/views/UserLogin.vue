<template>
  <div class="split left">
    <h2>Jane Flex</h2>
    <p>Some image overe here pls.</p>
  </div>

  <div class="split right">
    <div class="center">
      
 
    <h1 style="font-size:40px; font-weight: 700;">Welcome to Quantum Leap Inc.'s Vendor Management System</h1><br/>

<Form as="el-form" :validation-schema="schema" @submit="handleLogin">
  <!-- You can use the field component to wrap a 'el-form-item' component -->
  <!-- Do this if you have only one or a few places that need validation -->
  <!-- Note that `element-plus` has its own validation and -->
  <!-- we disabled `validate-event` to avoid having the 2 validation logics conflicting with one another  -->
  <Field name="username" v-slot="{ value, field, errorMessage }">
    <el-form-item :error="errorMessage" required>
      <div class="field">
        <svg width="30" height="30" style="fill:dimgray;margin-left: 10px;" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><!--! Font Awesome Pro 6.3.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M48 64C21.5 64 0 85.5 0 112c0 15.1 7.1 29.3 19.2 38.4L236.8 313.6c11.4 8.5 27 8.5 38.4 0L492.8 150.4c12.1-9.1 19.2-23.3 19.2-38.4c0-26.5-21.5-48-48-48H48zM0 176V384c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V176L294.4 339.2c-22.8 17.1-54 17.1-76.8 0L0 176z"/></svg>
      
        <input type="email" id="email" placeholder=" " class="border-transparent focus:border-transparent focus:ring-0" required
        v-bind="field"
        :validate-event="false"
        :model-value="value"
      />
      <label for="email">EMAIL</label>
    </div>
    </el-form-item>
  </Field>
<br/>

  <Field name="password" v-slot="{ value, field, errorMessage }">
    <el-form-item :error="errorMessage" required>
      <div class="field">
        <svg width="30" height="25" style="fill:dimgray;margin-left: 10px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><!--! Font Awesome Pro 6.3.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M336 352c97.2 0 176-78.8 176-176S433.2 0 336 0S160 78.8 160 176c0 18.7 2.9 36.8 8.3 53.7L7 391c-4.5 4.5-7 10.6-7 17v80c0 13.3 10.7 24 24 24h80c13.3 0 24-10.7 24-24V448h40c13.3 0 24-10.7 24-24V384h40c6.4 0 12.5-2.5 17-7l33.3-33.3c16.9 5.4 35 8.3 53.7 8.3zM376 96a40 40 0 1 1 0 80 40 40 0 1 1 0-80z"/></svg>      <input type="password" id="password" placeholder=" " class="border-transparent focus:border-transparent focus:ring-0" required
        v-bind="field"
        :validate-event="false"
        :model-value="value"
      />
      <label for="password">PASSWORD</label>
    </div>
    </el-form-item>
  </Field>

<br/>
    <div style="text-align: right;">
      <el-button type="primary" native-type="submit">Login</el-button><br/><br/>
      <a href="www.google.com">Forgot password?</a><br/>
      <a></a>
    </div>
    <div v-if="message" class="alert alert-danger" role="alert">
            {{ message }}
          </div>

  </Form>

  </div>

</div>

</template>

<style>
  .split {
  height: 100%;
  position: fixed;
  top: 0;
  overflow-x: hidden;
}

/* Control the left side */
.left {
  left: 0;
  width: 40%;
  background-color: lightgray;
}

/* Control the right side */
.right {
  right: 0;
  width: 60%;

}

.center {
  width:60%;
  display:inline-block;
  transform: translate(0, 30%);
  text-align:left;
}

.field{
  position:relative;
  box-shadow: 1px 1px 10px rgb(238, 236, 236);
  padding: 3px;
  display: flex;
  align-items: center;
}


.field label {
  position: absolute;
  top:20px;
  left:65px;
  color:lightgray;
  transition:all 0.2s ease;
  pointer-events: none;


}

.field input:focus + label,
.field input:not(:placeholder-shown) + label  {

  top: 7px;
  left: 53px;
  font-size: 10px;
  color: #777;
}


.field:focus-within {
  border-style: solid;
  border-width:0px 0px 0px 5px;
  border-color: rgb(0, 89, 255);
}



input {
  border: none;
  border-width:0px;
  height:60px;
  padding-top:15px;
  padding-left: 20px;
  width:100%;


}


  </style>
  

<script>
import { Form, Field } from "vee-validate";

export default {
  name: "UserLogin",
  data () {
      return {
        email:"",
        password:"",
        input:"",
        message:"",

      }
    },
  components: {
    Form,
    Field,

  },
  computed: {

  },
  created() {
    if (this.$store.state.auth.status.loggedIn) {
      var user = this.$store.state.auth.user;
      console.log(user);
      if (user.roles.includes("ROLE_ADMIN")) {
        this.$router.push("/admin");
      } else if (user.roles.includes("ROLE_APPROVER")) {
        this.$router.push("/approver");
      } else if (user.roles.includes("ROLE_VENDOR")) {
        this.$router.push("/vendor");
      }
      
    }
  },
  methods: {
    handleLogin(loggeduser) {
      this.loading = true;
      console.log("2");

      this.$store.dispatch("auth/login", loggeduser).then(
        () => {
          // this.$router.push("/admin");
          var user = this.$store.state.auth.user;
          if (user.roles.includes("ROLE_ADMIN")) {
            this.$router.push("/admin");
          } else if (user.roles.includes("ROLE_APPROVER")) {
            this.$router.push("/approver");
          } else if (user.roles.includes("ROLE_VENDOR")) {
            this.$router.push("/vendor");
          }
        },
        (error) => {
          this.loading = false;
          this.message = "Username and password do not match"||
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();
        }
      );
    }
  }
};


</script>