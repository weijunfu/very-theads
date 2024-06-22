
# fu-clipboard

> [Vue Plugin]
> 快速复制内容到粘贴板 Quickly copy content to clipboard

# Install 安装

```
npm install fu-clipboard
// or
yarn add fu-clipboard
// or
pnpm install fu-clipboard
```

## Use 使用

```
import FuClipboard from 'fu-clipboard'
app.use(FuClipboard)
```

## Example 示例

```
import { getCurrentInstance } from 'vue'

const app = getCurrentInstance()

const $clipboard = app.appContext.config.globalProperties.$clipboard
await $clipboard(url)

```