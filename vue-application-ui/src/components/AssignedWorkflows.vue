<template>
  <div class="container-fluid py-4 px-20">
    <div class="row">
      <!--For all the records-->
      <div v-if="status === 'all'" class="col-md-10 mb-4">
        <h4 class="text-2xl font-bold dark:text-white">All</h4>
      </div>

      <!--For assigned records-->
      <div v-if="status === 'assigned'" class="col-md-10 mb-4">
        <h4 class="text-2xl font-bold dark:text-white">Assigned</h4>
      </div>

      <!--For in progress records-->
      <div v-if="status === 'inprogress'" class="col-md-10 mb-4">
        <h4 class="text-2xl font-bold dark:text-white">In Progress</h4>
      </div>

      <!--For completed records-->
      <div v-if="status === 'completed'" class="col-md-10 mb-4">
        <h4 class="text-2xl font-bold dark:text-white">Completed</h4>
      </div>
    </div>
    <div class="row">
      <div class="col">
        <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
          <thead class="text-base text-gray-700 bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr style="background-color: #7ca8c8; color: #fff">
              <th scope="col" style="width: 85%" class="px-6 py-3">Workflow</th>
              <th scope="col" class="px-6 py-3">Action</th>
            </tr>
          </thead>
          <tbody>
            <!--For all the records-->
            <template v-if="status === 'all'">
              <!--Need to check if vendor or admin-->
              <!--For loop tr-->
              <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                  <!--This part need to change according to the workflow data-->
                  <h5 style="font-size: 17px; font-weight: bold">Workflow #1</h5>
                  <section class="my-2 p-2" style="background-color: #e5eff5">
                    <p class="align-middle" style="font-size: 14px">
                      <span style="font-weight: bold">Form: </span>Form Name
                    </p>
                    <p class="align-middle my-2" style="font-size: 14px">
                      <span style="font-weight: bold">Questionnaire: </span>Questionnaire Name
                    </p>
                    <p class="align-middle" style="font-size: 14px">
                      <span style="font-weight: bold">Assigned Date: </span>DD MMMM YYYY
                    </p>
                  </section>
                </th>
                <td class="px-6 py-4">
                  <!--<button type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">Default</button>-->

                  <!--Need to check the status of the record to print the button accordingly-->
                  <button class="btn btn-primary px-3 py-2 m-2" role="button" value="">View Details</button>
                </td>
              </tr>
            </template>

            <!--For assigned records-->
            <template v-if="status === 'assigned'">
              <!--For loop tr-->
              <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                  <!--This part need to change according to the workflow data-->
                  <h5 style="font-size: 16px; font-weight: bold">Workflow #1</h5>
                  <section class="my-2 p-2" style="background-color: #e5eff5">
                    <p class="align-middle" style="font-size: 14px">
                      <span style="font-weight: bold">Form: </span>Form Name
                    </p>
                    <p class="align-middle my-2" style="font-size: 14px">
                      <span style="font-weight: bold">Questionnaire: </span>Questionnaire Name
                    </p>
                    <p class="align-middle" style="font-size: 14px">
                      <span style="font-weight: bold">Assigned Date: </span> DD MMMM YYYY
                    </p>
                  </section>
                </th>
                <td class="px-6 py-4">
                  <!--<button type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">Default</button>-->
                  <button class="btn btn-primary px-3 py-2 m-2" role="button" value="">Start</button>
                </td>
              </tr>
            </template>

            <!--For In Progress records-->
            <template v-if="status === 'inprogress'">
              <!--For loop tr-->
              <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                  <!--This part need to change according to the workflow data-->
                  <h5 style="font-size: 17px; font-weight: bold">Workflow #1</h5>
                  <section class="my-2 p-2" style="background-color: #e5eff5">
                    <p class="align-middle" style="font-size: 14px">
                      <span style="font-weight: bold">Form: </span>Form Name
                    </p>
                    <p class="align-middle my-2" style="font-size: 14px">
                      <span style="font-weight: bold">Questionnaire: </span>Questionnaire Name
                    </p>
                    <p class="align-middle" style="font-size: 14px">
                      <span style="font-weight: bold">Assigned Date: </span>DD MMMM YYYY
                    </p>
                  </section>
                </th>
                <td class="px-6 py-4">
                  <!--<button type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">Default</button>-->
                  <button class="btn btn-primary px-3 py-2 m-2" role="button" value="">Edit</button>
                </td>
              </tr>
            </template>

            <!--For Completed records-->
            <template v-if="status === 'completed'">
              <!--For loop tr-->
              <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                  <!--This part need to change according to the workflow data-->
                  <h5 style="font-size: 17px; font-weight: bold">Workflow #1</h5>
                  <section class="my-2 p-2" style="background-color: #e5eff5">
                    <p class="align-middle" style="font-size: 14px">
                      <span style="font-weight: bold">Form: </span>Form Name
                    </p>
                    <p class="align-middle my-2" style="font-size: 14px">
                      <span style="font-weight: bold">Questionnaire: </span>Questionnaire Name
                    </p>
                    <p class="align-middle" style="font-size: 14px">
                      <span style="font-weight: bold">Assigned Date: </span>DD MMMM YYYY
                    </p>
                  </section>
                </th>
                <td class="px-6 py-4">
                  <!--<button type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">Default</button>-->
                  <button class="btn btn-primary px-3 py-2 m-2" role="button" value="">View</button>
                </td>
              </tr>
            </template>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AssignedWorkflows",
  props: {
    status: {
      type: String,
      required: true,
    },
  },
  // Component options go here
};
</script>

<style>
/* Component styles go here */
</style>
