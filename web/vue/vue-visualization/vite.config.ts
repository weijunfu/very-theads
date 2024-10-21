import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

import path from 'path'

// https://vitejs.dev/config/
export default defineConfig({
  server: {
    open: false, // open browser on start
    port: 3000, // 自定义端口号
  },
  resolve: {
    alias: {
      '@': path.resolve(__dirname, './src'),
      '@asserts': path.resolve(__dirname, './src/assets'),
      '@components': path.resolve(__dirname, './src/components'),
      '@views': path.resolve(__dirname, './src/views'),
      '@router': path.resolve(__dirname, './src/router'),
    },
  },
  plugins: [vue()],
})
