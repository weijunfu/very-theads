
# Vue3 + Vant

## 一、介绍

### 1.1 Vue
> Vue (发音为 /vjuː/，类似 view) 是一款用于构建用户界面的 JavaScript 框架。它基于标准 HTML、CSS 和 JavaScript 构建，并提供了一套声明式的、组件化的编程模型，帮助你高效地开发用户界面。无论是简单还是复杂的界面，Vue 都可以胜任。

[Vue](https://cn.vuejs.org/guide/introduction.html)

#### 特性

+ 易学已用：基于标准的HTML、CSS和JavaScript构建，提供容易上手的API和一流的文档
+ 性能出色：经过编译器优化、完全响应式的渲染系统，几乎不需要手动优化
+ 灵活多变：丰富的、可渐进式集成的生态系统，可以根据应用规模在库和框架之间切换自如

### 1.2 Vant

> 轻量、可靠的移动端Vue组件库

[Vant](https://vant-ui.github.io/vant/#/zh-CN/quickstart)

#### 特性

+ 🚀 性能极佳，组件平均体积小于 1KB（min+gzip）
+ 🚀 80+ 个高质量组件，覆盖移动端主流场景
+ 🚀 零外部依赖，不依赖三方 npm 包
+ 💪 使用 TypeScript 编写，提供完整的类型定义
+ 💪 单元测试覆盖率超过 90%，提供稳定性保障
+ 📖 提供丰富的中英文文档和组件示例
+ 📖 提供 Sketch 和 Axure 设计资源
+ 🍭 支持 Vue 2、Vue 3 和微信小程序
+ 🍭 支持 Nuxt 2、Nuxt 3，提供 Nuxt 的 Vant Module
+ 🍭 支持主题定制，内置 700+ 个主题变量
+ 🍭 支持按需引入和 Tree Shaking
+ 🍭 支持无障碍访问（持续改进中）
+ 🍭 支持深色模式
+ 🍭 支持服务器端渲染
+ 🌍 支持国际化，内置 30+ 种语言包

## 二、搭建环境

### 2.1 创建项目

```
npm create vite
```

```
Need to install the following packages:
create-vite@5.2.3
Ok to proceed? (y) y


> npx
> create-vite

√ Project name: ... vant-app
√ Select a framework: » Vue
√ Select a variant: » TypeScript

Scaffolding project in E:\study\very-threads\web\vue\vue3-vant\vant-app...

Done. Now run:

  cd vant-app
  npm install
  npm run dev
```

### 2.2 安装Vant

```
npm i vant
```

```
yarn add vant
```

```
pnpm add vant
```

```
bun add vant
```


### 2.3 按需引入

#### 安装插件
```
# 通过 npm 安装
npm i @vant/auto-import-resolver unplugin-vue-components unplugin-auto-import -D

# 通过 yarn 安装
yarn add @vant/auto-import-resolver unplugin-vue-components unplugin-auto-import -D

# 通过 pnpm 安装
pnpm add @vant/auto-import-resolver unplugin-vue-components unplugin-auto-import -D

# 通过 bun 安装
bun add @vant/auto-import-resolver unplugin-vue-components unplugin-auto-import -D

```

#### 配置插件

```
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

import AutoImport from 'unplugin-auto-import/vite';
import Components from 'unplugin-vue-components/vite';
import { VantResolver } from '@vant/auto-import-resolver';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    AutoImport({
      resolvers: [ VantResolver() ]
    }),
    Components({
      resolvers: [ VantResolver() ]
    })
  ],
})

```
