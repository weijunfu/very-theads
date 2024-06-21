
# fu-icon
> vue3 自定义插件

## 安装

```
npm i fu-icon
// or
yarn add fu-icon
// or
pnpm i fu-icon
```

## 配置
```
// main.ts
// 注册SVG
import 'virtual:svg-icons-register'

// 自定义Icon插件
import FuIcon from 'fu-icon'
app.use(FuIcon)
```

## vite 配置
```
//vite.config.ts
import { createSvgIconsPlugin } from 'vite-plugin-svg-icons'

import path from 'path';

export default defineConfig({
    plugins: [
        createSvgIconsPlugin({
            iconDirs: [path.resolve(process.cwd(), 'src/assets/icons/svg')],    // 需替换svg路径
            symbolId: 'icon-[name]' // 注意这里的“icon-”
        })
    ]
})

```

## 使用
```
<FuIcon icon-class="icon-weekly"></FuIcon>    // "icon-"与上述vite配置的前缀要保持一致；“weekly”为svg文件名称
```
