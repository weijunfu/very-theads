import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Home',
      component: () => import('@/views/index.vue')
    },
    {
      path: '/button',
      name: 'Button',
      component: () => import('@/components/button/ButtonIntro/index.vue')
    },
    {
      path: '/messages',
      name: 'Messages',
      children: [
        {
          path: '/messages/toast',
          name: 'Toast',
          component: () => import('@/components/messages/MyToast/index.vue')
        }
      ]
    }
  ]
})

export default router
