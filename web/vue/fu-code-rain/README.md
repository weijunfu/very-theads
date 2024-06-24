
# fu-code-rain
> 代码雨 - 黑客帝国特效

## Install 安装

```
npm install fu-code-rain
// or
yarn add fu-code-rain
// or
pnpm install fu-code-rain
```

## Use 使用

```
import CodeRain from 'fu-code-rain'
app.use(CodeRain)
```

## Example 示例
```html
<canvas ref="canvas"></canvas>
```

```
import { ref, onMounted, getCurrentInstance } from 'vue'

const app = getCurrentInstance()

const canvas = ref(null)

onMounted(() => {
  if(canvas.value) {
    const CodeRain = app.appContext.config.globalProperties.$CodeRain
    const codeRain = new CodeRain(canvas.value)
    codeRain.autoDraw(10)
  }
})
```
