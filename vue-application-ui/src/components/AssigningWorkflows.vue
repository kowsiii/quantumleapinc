<template>
    <div class="container-fluid py-4 px-20">
        <div class="row">
            <div class="col-md-10 mb-4">
                <h4 class="text-2xl font-bold dark:text-white">Form Assignment</h4>
                <div class="pt-2"><h6 class="text-md font-bold dark:text-white">Workflow #X</h6></div>
            </div>
        </div> 
        <div class="row">
            <div class="col-md-6">
                <div class="col-md-10 my-2">
                    <h6 class="text-md font-bold dark:text-white">Unassigned Users</h6>
                </div>
                <div class="relative overflow-x-auto">
                    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                        <thead class="text-base text-gray-700 bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                            <tr style="background-color: #7ca8c8; color: #fff">
                                <th scope="col" style="width: 85%" class="px-6 py-3">
                                    Name
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Action
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--Need to use for loop-->
                            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    User x
                                </th>
                                <td class="px-6 py-4">
                                    <button type="button" class="focus:outline-none text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:ring-green-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800">Assign</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
    
            <div class="col-md-6 mt-md-0 mt-4">
                <div class="col-md-10 my-2">
                    <h6 class="text-md font-bold dark:text-white">Assigned Users</h6>
                </div>
                <div class="relative overflow-x-auto">
                    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                        <thead class="text-base text-gray-700 bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                            <tr style="background-color: #7ca8c8; color: #fff">
                                <th scope="col" style="width: 85%" class="px-6 py-3">
                                    Name
                                </th>
                                <th scope="col" class="px-6 py-3">
                                    Action
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--Need to use for loop-->
                            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    User y
                                </th>
                                <td class="px-6 py-4">
                                    <button type="button" class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900">Unassign</button>
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
  name: "AssigningWorkflows"
};

</script>