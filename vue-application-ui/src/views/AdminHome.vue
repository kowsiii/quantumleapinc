<template>
  <NavBar :is-vendor="false" />
  <div class="container-fluid py-4 px-20">
    <div class="row">
      <div class="col-md-10 mb-4">
        <h4 class="text-2xl font-bold dark:text-white">Workflows</h4>
      </div>
    </div>
        
    <div class="row">
      <!--For new workflow-->
      <div class="col-4">
        <div class="max-w-xs bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
          <div class="relative h-44">
            <!--Go to the design workflow page-->
            <a href="#">
              <img class="w-full h-full rounded-t-lg" style="object-fit: contain;" src="../assets/add.png" alt="" onmouseover="this.style.opacity='0.7';" onmouseout="this.style.opacity='1';" />
            </a>
          </div>
          <div class="p-2">
            <p class="font-normal text-gray-700 dark:text-gray-400 text-center">Blank</p>
          </div>
        </div>
      </div>

      <!--Existing workflow (need for loop)-->
      <div class="col-4">
        <div class="max-w-xs bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
          <div class="relative h-44">
            <!--Go to the selected workflow page-->
            <a href="#">
              <img class="w-full h-full rounded-t-lg" style="object-fit: contain;" src="../assets/workflow.png" alt="" onmouseover="this.style.opacity='0.7';" onmouseout="this.style.opacity='1';" />
            </a>
            <div class="absolute top-0 right-0">
              <button id="dropdownButton" data-dropdown-toggle="dropdown" class="inline-block text-gray-500 dark:text-gray-400 dark:hover:bg-gray-700 focus:outline-none focus:ring-gray-200 dark:focus:ring-gray-700 rounded-lg text-sm p-1.5" type="button">
                <span class="sr-only">Open dropdown</span>
                <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M6 10a2 2 0 11-4 0 2 2 0 014 0zM12 10a2 2 0 11-4 0 2 2 0 014 0zM16 12a2 2 0 100-4 2 2 0 000 4z"></path></svg>
              </button>
              <!-- Dropdown menu -->
              <div id="dropdown" class="z-10 hidden text-base list-none bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700">
                <ul class="py-2" aria-labelledby="dropdownButton">
                  <li>
                    <router-link to="/admin/manageworkflows/workflowassignment" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Assignment</router-link>
                  </li>
                  <li>
                    <router-link to="/admin/manageworkflows/workflowstatus" class="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white">Status</router-link>
                  </li>
                </ul>
              </div>
            </div>
          </div>

          <div class="p-2">
            <p class="font-normal text-gray-700 dark:text-gray-400 text-center">Workflow</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import NavBar from "../components/NavBar.vue";

export default {
  name: "AdminHome",
  components: {
    NavBar
  },
  created() {
    document.title = "Workflows";
  }

};
</script>