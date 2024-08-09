# fu-numeral-incr

> [UI-VUE] 数字递增组件

## Install 安装

```shell
npm install fu-numeral-incr
// or
yarn add fu-numeral-incr
// or
pnpm install fu-numeral-incr
```

## Use 使用

```ts
import { createApp } from 'vue'
import App from './App.vue'

const app = createApp(App)

import FuNumeralIncr from 'fu-numeral-incr'
app.use(FuNumeralIncr)

app.mount('#app')
```

## Example 示例
```vue
<template>
    <div class="fu">
        <fu-numeral-incr :count="200" />
        <fu-numeral-incr :count="400" unit="$" />
    </div>
<template>
```