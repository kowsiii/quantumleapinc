<template>
    <NavBar :user="user"/>
    <div class="container-fluid py-4 px-20">
    <div class="row mb-4">
      <div class="col-md-10">
        <h4 class="text-2xl font-bold dark:text-white">Forms</h4>
      </div>
      <div class="col-md-2">
        <button class="btn btn-primary mb-2" role="button" value="">Add Form</button>
    </div>
    </div>
    <div class="row">
      <div class="col">
        <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
          <thead class="text-base text-gray-700 bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr style="background-color: #7ca8c8; color: #fff">
              <th scope="col" style="width: 80%" class="px-6 py-3">Form</th>
              <th scope="col" class="px-6 py-3">Action(s)</th>
            </tr>
          </thead>
          <tbody>
            <!--Need to for loop this part-->
              <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                  <!--This part need to change according to the workflow data-->
                  <h5 style="font-size: 17px; font-weight: bold">Form Name</h5>
                </th>
                <td class="px-6 py-4">
                  <button class="btn btn-primary px-3 py-2 m-2" role="button" value="">Edit</button>
                  <button class="btn btn-danger px-3 py-2 m-2" role="button" value="">Delete</button>
                </td>
              </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import NavBar from "../components/NavBar.vue";

export default{
  name: "Forms",
  components: {
    NavBar
  },
  data() {
    return {
      user: 'admin',
    };
  }
}
</script>