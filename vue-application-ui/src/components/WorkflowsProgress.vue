<template>
    <div class="row">
        <div class="col">
            <div class="relative overflow-x-auto">
                <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                    <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                        <tr style="background-color: #7ca8c8; color: #fff">
                            <th scope="col" class="px-6 py-3">
                                Name
                            </th>
                            <th scope="col" class="px-6 py-3">
                                Workflow
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
                                Workflow #1
                            </td>
                            <td class="px-6 py-4">
                                DD MMMM YYYY
                            </td>
                            <td class="px-6 py-4">
                                Completed
                            </td>
                            <td class="px-6 py-4">
                                
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: "Workflows"
};
</script>