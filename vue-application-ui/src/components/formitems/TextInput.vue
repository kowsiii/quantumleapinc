<template>
    <div>
        <label v-if="label.display" :for="id" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">{{ label.message }} <div style="color: red; display: inline;" v-if="required">*</div> </label>
        <input type="text" :id="id"
        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            :placeholder="placeholder.display?placeholder.message:''" :readonly="readonly" :required="required">
    </div>
    <div>
        <p v-if="description.display" class="mt-2 text-sm text-gray-500 dark:text-gray-400">{{ description.message }}</p>
    </div>
</template>

<script>
import inputMixin from './input.js';
export default {
    name: "TextInput",
    mixins:[inputMixin],
    props: {


    },
    data() {

    }
}
</script>