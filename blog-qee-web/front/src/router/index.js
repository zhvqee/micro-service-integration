import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main'
import About from '@/components/About'
import Detail from '@/components/Detail'
import Error from '@/components/Error'


Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main
    }, {
      path: '/about',
      name: 'About',
      component: About
    }, {
      path: '/detail',
      name: 'Detail',
      component: Detail
    }, {
      path: '/error',
      name: 'Error',
      component: Error
    }
  ]
})
