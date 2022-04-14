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
    },
    {
      path: '/criar-conta',
      name: 'criar-conta',
      component: () => import('../views/CriarContaView.vue')
    },
    {
      path: '/tela-login',
      name: 'tela-login',
      component: () => import('../views/TelaLoginView.vue')
    },
    {
      path: '/filtrar-clientes',
      name: 'filtrar-clientes',
      component: () => import('../views/FiltrarClientesView.vue')
    },
  ]
})

export default router
