import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path :'/loginhome',
    name : 'loginhome',
    component: () => import('../views/LoginHomeView.vue'),
    children :[
      {
        path : '/vatdeclarationinformation',
        name : 'vatdeclarationinformation',
        component:  () => import('../views/VATDeclarationInformationView.vue'),
        meta: {
          requireAuth: true
        }
      },
      {
        path : '/eprdeclarationinformation',
        name : 'eprdeclarationinformation',
        component : () => import('../views/EPRDeclarationInformationView.vue')

      },
      {
        path : '/vatrefund',
        name : 'vatrefund',
        component : () => import('../views/VATRefundView.vue')
      },
      {
        path : '/workorder',
        name : 'workorder',
        component : () => import('../views/WorkOrderView.vue')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
