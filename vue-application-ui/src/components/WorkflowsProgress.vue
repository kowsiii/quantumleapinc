<template>
    <div class="container-fluid py-4 px-20">
        <div class="row">
            <div class="col-md-10 mb-4">
                <h4 class="text-2xl font-bold dark:text-white">Workflow Status</h4>
                <div class="pt-2"><h6 class="text-md font-bold dark:text-white">Workflow #X</h6></div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="relative overflow-x-auto">
                    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                        <thead class="text-base text-gray-700 bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                            <tr style="background-color: #7ca8c8; color: #fff">
                                <th scope="col" class="px-6 py-3">
                                    Name
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Form
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Questionnaire
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Assigned Date
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Status
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Action
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    User one
                                </th>
                                <td class="px-6 py-4">
                                    Form Name
                                </td>
                                <td class="px-6 py-4">
                                    Questionnaire Name
                                </td>
                                <td class="px-6 py-4">
                                    DD MMMM YYYY
                                </td>
                                <td class="px-6 py-4">
                                    <span v-if="status === 'Not Started'" class="bg-red-100 text-red-800 text-sm font-medium mr-2 px-2.5 py-0.5 rounded dark:bg-red-900 dark:text-red-300">Not Started</span>
                                    <span v-else-if="status === 'In Progress'" class="bg-yellow-100 text-yellow-800 text-sm font-medium mr-2 px-2.5 py-0.5 rounded dark:bg-yellow-900 dark:text-yellow-300">In Progress</span>
                                    <span v-else-if="status === 'Completed'" class="bg-green-100 text-green-800 text-sm font-medium mr-2 px-2.5 py-0.5 rounded dark:bg-green-900 dark:text-green-300">Completed</span>
                                </td>
                                <td class="px-6 py-4">
                                    <span v-if="status === 'Completed'">
                                        <font-awesome-icon icon="fa-file-pen" size="xl"/>
                                    </span>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: "WorkflowsProgress",
  data() {
    return {
        status: "Completed"
    }
  }
};
</script>