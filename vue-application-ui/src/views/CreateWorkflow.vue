<template>
<NavBar />

<Form>
  <label for="forms" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Choose a Form to assign:</label>
  <Field>
  <select id="forms" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
    <option selected>Choose a Form</option>
    <option v-for="form in forms" :value="form.formConfigId">{{form.formConfigInfoSet[0].title}}</option>
  </select>
</Field>


</Form>

</template>

<script>
import NavBar from '../components/NavBar.vue';
import UserService from "../services/user.service";
import { Form, Field } from "vee-validate";


export default {
  name: "CreateWorkflow",
  components: { NavBar, Form, Field },
  data() {
    return{
      forms:[],
    }
  },
  methods: {
    getForms(){
      UserService.getListofForms().then(
      (response) => {
        this.forms = response.data;
        console.log(this.forms)
      },
      (error) => {
        this.error =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message || error.message.toString();
          console.log(this.error);

      }
    );
    }

  },
  created() {
    this.getForms();

}}
</script>