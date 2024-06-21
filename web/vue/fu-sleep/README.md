
# Sleep 休眠
> 纯净VueJS休眠插件

## 1. Install 安装

```
npm install fu-sleep
// or
yarn add fu-sleep
// or 
pnpm install fu-sleep
```

## 2. Config 配置

```
import FuSleep from 'fu-sleep'
app.use(FuSleep)
```

## 3. Example 示例

```
import { getCurrentInstance } from 'vue'

const $sleep = getCurrentInstance()?.appContext.config.globalProperties.$sleep

const sleep = async () => {
  console.log('开始睡觉啦')
  await $sleep(3000)
  console.log('别吵，我醒了！')
}
```