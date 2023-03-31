<template>
    <div>
      <h2>Nested Draggable List</h2>
      <draggable v-model="list" :options="{group:{name:'people', pull:'clone'},animation: 200, handle: '.drag-handle', nested: true}">
        <div v-for="(item, index) in list" :key="item.id">
          <div class="drag-handle">Drag Handle</div>
          <div>{{item.name}}</div>
          <draggable v-model="item.children" :options="{group:{name:'people', pull:'clone'},animation: 200, handle: '.drag-handle', nested: true}">
            <div v-for="(child, childIndex) in item.children" :key="child.id">
              <div class="drag-handle">Drag Handle</div>
              <div>{{child.name}}</div>
            </div>
          </draggable>
        </div>
      </draggable>
    </div>
  </template>
  
  <script>
  import draggable from 'vuedraggable'
  
  export default {
    components: {
      draggable
    },
    data() {
      return {
        list: [
          {
            id: 1,
            name: 'Parent 1',
            children: [
              { id: 2, name: 'Child 1' },
              { id: 3, name: 'Child 2' }
            ]
          },
          {
            id: 4,
            name: 'Parent 2',
            children: [
              { id: 5, name: 'Child 3' },
              { id: 6, name: 'Child 4' }
            ]
          }
        ]
      }
    }
  }
  </script>
  