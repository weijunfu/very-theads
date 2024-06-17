# Vue 插件开发
> 定义显示一个Button的插件

## 1. 定义组件

```
// components/Button/index.vue
<template>
    <button>保存</button>
</template>
```

## 2. 定义插件
```
// plugin/Button.js
import MyButton from '../components/Button/index.vue'

export default {
    install: (app, options) => {
        app.component('MyButton', MyButton)
    }
}
```

## 3. 注册插件
```
import Button from './plugin/Button'
app.use(Button)
```

## 4. 使用组件
```
//views/AboutView.vue
<MyButton></MyButton>
```
