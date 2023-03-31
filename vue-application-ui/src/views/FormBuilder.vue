<script setup>
//import { ref } from "vue";
import { basicComponents } from "../components/formitems/componentsConfig";

</script>

<template>
    <div class="parent">
        <div class="split left">
            <div class="tab-container">
                <div class="tab-links">
                    <button class="tab-link" @click="activeTab = 'tab1'" :class="{ 'active': activeTab === 'tab1' }">
                        Elements</button>
                    <button class="tab-link" @click="activeTab = 'tab2'" :class="{ 'active': activeTab === 'tab2' }">
                        Tree</button>

                </div>
                <div class="tab-content">
                    <div v-show="activeTab === 'tab1'" style="padding:10px;text-align:center;padding-top:0px;">

                        <div class="inline-flex rounded-md p-2" role="group">
                            <button type="button" @click="activeSect = 'fields'"
                                class="px-3 py-1 text-xs font-medium text-gray-900 bg-white border border-gray-200 rounded-l-lg hover:bg-gray-100 hover:text-blue-700  focus:ring-blue-700 focus:text-blue-700 dark:bg-gray-700 dark:border-gray-600 dark:text-white dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-blue-500 dark:focus:text-white">
                                Fields
                            </button>
                            <button type="button" @click="activeSect = 'static'"
                                class="px-3 py-1 text-xs font-medium text-gray-900 bg-white border-t border-b border-gray-200 hover:bg-gray-100 hover:text-blue-700 focus:ring-blue-700 focus:text-blue-700 dark:bg-gray-700 dark:border-gray-600 dark:text-white dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-blue-500 dark:focus:text-white">
                                Static
                            </button>
                            <button type="button" @click="activeSect = 'structure'"
                                class="px-3 py-1 text-xs font-medium text-gray-900 bg-white border border-gray-200 rounded-r-md hover:bg-gray-100 hover:text-blue-700 focus:ring-blue-700 focus:text-blue-700 dark:bg-gray-700 dark:border-gray-600 dark:text-white dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-blue-500 dark:focus:text-white">
                                Structure
                            </button>
                        </div>

                        <div v-show="activeSect === 'fields'" style="text-align:left;">
                            <h6 class="text-lg font-semibold dark:text-white" style="padding:0px 10px;" @click="print">Basic
                                Components</h6>

                            <draggable :list="basicComponents" tag="div" :clone="cloneInput"
                                v-bind="{ group: { name: 'fields', pull: 'clone', revertClone: true, put: false }, sort: false, animation: '300', ghostClass: 'dragging-ghost' }">
                                <template #item="{ element: field }">
                                    <div>
                                        <div
                                            class="text-gray-900 border border-gray-300 focus:outline-none hover:bg-gray-100 focus:ring-4 focus:ring-gray-200 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-gray-800 dark:text-white dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 dark:focus:ring-gray-700">
                                            {{ field.type }}</div>
                                    </div>
                                </template>
                            </draggable>
                        </div>
                        <div v-show="activeSect === 'static'">
                            Static
                        </div>
                        <div v-show="activeSect === 'structure'">
                            Structure
                        </div>

                    </div>
                    <div v-show="activeTab === 'tab2'" @click="print">Tab 2 content goes here.{{ selectedFields }}</div>

                </div>
            </div>

        </div>

        <div class="split centre">
            <div style="text-align:right; padding:15px 15px 0px 0px">
                <button type="button" @click="renderForm" class="focus:outline-none text-sm font-medium text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:ring-green-300 rounded-lg text-sm px-3 py-2 mr-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800">Render</button>

            <button type="button" @click="saveForm" class="focus:outline-none text-sm font-medium text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:ring-green-300 rounded-lg text-sm px-3 py-2 mr-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800">Save</button>
        </div>
       <div style="display:flex;align-items: center;"> <step-input :rep="steps" :selected="selectedpage" @changepage="changePage" style="display: inline-block;width:85%"/><button style="display: inline-block;" @click="addPage" type="button" class="px-3 py-2 text-xs font-3xl text-center text-white bg-blue-700 rounded-lg hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">+</button>
       </div>
            <div class="border-dashed border-2 border-600 min-h-[50%] m-5 p-5 hover:bg-gray-100" style="background-color: white;">
                
                <div v-for="(step, i) in selectedFields">
                    <div v-if="selectedpage===i">
                    <div v-if="step.fields.length === 0">Drag here!</div>
                    <draggable v-model="step.fields" tag="div" group="fields" :animation="300">

                        <template #item="{ element: field }">
                            <div class="drag-item" @click="selectedfield = field">
                                <span style="color: red;" v-if="field.content.options.required">* </span>
                                <label style="display: inline-block;"
                                    class="block mb-1 text-base font-medium text-gray-800 dark:text-white">{{
                                        field.content.options.label }} </label>
                                <component :is="field.content.type+'Input'" v-bind="field.content.options"/>

                                
                                <div>
                                    <p class="mt-2 text-sm text-gray-500 dark:text-gray-400">{{
                                        field.content.options.description }}</p>
                                </div>
                            </div>
                        </template>
                    </draggable>
                </div>
                </div>
            </div>
        </div>

        <div class="split right" style="padding:10px 20px;">
            <FormFieldOptionsModal :field="selectedfield" v-if="selectedfield" />
        </div>
    </div>
</template>


<script>
import draggable from "vuedraggable";
import UserService from "../services/user.service";
import TextInput from "../components/formitems/TextInput.vue";
import TextareaInput from "../components/formitems/TextareaInput.vue";
import FormFieldOptionsModal from "../components/formitems/FormFieldOptionsModal.vue";
import EmailInput from "../components/formitems/EmailInput.vue";
import StepInput from "../components/formitems/StepInput.vue";
import RadioInput from "../components/formitems/RadioInput.vue";
import CheckboxInput from "../components/formitems/CheckboxInput.vue";
import SelectInput from "../components/formitems/SelectInput.vue";
import ToggleInput from "../components/formitems/ToggleInput.vue";
import DateInput from "../components/formitems/DateInput.vue";
import FileUploadInput from "../components/formitems/FileUploadInput.vue";
import { Field } from "vee-validate";


export default {
    name: "FormBuilder",
    components: { FormFieldOptionsModal, SelectInput, RadioInput },
    data() {
        return {
            activeTab: "tab1",
            activeSect: "fields",
            steps: 0,
            selectedFields: [{ fields: [] }], //must be called dynamically
            selectedfield: null,
            counter: 0,
            selectedpage: 0,

        };
    },
    computed: {
        formconfig() {
            return this.selectedFields;
        }
    }
    ,

    methods: {
        cloneInput(x) {
            return {
                id: ++this.counter,
                content: JSON.parse(JSON.stringify(x)),
            }
        },
        //     replacebyID(obj) {
        //         console.log("rep");
        //         var index = this.selectedFields.findIndex(item => item.id === obj.id);
        //         if (index !== -1) {
        //             this.selectedFields.splice(index, 1, obj);
        //             console.log(this.selectedFields[index].content.options.required);
        //   }

        //     },
        findbyID(id) {
            return this.selectedFields.find(item => item.id === id);
        },
        print() {
            console.log(this.selectedFields)
        },
        saveForm() {
            UserService.saveForm(1,{formDesign:JSON.stringify(this.selectedFields), title:"testForm"}).then(
      (response) => {
        console.log(response.data)
      },
      (error) => {
        this.error =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message || error.message.toString();
          console.log(this.error);

      }
    );
        },
        addPage() {
            this.steps+=1
            this.selectedFields.push({ fields: [] })
            this.changePage(this.steps+1)
        },
        changePage(page) {
            this.selectedpage=page-1;
            console.log(this.selectedpage)
        },
        renderForm() {
            this.$router.push({
  path: '/test',
  query: {
    data: JSON.stringify(this.selectedFields)
  }
});
        }

    },
    mounted() {
        
    },

}
</script>


<style scoped>
.split {
    overflow-y: scroll;
}

/* Control the left side */
.left {
    width: 20%;
}

/* Control the right side */
.right {
    width: 20%;
}

.centre {
    width: 60%;
    background-color: #f1f1f1;
}

.parent {
    display: flex;

    position:absolute;
top:50px;
right:0px;
bottom:0px;
left:0px;
}

.tab-links {
    display: flex;

    margin-bottom: 10px;
}

.tab-link {
    padding: 10px;
    cursor: pointer;
    background-color: #f1f1f1;
    flex: 1;

}

.tab-link.active {
    background-color: #fff;
    border-bottom: none;
}

.tab-content .tab-pane {
    display: none;
    padding: 0px;
}

.tab-content .tab-pane.active {
    display: block;
}



.dragging-ghost {
    opacity: 0.1;
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
}

.formitem {
    background-color: aqua;
}



.drag-item {
    margin: 10px 0;
}

.drag-item:focus-within {
    margin: 10px 0;
    border-style: solid;
    border-width: 3px;
    border-color: rgb(173, 194, 230);
}</style>