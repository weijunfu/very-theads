# 智能养护工程监管平台 - 可视化项目

## 概述

### Vite
Vite 是一个前端构建工具，它具有快速构建、热重载、模块化、依赖预构建等特性。

由于其原生ES模块导入方法，它允许快速提供模块化开发，并支持 TypeScript。

在开发环境下基于浏览器原生ES imports开发，在生产环境下基于Rollup打包。

### 基于Vite构建项目

#### 1. 创建项目
```shell
npm init vite
```
根据提示输入项目名称，选择vue框架，再选择TypeScript。

#### 2. 安装依赖包
```shell
cd <project name>
pnpm install
```

#### 3. 运行vite项目
```shell
pnpm dev
```

#### 4. 访问项目
浏览器访问 http://localhost:5173

#### 5. Vite自定义端口号和启动后打开浏览器
修改项目根目录下的`vite.config.js`文件：
```js
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  server: {
    open: true, // open browser on start
    port: 3000, // 自定义端口号
  },
  plugins: [vue()],
})
```

#### 6. vue-router

##### 安装

````shell
pnpm add vue-router -S
````

##### 创建路由文件
```ts
// src/router/index.ts

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

```

##### 配置路由

```ts
// src/main.ts
import { createApp } from 'vue'
import '@/assets/style/global.scss'
import App from './App.vue'

import router from '@router/index'

const app = createApp(App)

app.use(router)

app.mount('#app')
```

#### 7. sass-embedded

```shell
pnpm add -D sass-embedded
```

## 大屏组件 -DataV - Vue3
https://datav-vue3.netlify.app/

### 安装
```shell
pnpm install @kjgl77/datav-vue3
```

### 全局引入
```ts
// main.ts中全局引入
import { createApp } from 'vue'
import DataVVue3 from '@kjgl77/datav-vue3'

const app = createApp(App)

app.use(DataVVue3)
app.mount('#app')
```

## 地图

### 1. 中国地理位置数据
https://www.isqqw.com/map/china.html


