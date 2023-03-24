<template>

<!--<el-input placeholder="Please input" />
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
</Form>-->

  <body :style="backgroundStyle" style="position:absolute; top:0; left:0; width:100%; height:100%;">
    <div class="container">
      <section>
        <div class="flex flex-col items-center justify-center px-6 py-8 mx-auto md:h-screen lg:py-0">
            <div class="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
              <a href="#" class="flex items-center mb-6 text-2xl font-semibold text-gray-900 dark:text-white m-0 pt-3">
                <img class="w-15 h-20 mx-auto" src="../assets/company_logo.jpg" alt="logo">    
              </a>
                <div class="p-6 space-y-4 md:space-y-6 sm:p-8">
                    <h1 class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
                        Sign in to your account
                    </h1>
                    <form class="space-y-4 md:space-y-6" action="#">
                        <div>
                            <label for="email" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Email/Username</label>
                            <input type="email" name="username" id="email" v-model="email" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="name@company.com" required="">
                        </div>
                        <div>
                            <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
                            <input type="password" name="password" id="password" placeholder="••••••••" v-model="password" class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required="">
                        </div>
                        <div class="flex items-center justify-between">
                            <div class="flex items-start">
                                <div class="flex items-center h-5">
                                  <input id="remember" aria-describedby="remember" type="checkbox" class="w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-primary-300 dark:bg-gray-700 dark:border-gray-600 dark:focus:ring-primary-600 dark:ring-offset-gray-800" required="">
                                </div>
                                <div class="ml-3 text-sm">
                                  <label for="remember" class="text-gray-500 dark:text-gray-300">Remember me</label>
                                </div>
                            </div>
                            <a href="#" class="text-sm font-medium text-primary-600 hover:underline dark:text-primary-500">Forgot password?</a>
                        </div>
                        <button type="button" class="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">Sign in</button>
                    </form>
                </div>
            </div>
        </div>
      </section>
    </div>
  </body>
</template>

<script>
import { Form, Field } from "vee-validate";
import LoginComponent from "@/components/LoginComponent.vue";
import backgroundImage from "@/assets/background.jpg";

export default {
  name: "UserLogin",
  data() {
    return {
      email: "",
      password: "",
      backgroundImageUrl: backgroundImage,
    };
  },
  computed: {
    backgroundStyle() {
      return {
        "background-image": `url(${this.backgroundImageUrl})`,
        "background-size": "cover",
        "background-position": "center"
      };
    }
  },
  created() {
    if (this.$store.state.auth.status.loggedIn) {
      this.$router.push("/home");
    }
  },
  methods: {
    handleLogin(user) {
      this.loading = true;
      console.log(user);

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
    }
  }
};


</script>