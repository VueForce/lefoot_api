import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // {
    //   path: '/',
    //   name: 'home',
    //   component: HomeView
    // },
    // {
    //   path: '/about',
    //   name: 'about',
    //   component: () => import('../views/AboutView.vue')
    // },
    // {
    //   path: '/redefinir',
    //   name: 'Redefinir',
    //   component: () => import('../views/RedefinirSenhaView.vue')
    // },
    // {
    //   path: '/',
    //   name: 'Csv',
    //   component: () => import('../views/TelaCsvView.vue')
    // },
    {
      path: '/new/account',
      name: 'Conta',
      component: () => import('../views/CriarContaView.vue')
    },
    {
      path: '/login',
      name: 'Login',
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
