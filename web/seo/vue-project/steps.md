## 安装quasar

```shell
pnpm install quasar @quasar/app-vite @quasar/extras @quasar/vite-plugin
```

## 配置vite插件

```ts
// vite.config.ts
import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import VueDevTools from 'vite-plugin-vue-devtools'
import { quasar, transformAssetUrls } from '@quasar/vite-plugin'

export default defineConfig({
  plugins: [
    vue({
      template: { transformAssetUrls }
    }),
    quasar(),
    VueDevTools()
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  }
})
```

## 注册Quasar

```main.ts
import { Quasar, QBtn, Meta } from 'quasar'
import '@quasar/extras/material-icons/material-icons.css'
import 'quasar/dist/quasar.css'
app.use(Quasar, {
  components: {
    QBtn
  },
  plugins: {
    Meta
  }
})

```

## ssr

```
quasar mode add ssr
```
