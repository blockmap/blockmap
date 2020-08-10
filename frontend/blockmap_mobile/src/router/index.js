import Vue from 'vue'
import Router from 'vue-router'
import home from '@/components/home/home' // 导入地图主页
import summary from '@/components/summary/summary' // 导入当日风险等级总结页
import login from '@/components/login/login' // 导入登录页
import report from '@/components/report/report' // 导入上报页
import information from '@/components/information/information' // 导入个人信息页
import did from '@/components/did/did' // 导入数字身份页
import about from '@/components/about/about' // 导入关于我们页
import goodmap from '@/components/goodmap/goodmap' // 导入3D地图页
import register from '@/components/register/register' // 导入注册填写信息页
import normalmap from '@/components/normalmap/normalmap' // 导入普通地图动画页
import judge from '@/components/judge' // 导入判断页

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'judge',
      component: judge
    },
    {
      path: '/goodmap',
      name: 'goodmap',
      component: goodmap
    },
    {
      path: '/normalmap',
      name: 'normalmap',
      component: normalmap
    },
    {
      path: '/home',
      name: 'home',
      component: home
    },
    {
      path: '/summary',
      name: 'mysummary',
      component: summary
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/report',
      name: 'report',
      component: report
    },
    {
      path: '/information',
      name: 'information',
      component: information
    },
    {
      path: '/did',
      name: 'did',
      component: did
    },
    {
      path: '/about',
      name: 'about',
      component: about
    },
    {
      path: '/register',
      name: 'register',
      component: register
    }
  ]
})
