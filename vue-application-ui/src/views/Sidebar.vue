<script setup>
function onDragStart(event, nodeType) {
  if (event.dataTransfer) {
    event.dataTransfer.setData('application/vueflow', nodeType)
    event.dataTransfer.effectAllowed = 'move'
  }
}
</script>

<template>
  <aside>
    <div class="description">You can drag these nodes to the pane.</div>

    <div class="nodes">
      <div class="vue-flow__node-input" :draggable="true" @dragstart="onDragStart($event, 'Form')">Form</div>

      <div class="vue-flow__node-default" :draggable="true" @dragstart="onDragStart($event, 'Approve')">Approve</div>

      <div class="vue-flow__node-output" :draggable="true" @dragstart="onDragStart($event, 'Generate PDF')">Generate PDF</div>
    </div>
  </aside>
</template>
