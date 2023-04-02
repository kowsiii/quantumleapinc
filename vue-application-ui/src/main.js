import { createApp } from "vue";
import App from "./App.vue";
import ElementPlus from 'element-plus';
import router from "./router";
import store from "./store";
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import './index.css';
import { library } from '@fortawesome/fontawesome-svg-core'
import { fas } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import '@fortawesome/fontawesome-free/css/all.css'
import VueDatePicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css'

library.add(fas)

createApp(App)
  .use(router)
  .use(store)
  .use(ElementPlus)
  .component("font-awesome-icon", FontAwesomeIcon)
  .component('VueDatePicker', VueDatePicker)
  .mount("#app");
