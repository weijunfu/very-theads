import { createRouter, createWebHistory, createMemoryHistory } from 'vue-router'
import HomeView from '../pages/HomeView.vue'

const isClient = typeof window !== 'undefined'

const router = createRouter({
  history: isClient
    ? createWebHistory(import.meta.env.BASE_URL)
    : createMemoryHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../pages/AboutView.vue')
    },
    {
      path: '/test',
      name: 'test',
      component: () => import('../pages/TestPage.vue')
    }
  ]
})

export default router
