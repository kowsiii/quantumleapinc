<template>
    <div class="mt-0.5" v-bind:class="{'flex': inline}">
    <div v-for="option in options" class="flex items-center mb-2">
        <input type="checkbox" :value="option.value" class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 rounded focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 focus:ring-2 dark:bg-gray-700 dark:border-gray-600">
        <label class="ml-2 mr-5 text-sm font-medium text-gray-900 dark:text-gray-300">{{option.label}}</label>
    </div>
</div>

</template>

<script>
import inputMixin from './input.js';
export default {
    name: "CheckboxInput",
    mixins:[inputMixin],
    props: {


    },
    data() {

    }
}
</script>