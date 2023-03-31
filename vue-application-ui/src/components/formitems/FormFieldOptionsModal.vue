<template>
    <div>
        <h5 class="text-xl font-bold text-gray-900 dark:text-white mb-4">Field Configuration</h5>
        <div>
        <p class="text-sm text-gray-400 dark:text-white mb-2">PROPERTIES</p>
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
        <div v-if="hasPlaceholder.includes(field.content.type)">
            <label style="display: inline-block;" for="placeholder" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"> Placeholder: </label>
            <input type="text" id="placeholder"
        class="block w-full p-2 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 sm:text-xs focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            v-model="field.content.options.placeholder" placeholder="Placeholder">
            <br/>
    </div>

    <!-- Description -->
    <div v-if="field.content.type!='FileUpload'">
            <label style="display: inline-block;" for="description" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"> Description: </label>
            <input type="text" id="description"
        class="block w-full p-2 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 sm:text-xs focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            v-model="field.content.options.description" placeholder="Description">
  
    </div>
    <div v-else>
        <label style="display: inline-block;" for="description" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"> Description: </label>
            <input type="text" id="description"
        class="block w-full p-2 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 sm:text-xs focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            v-model="field.content.options.descriptionf" placeholder="Description">
    </div>
    
    <br/>
</div>
<hr>
        
    <!-- {{ newField.content.options }} -->
    </div>


    <div v-if="hasOptions.includes(field.content.type)">
        <p class="text-sm text-gray-400 dark:text-white mt-4 mb-2">OPTIONS</p>

        <label class="relative inline-flex items-center cursor-pointer mb-3 mt-2">
            <input type="checkbox" value="" class="sr-only peer" @click="changeInline"
                :checked="field.content.options.inline">
            <div
                class="w-11 h-6 bg-gray-200 peer-focus:outline-none peer-focus:ring-4 peer-focus:ring-blue-300 dark:peer-focus:ring-blue-800 rounded-full peer dark:bg-gray-700 peer-checked:after:translate-x-full peer-checked:after:border-white after:content-[''] after:absolute after:top-[2px] after:left-[2px] after:bg-white after:border-gray-300 after:border after:rounded-full after:h-5 after:w-5 after:transition-all dark:border-gray-600 peer-checked:bg-blue-600">
            </div>
            <span class="ml-3 text-sm font-medium text-gray-900 dark:text-gray-300">Inline</span>
        </label><br/>

        <div v-for="(option, index) in field.content.options.options" :key="index">
            <div class="relative z-0 w-full mb-1 group">
      <input style="width:35%;display:inline" type="text" class="block py-2 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
      v-model="option.label" required placeholder="Label"/>&nbsp;→&nbsp;

      <input style="width:35%;display:inline" type="text" class="block py-2 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer"
      v-model="option.value" required placeholder="Value"/>

      <button type="button" @click="deleteOption(index)" class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-2 py-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900">
  <svg fill="none" stroke="currentColor" stroke-width="2.5" aria-hidden="true" class="w-3 h-3" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" d="M14.74 9l-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 01-2.244 2.077H8.084a2.25 2.25 0 01-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 00-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 013.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 00-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 00-7.5 0"></path></svg>
 
</button>
  </div>
        </div>
        <button @click="addOption" type="button" class="px-2.5 py-1 text-sm font-medium text-center text-white bg-blue-700 rounded-lg hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">+</button>
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
            hasPlaceholder: ['Text', 'Textarea', 'Number'],
            hasOptions: ['Radio', 'Checkbox', 'Select'],

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
        changeInline() {
            if (this.newField.content.options.inline === false) {
                this.newField.content.options.inline = true;
            } else {
                this.newField.content.options.inline = false
            }
        },
        addOption() {
            this.newField.content.options.options.push({label:'', value:''})
        },
        deleteOption(index) {
            this.newField.content.options.options.splice(index, 1)
        }

        
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