// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// import 'vue-ydui/dist/ydui.flexible' // 适配手机屏幕，使用rem方案（若出现错误可采用最简单的方式实现）
import './method/flexible' // 改写的适配方案
import YDUI from 'vue-ydui' // 导入vue-ydui库
import 'vue-ydui/dist/ydui.rem.css' // 使用vue-ydui库必须引入，且选用适配为rem的组件
import VueCesium from 'vue-cesium' // 导入vue-cesium库
import {i18n} from './lang/i18n' // 导入i18n国际化对象

Vue.config.productionTip = false
Vue.use(YDUI) // 全局引用vue-ydui库
Vue.use(VueCesium, { // 全局引用vue-cesium库
  cesiumPath: '/static/Cesium/Cesium.js' // 库函数（可到官网下载，这里路径是项目的static文件夹，必须放在这里）
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  i18n,
  components: { App },
  template: '<App/>'
})
