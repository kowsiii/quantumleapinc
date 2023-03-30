<template>
    <div>
        <h5 class="text-xl font-bold dark:text-white mb-4">Field Configuration</h5>

        <!-- Name -->
        <div>
            <label style="display: inline-block;" for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"> Field Name: </label>
        <input type="text" id="name"
        class="block w-full p-2 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 sm:text-xs focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            v-model="field.content.options.name" required>
            <p class="mt-1 text-xs text-gray-500 dark:text-gray-400">&nbsp;* Must be unique</p>
        </div><br/>

        <!-- Required -->
        <label class="relative inline-flex items-center cursor-pointer mb-3">
            <input type="checkbox" value="" class="sr-only peer" @click="changeRequired"
                :checked="field.content.options.required">
            <div
                class="w-11 h-6 bg-gray-200 peer-focus:outline-none peer-focus:ring-4 peer-focus:ring-blue-300 dark:peer-focus:ring-blue-800 rounded-full peer dark:bg-gray-700 peer-checked:after:translate-x-full peer-checked:after:border-white after:content-[''] after:absolute after:top-[2px] after:left-[2px] after:bg-white after:border-gray-300 after:border after:rounded-full after:h-5 after:w-5 after:transition-all dark:border-gray-600 peer-checked:bg-blue-600">
            </div>
            <span class="ml-3 text-sm font-medium text-gray-900 dark:text-gray-300">Required</span>
        </label><br/>

        <!-- Label -->
        <div>
            <label style="display: inline-block;" for="label" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"> Label: </label>
        <input type="text" id="label"
        class="block w-full p-2 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 sm:text-xs focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            v-model="field.content.options.label" placeholder="Label">
        </div><br/>
        
        <!-- Placeholder -->
        <div>
            <label style="display: inline-block;" for="placeholder" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"> Placeholder: </label>
            <input type="text" id="placeholder"
        class="block w-full p-2 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 sm:text-xs focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            v-model="field.content.options.placeholder" placeholder="Placeholder">
  
    </div><br/>

    <!-- Description -->
    <div>
            <label style="display: inline-block;" for="description" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"> Description: </label>
            <input type="text" id="description"
        class="block w-full p-2 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 sm:text-xs focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            v-model="field.content.options.description" placeholder="Description">
  
    </div><br/>
<hr>
        
    <!-- {{ newField.content.options }} -->
    </div>
</template>


<script>

export default {
    name: "FormFieldOptionsModal",

    props: {
        field: { type: Object }
    },
    computed : {
        newField() {
            return this.field;
        }
    },
    data() {
        return {
    

        }

    },
    methods: {
        changeRequired() {
            if (this.newField.content.options.required === false) {
                this.newField.content.options.required = true;
            } else {
                this.newField.content.options.required = false
            }
        },
        
    },
    // watch: {
    //     // Watch for changes to any data property
    //     $data: {
    //         deep: true,
    //         handler() {
    //             // Emit a custom event
    //             console.log("change");
    //             this.$emit('update', this.newField);
    //         }
    //     }
    // }
}
</script>