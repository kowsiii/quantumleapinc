import { createApp } from "vue";
import App from "./App.vue";
import ElementPlus from 'element-plus';
import router from "./router";
import store from "./store";
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import './index.css'

//import { library } from '@fortawesome/fontawesome-svg-core';
//import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

//import { FontAwesomeIcon } from './plugins/font-awesome'
// add this


createApp(App)
  .use(router)
  .use(store)
  .use(ElementPlus)
  //.component("font-awesome-icon", FontAwesomeIcon)
  .mount("#app");
