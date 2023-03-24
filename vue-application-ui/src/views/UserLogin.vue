<template>
  <div class="split left">
    <h2>Jane Flex</h2>
    <p>Some image overe here pls.</p>
  </div>

  <div class="split right">
    <div class="center">
 
    <h1 style="font-weight: 600;">Welcome to<br/>Quantum Leap Inc.'s<br/>Vendor Management System</h1><br/>

<Form as="el-form" :validation-schema="schema" @submit="handleLogin">
  <!-- You can use the field component to wrap a 'el-form-item' component -->
  <!-- Do this if you have only one or a few places that need validation -->
  <!-- Note that `element-plus` has its own validation and -->
  <!-- we disabled `validate-event` to avoid having the 2 validation logics conflicting with one another  -->
  <Field name="username" v-slot="{ value, field, errorMessage }">
    <el-form-item :error="errorMessage" required>
      <div class="field">
      <input type="email" id="email" placeholder=" "
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
      <input type="password" id="password" placeholder=" "
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


  </Form>
  <br/>
  <br/>

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
  width:70%;
  display:inline-block;
  transform: translate(0, 30%);
  text-align:left;
}

.field{
  position:relative;
  box-shadow: 1px 1px 10px rgb(238, 236, 236);
  padding: 3px;
}


.field label {
  position: absolute;
  top:20px;
  left:20px;
  color:lightgray;
  transition:all 0.2s ease;
  pointer-events: none;

}

/*.field:focus-within label,
.field input:not(:placeholder-shown) label {*/
.field input:focus + label,
.field input:not(:placeholder-shown) + label  {

  top: 7px;
  left: 15px;
  font-size: 10px;
  color: #777;
}


.field:focus-within {
  border-style: solid;
  border-width:0px 0px 0px 5px;
  border-color: rgb(0, 89, 255);
}



input {
  outline: none;
  border-width:0px;
  height:60px;
  padding-top:15px;
  padding-left: 20px;
  width:100%;
}




div.el-input__wrapper {
  border-radius:0px;
}
  
  .login {
    flex: 1;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  
  .login-button {
    width: 100%;
    margin-top: 40px;
  }
  .login-form {
    width: 290px;
  }
  .forgot-password {
    margin-top: 10px;
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