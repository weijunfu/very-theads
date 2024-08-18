import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import VueDevTools from 'vite-plugin-vue-devtools'

import { quasar, transformAssetUrls } from '@quasar/vite-plugin'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue({
      template: { transformAssetUrls } // 允许Quasar自动处理Vue模板中的静态资源
    }),
    quasar(),
    VueDevTools()
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
      '~': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: {
    proxy: {
      '/api': {
        target: 'http://t.weather.sojson.com', // 你的后端 API 地址
        changeOrigin: true, // 使代理的域名与目标域名相同
        rewrite: (path) => path.replace(/^\/api/, '/api/') // 可选：将 /api 重写为空字符串
      }
    }
  }
})
