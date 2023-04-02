<template>
    <NavBar :user="user"/>
    <div class="container-fluid py-4 px-20">
    <div class="row mb-4">
      <div class="col-md-10">
        <h4 class="text-2xl font-bold dark:text-white">Forms</h4>
      </div>
      <div class="col-md-2">
        <button data-modal-target="form-modal" data-modal-toggle="form-modal" type="button" class="flex items-center justify-center px-3 py-2 text-sm font-medium text-white rounded-lg bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">
            + Create New Form
          </button>

          <div id="form-modal" tabindex="-1" aria-hidden="true" class="fixed top-0 left-0 right-0 z-50 hidden w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-[calc(100%-1rem)] md:h-full">
    <div class="relative w-full h-full max-w-md md:h-auto">
        <!-- Modal content -->
        <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
            <button data-modal-hide="form-modal" type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white">
                <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                <span class="sr-only">Close modal</span>
            </button>
            <div class="px-6 py-6 lg:px-8">
                <h3 class="mb-4 text-xl font-medium text-gray-900 dark:text-white"> Create a New Form</h3>
                <Form class="space-y-6" @submit="createForm">
                    <div>
                        <label for="title" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Form Title:</label>
                        <Field type="text" name="title" id="title" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Form Title" required />
                    </div>
                    
                    
                    <button data-modal-hide="form-modal" type="submit" class="px-3 py-2.5 text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Go to Form Builder</button>
                    
                  </Form>
            </div>
        </div>
    </div>
</div> 

    </div>
    </div>


    <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
                <th scope="col" class="px-6 py-3">
                    Form name
                </th>
                <th scope="col" class="px-6 py-3">
                    Created Date
                </th>
                <th scope="col" class="px-6 py-3">
                    Last Modified
                </th>
                <th scope="col" class="px-6 py-3">
                    Status
                </th>
                <th scope="col" class="px-6 py-3">
                    <span class="sr-only">Edit</span>
                </th>
            </tr>
        </thead>
        <tbody>
            <tr v-for='items in forms' class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    {{ items.formConfigInfoSet[0].title }}
                </th>
                <td class="px-6 py-4">
                    {{ items.createdDate }}
                </td>
                <td class="px-6 py-4">
                    {{ items.modifiedDate }}
                </td>
                <td class="px-6 py-4">
                    {{ items.activeStatus  }}
                </td>
                <td class="px-6 py-4 text-right">
                    <a href="#" @click="editForm(items)" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Edit</a>
                </td>
                <td class="px-6 py-4 text-right">
                    <a href="#" class="font-medium text-red-600 dark:text-red-500 hover:underline">Delete</a>
                </td>
            </tr>
            
        </tbody>
    </table>
</div>

  </div>
</template>

<script>
import NavBar from "../components/NavBar.vue";
import { Form, Field } from "vee-validate";
import UserService from "../services/user.service";

export default{
  name: "Forms",
  components: {
    NavBar, Form, Field
  },
  data() {
    return {
      user: 'admin',
      forms:""
    };
  },
  methods: {
    createForm(title) {
        this.$router.push('/formbuilder')
//       UserService.newForm({title:title.title, formDesign:`{"design": [{ "name": "Section 1", "fields": [] }]}`}).then(
//       (response) => {
//         this.$router.push({
//   path: '/formbuilder',
//   query: {
//     data: JSON.stringify({title:title.title, formDesign:`{"design": [{ "fields": [] }]}`})
//   }
// });
//       },
//       (error) => {
//         this.error =
//           (error.response &&
//             error.response.data &&
//             error.response.data.message) ||
//           error.message || error.message.toString();
//           console.log(this.error);

//       }
//     );
      
    },
    editForm(item) {
        
        this.$router.push({
        path: '/formbuilder',
        query: {
        data: JSON.stringify({formConfigId:item.formConfigId})
    }
    });


    },

    getForms() {
        UserService.getListofForms().then(
      (response) => {
       
        console.log(response.data)
        this.forms = response.data
    
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
    
  },
}
</script>