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
        <svg width="30" height="30" style="fill:dimgray;margin-left: 10px;" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><!--! Font Awesome Pro 6.3.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M256 64C150 64 64 150 64 256s86 192 192 192c17.7 0 32 14.3 32 32s-14.3 32-32 32C114.6 512 0 397.4 0 256S114.6 0 256 0S512 114.6 512 256v32c0 53-43 96-96 96c-29.3 0-55.6-13.2-73.2-33.9C320 371.1 289.5 384 256 384c-70.7 0-128-57.3-128-128s57.3-128 128-128c27.9 0 53.7 8.9 74.7 24.1c5.7-5 13.1-8.1 21.3-8.1c17.7 0 32 14.3 32 32v80 32c0 17.7 14.3 32 32 32s32-14.3 32-32V256c0-106-86-192-192-192zm64 192a64 64 0 1 0 -128 0 64 64 0 1 0 128 0z"/></svg>
      
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
        <svg width="30" height="25" style="fill:dimgray;margin-left: 10px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><!--! Font Awesome Pro 6.3.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M144 144v48H304V144c0-44.2-35.8-80-80-80s-80 35.8-80 80zM80 192V144C80 64.5 144.5 0 224 0s144 64.5 144 144v48h16c35.3 0 64 28.7 64 64V448c0 35.3-28.7 64-64 64H64c-35.3 0-64-28.7-64-64V256c0-35.3 28.7-64 64-64H80z"/></svg>      <input type="password" id="password" placeholder=" " class="border-transparent focus:border-transparent focus:ring-0" required
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
  margin-left:20%;
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