
# fu-loading

> 基于ElementPlus自定义封装全局Loading插件

## Install 安装
```shell
npm install fu-loading
// or
yarn add fu-loading
// or
pnpm install fu-loading
```

## Use 使用
```
import { startLoading, endLoading } from 'fu-loading'
```

## Example 示例

```js
startLoading()
startLoading()

setTimeout(()=> {
    endLoading()

    setTimeout(()=> {
        endLoading()
    }, 3000)

}, 3000)
```
