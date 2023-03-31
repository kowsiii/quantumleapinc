<template>
    <select id="small" class="block w-full p-2 mb-6 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
        <option v-for="option in options">
            {{ option.value }}
        </option>
    </select>
</template>

<script>
import inputMixin from './input.js';
export default {
    name: "SelectInput",
    mixins:[inputMixin],
    props: {


    },
    data() {

    }
}
</script>