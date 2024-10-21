
import { createRouter, createWebHashHistory } from 'vue-router';

/**
 * 路由配置
 */
const routes = [
    {
        path: '/',  // 请求路径
        name: 'home',   // 路由名称
        component: () => import('../view/index.vue')
    }
]

/**
 * 路由实例
 */
const router = createRouter({
    history: createWebHashHistory(),
    routes
})

/**
 * 导出路由实例
 */
export default router;