<template>
  <div>
    <VendorNavBar />
    <router-view />
    <div class="col-md-6">
      <div class="card card-container">
        Vendor!!
      </div>
    </div>
  </div>
  </template>
  
  <script>
  import VendorNavBar from '../components/VendorNavBar.vue';

  export default {
    name: "Vendorhome",
    components: {
      VendorNavBar,
    },
   
  
  }
  
  </script>