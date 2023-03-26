<template>
    <div>
    <NavBar :is-vendor="false"/>
    <router-view />
    <div class="col-md-6">
      <div class="card card-container">
        Admin!!
        <button v-on:click="logOut">Logout</button>
        <button v-on:click="registerUser">Register New User</button>
      </div>
    </div>
  </div>
</template>

<style>
.input-container {
  position: relative;
}

.input-container label {
  position: absolute;
  top: 50%;
  left: 0;
  transform: translateY(-50%);
  color: #888;
  pointer-events: none;
  transition: all 0.2s ease;
}

.input-container input:focus + label,
.input-container input:not(:placeholder-shown) + label {
  top: 10px;
  font-size: 12px;
  color: #555;
}

</style>

  
  <script>
  import NavBar from '../components/NavBar.vue';

  export default {
    name: "AdminHome",
    components:{
      NavBar
    }
  };
  
  
  </script>