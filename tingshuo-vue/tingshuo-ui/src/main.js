import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import ElementUI from "element-ui";
import axios from 'axios';
import "element-ui/lib/theme-chalk/index.css";
import "font-awesome/css/font-awesome.min.css";

Vue.use(ElementUI);
Vue.config.productionTip = false;

Vue.prototype.$http=axios;
axios.defaults.headers.post['Content-Type']='application/json;charst=UTF-8';
//axios.defaults.headers['Content-Type'] = 'application/x-www-form-urlencoded';
axios.defaults.baseURL="http://127.0.0.1:9080/";

new Vue({
  router,
  render: (h) => h(App),
}).$mount("#app");
