
import { createRouter, createWebHashHistory } from 'vue-router'

// Step 1 创建路由规则
const routes = [
    {
        path: '/',
        name: 'Home',
        component: () => import("../views/index.vue")
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import("../views/login/index.vue")
    }
]
// Step 2 创建路由实例
const router = createRouter({
    history: createWebHashHistory(),
    routes
})

// Step 3 指定出口
export default router