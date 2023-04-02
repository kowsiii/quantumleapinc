<script setup>
import { onMounted } from "vue";
import { initFlowbite } from "flowbite";

onMounted(() => {
  initFlowbite();
});
</script>

<template>
<NavBar />

<div class="relative overflow-x-auto m-12 sm:rounded-lg">
    <div class="flex items-center justify-between py-4 bg-white dark:bg-gray-800">
    
        <label for="table-search" class="sr-only">Search</label>
        <div class="relative">
            <div class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
                <svg class="w-5 h-5 text-gray-500 dark:text-gray-400" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z" clip-rule="evenodd"></path></svg>
            </div>
            <input type="text" id="table-search-users" class="block pl-10 text-sm text-gray-900 border border-gray-300 rounded-lg w-80 bg-gray-50 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Search for users">
        </div>

        <button type="button" data-modal-target="authentication-modal" data-modal-toggle="authentication-modal"
                class="flex items-center justify-center px-4 py-2 m-2 text-sm font-medium text-white rounded-lg bg-blue-700 hover:bg-primary-800 focus:ring-4 focus:ring-primary-300 dark:bg-primary-600 dark:hover:bg-primary-700 focus:outline-none dark:focus:ring-primary-800">
          <svg xmlns="http://www.w3.org/2000/svg" class="h-3.5 w-3.5 mr-2 -ml-1" viewBox="0 0 20 20" fill="currentColor"
               aria-hidden="true">
            <path
              d="M8 9a3 3 0 100-6 3 3 0 000 6zM8 11a6 6 0 016 6H2a6 6 0 016-6zM16 7a1 1 0 10-2 0v1h-1a1 1 0 100 2h1v1a1 1 0 102 0v-1h1a1 1 0 100-2h-1V7z"/>
          </svg>
          Add new user
        </button>

       
<div id="authentication-modal" tabindex="-1" aria-hidden="true" class="fixed top-0 left-0 right-0 z-50 hidden w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-[calc(100%-1rem)] md:h-full">
    <div class="relative w-full h-full max-w-md md:h-auto">
        
        <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
            <button type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white" data-modal-hide="authentication-modal">
                <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                <span class="sr-only">Close modal</span>
            </button>
            <div class="px-6 py-6 lg:px-8">
                <h3 class="mb-4 text-xl font-medium text-gray-900 dark:text-white">Register New User</h3>
                <Form class="space-y-6" as="form" @submit="addUser">
                
                    
                        <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Name</label>
                        <Field type="text" name="name" id="name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Name" required />
                    
                    <div>
                        <label for="email" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Email</label>
                        <Field type="email" name="username" id="email" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="name@company.com" required />
                    </div>
                    <div>
                        <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
                        <Field type="text" name="password" id="password" placeholder="Password here..." class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required />
                    </div>
                    <div>
                        
<h3 class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Role</h3>
<ul class="items-center w-full text-sm font-medium text-gray-900 bg-white border border-gray-200 rounded-lg sm:flex dark:bg-gray-700 dark:border-gray-600 dark:text-white">
    <li class="w-full border-b border-gray-200 sm:border-b-0 sm:border-r dark:border-gray-600">
        <div class="flex items-center pl-3">
            <Field id="approver" type="radio" value="approver" name="role" class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-700 dark:focus:ring-offset-gray-700 focus:ring-2 dark:bg-gray-600 dark:border-gray-500" />
            <label for="approver" class="w-full py-3 ml-2 text-sm font-medium text-gray-900 dark:text-gray-300">Approver</label>
        </div>
    </li>
    <li class="w-full border-b border-gray-200 sm:border-b-0 sm:border-r dark:border-gray-600">
        <div class="flex items-center pl-3">
            <Field id="admin" type="radio" value="admin" name="role" class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-700 dark:focus:ring-offset-gray-700 focus:ring-2 dark:bg-gray-600 dark:border-gray-500" />
            <label for="admin" class="w-full py-3 ml-2 text-sm font-medium text-gray-900 dark:text-gray-300">Admin</label>
        </div>
    </li>
    <li class="w-full border-b border-gray-200 sm:border-b-0 sm:border-r dark:border-gray-600">
        <div class="flex items-center pl-3">
            <Field id="vendor" type="radio" value="vendor" name="role" class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-700 dark:focus:ring-offset-gray-700 focus:ring-2 dark:bg-gray-600 dark:border-gray-500" />
            <label for="vendor" class="w-full py-3 ml-2 text-sm font-medium text-gray-900 dark:text-gray-300">Vendor</label>
        </div>
    </li>

</ul>

                    </div>
                   
                    <button data-modal-hide="authentication-modal" type="submit" class="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Register User</button>
                    
                
            </Form>
            </div>
        </div>
    </div>
</div> 

    </div>
    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
           
                <th scope="col" class="px-6 py-3">
                    Name
                </th>
                <th scope="col" class="px-6 py-3">
                    Position
                </th>
 
                <th scope="col" class="px-6 py-3">
                    Action
                </th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="user in latestUsers" class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">
               
                <th scope="row" class="flex items-center px-6 py-4 text-gray-900 whitespace-nowrap dark:text-white">
                    <div class="pl-3">
                        <div class="text-base font-semibold">{{ user.name }}</div>
                        <div class="font-normal text-gray-500">{{user.username}}</div>
                    </div>  
                </th>
                <td class="px-6 py-4">
                    {{user.roles[0].name}}
                </td>
               
                <td class="px-6 py-4">
                    <!-- Modal toggle -->
                    <a href="#" type="button" data-modal-target="editUserModal" data-modal-show="#editUserModal" @click="modalHandlerOpen(user)" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Edit user</a>
                </td>
            </tr>
            
        </tbody>
    </table>

    <!-- Edit user modal -->
    <div id="editUserModal" tabindex="-1" aria-hidden="true" class="fixed top-0 left-0 right-0 z-50 items-center justify-center hidden w-full p-4 overflow-x-hidden overflow-y-auto md:inset-0 h-[calc(100%-1rem)] md:h-full">
        <div class="relative w-full h-full max-w-md md:h-auto">
        
        <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
            <button @click="modalHandlerClose" type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white" data-modal-hide="authentication-modal">
                <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
                <span class="sr-only">Close modal</span>
            </button>
            <div class="px-6 py-6 lg:px-8">
                <h3 class="mb-4 text-xl font-medium text-gray-900 dark:text-white">Update User Details</h3>
                <Form class="space-y-6" as="form" @submit="editUser">
                
                    
                        <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Name</label>
                        <Field type="text" name="name" id="name" v-model="selecteduser.name" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="Name" required />
                    
                    <div>
                        <label for="email" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Email</label>
                        <Field type="email" name="username" id="email" v-model="selecteduser.username" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" placeholder="name@company.com" required />
                    </div>
                    <div>
                        <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
                        <Field type="text" name="password" id="password" placeholder="Password here..." class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white" required />
                    </div>
                    <div>
                        
<h3 class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Role</h3>
<ul class="items-center w-full text-sm font-medium text-gray-900 bg-white border border-gray-200 rounded-lg sm:flex dark:bg-gray-700 dark:border-gray-600 dark:text-white">
    <li class="w-full border-b border-gray-200 sm:border-b-0 sm:border-r dark:border-gray-600">
        <div class="flex items-center pl-3">
           
            <Field v-model="selecteduser.roles[0].name" id="approver" type="radio" value="ROLE_APPROVER" name="role" class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-700 dark:focus:ring-offset-gray-700 focus:ring-2 dark:bg-gray-600 dark:border-gray-500" v-if="selecteduser!=''" v-validate="{ sameAs: 'ROLE_APPROVER' }" />
            <label for="approver" class="w-full py-3 ml-2 text-sm font-medium text-gray-900 dark:text-gray-300">Approver</label>
            
        </div>
    </li>
    <li class="w-full border-b border-gray-200 sm:border-b-0 sm:border-r dark:border-gray-600">
        <div class="flex items-center pl-3">
            
            <Field v-model="selecteduser.roles[0].name" id="admin" type="radio" value="ROLE_ADMIN" name="role" class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-700 dark:focus:ring-offset-gray-700 focus:ring-2 dark:bg-gray-600 dark:border-gray-500" v-if="selecteduser!=''" v-validate="{ sameAs: 'ROLE_ADMIN' }"/>
            <label for="admin" class="w-full py-3 ml-2 text-sm font-medium text-gray-900 dark:text-gray-300">Admin</label>
          
        </div>
    </li>
    <li class="w-full border-b border-gray-200 sm:border-b-0 sm:border-r dark:border-gray-600">
        <div class="flex items-center pl-3">
            
            <Field v-model="selecteduser.roles[0].name" id="vendor" type="radio" value="ROLE_VENDOR" name="role" class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-700 dark:focus:ring-offset-gray-700 focus:ring-2 dark:bg-gray-600 dark:border-gray-500" v-if="selecteduser!=''" v-validate="{ sameAs: 'ROLE_VENDOR' }" />
            <label for="vendor" class="w-full py-3 ml-2 text-sm font-medium text-gray-900 dark:text-gray-300">Vendor</label>
            
        </div>
    </li>

</ul>

                    </div>
                   
                    <button @click="modalHandlerClose" data-modal-hide="editUserModal" type="submit" class="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Update</button>
                    
                
            </Form>
            </div>
        </div>
    </div>
    </div>
</div>

</template>

<script>
import { Form, Field } from "vee-validate";
import NavBar from '../components/NavBar.vue';
import UserService from "../services/user.service";

export default {
  name: "UserManagement",
  components:{
    NavBar, Form, Field,
  },
  data() {
    return {
        users: [],
        error:"",
        render: false,
        user: "admin",
        selecteduser:""
    };
  },
  computed: {
    latestUsers() {
        for (let i=0; i<this.users.length;i++) {
            if(!this.users[i].activeStatus) {
                this.users.splice(i, 1); // Remove the element at index i
                i--; // Decrement i to account for the removed element
            }
        }
        return this.users;
    }
  },

  methods: {
    addUser(createdUser) {
        UserService.createUser(createdUser).then(
      (response) => {
        console.log(response.data)
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
    this.getUsers()
    },
    getUsers() {
        UserService.getUsers().then(
      (response) => {
        this.users = response.data;
        console.log(this.latestUsers)
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
    },
    modalHandlerOpen(user){
        this.selecteduser = user
        console.log('working');
        document.getElementById("editUserModal").style.display = "block"
        document.getElementById("editUserModal").className += "show"
        console.log(this.selecteduser.roles[0].name)
    },
    modalHandlerClose(){
        document.getElementById("editUserModal").style.display = "none"
        document.getElementById("editUserModal").className += document.getElementById("exampleModal").className.replace("show", "")
    },
    editUser(user) {
        console.log(user)
        UserService.editUser().then(
      (response) => {
        this.users = response.data;
        console.log(this.latestUsers)
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
    this.getUsers();
    var modal = document.getElementById("editUserModal")
    
  },
        

};

</script>