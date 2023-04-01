<template>
  <div id="form">
  <div v-for="sect in render">
    <div v-for="field in sect.fields">
      <div>

        <span style="color: red;" v-if="field.content.options.required">* </span>
        <label style="display: inline-block;" class="block mb-1 text-base font-medium text-gray-800 dark:text-white">{{
          field.content.options.label }} </label>

        {{ field.content.type+'Input' }}
        <component :is="field.content.type+'Input'" v-bind="field.content.options"/>
        <div>
          <p class="mt-2 text-sm text-gray-500 dark:text-gray-400">{{
            field.content.options.description }}</p>
        </div>
      </div>
    </div>
    <hr>
  </div>
</div>
</template>
  
<script>
import draggable from 'vuedraggable'
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

export default {
  components: {
    draggable,
    CheckboxInput,
    TextInput,
    RadioInput

  },
  data() {
    return {
      render: "",
      // list: [
      //   {
      //     id: 1,
      //     name: 'Parent 1',
      //     children: [
      //       { id: 2, name: 'Child 1' },
      //       { id: 3, name: 'Child 2' }
      //     ]
      //   },
      //   {
      //     id: 4,
      //     name: 'Parent 2',
      //     children: [
      //       { id: 5, name: 'Child 3' },
      //       { id: 6, name: 'Child 4' }
      //     ]
      //   }
      // ]
    }
  },

  mounted() {

    this.render = JSON.parse(this.$route.query.data);
    console.log(this.render);
    const html = document.querySelector('#form').outerHTML;
    console.log(html);
  }
}
</script>
  