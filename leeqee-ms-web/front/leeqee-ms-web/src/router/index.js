import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

import  IndexConfiguration from '../views/articles/IndexConfiguration.vue'
import  ArticleListPage from '../views/articles/ArticleListPage.vue'
import  Home from '../views/articles/Home.vue'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path:'/',
      component: Home,
      name: '',
      iconCls: 'fa fa-address-card',
      leaf: true,//只有一个节点
      children: [
        { path: '/IndexConfiguration', component: IndexConfiguration, name: '主页配置' },
      ]

    },
    {
      path:'/',
      component: Home,
      name: '',
      iconCls: 'fa fa-address-card',
      leaf: true,//只有一个节点
      children: [
        { path: '/ArticleListPage', component: ArticleListPage, name: '文章列表' }
      ]

    }
  ]
})
