<script setup>
import { ref } from "vue";

const basicFields = ref(['input', 'textarea', 'number', 'radio', 'checkbox', 'time', 'date', 'rate', 'color', 'select', 'switch', 'slider', 'text']);

const yuckyMeals = ref([
  'Bat wing soup',
  'Spicy Octopus',
  'Anything from Taco Bell',
]);
</script>

<template>
    <div class="split left">
        <h5 class="text-xl font-bold dark:text-white">Basic Components</h5>
   
<!--Notice the group prop is the same on both <draggable>-->
        <draggable v-model="basicFields" tag="ul" :group="{ name: 'fields', pull: 'clone', revertClone: true }" :animation="300">
    <template #item="{ element: meal }">
      <div class="formitem">{{ meal }}</div>
    </template>
</draggable>
    </div><br/>

    <div class="split right">
        <h1>Terrible Foods</h1>
        <ul class="max-w-md space-y-1 text-gray-500 list-disc list-inside dark:text-gray-400">
<draggable v-model="yuckyMeals" tag="ul" group="fields" :animation="300">
    
  <template #item="{ element: meal }">
    <li>{{ meal }}</li>
  </template>
</draggable>
</ul>
    </div>
 

</template>


<script>
import draggable from "vuedraggable";
export default {
    name: "TestView",
    data () {
        return {

        }}
}
</script>


<style scoped>

.split {
  height: 100%;
  position: fixed;
  top: 0;
}

/* Control the left side */
.left {
  left: 0;
  width: 30%;
  background-color: lightgray;
}

/* Control the right side */
.right {
  right: 0;
  width: 70%;

}

.formitem {
    background-color: aqua;
}


.drag-item {
  background: blue;
  margin: 10px 0;
}
</style>