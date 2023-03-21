import { createApp } from "vue";
import App from "./App.vue";
import ElementPlus from 'element-plus';
import router from "./router";
import store from "./store";
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
//import { FontAwesomeIcon } from './plugins/font-awesome'
// add this
import './index.css'

createApp(App)
  .use(router)
  .use(store)
  .use(ElementPlus)
  //.component("font-awesome-icon", FontAwesomeIcon)
  .mount("#app");
