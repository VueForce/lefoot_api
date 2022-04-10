import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/redefinir-senha',
      name: 'redefinir-senha',
      component: () => import('../views/RedefinirSenhaView.vue')
    },
    {
      path: '/tela-csv',
      name: 'tela-csv',
      component: () => import('../views/TelaCsvView.vue')
    }
  ]
})

export default router
