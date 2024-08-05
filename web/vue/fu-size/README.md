
# fu-size

> 自定义封装resize指令

## Install 安装

```shell
npm install fu-size
// or
yarn add fu-size
// or
pnpm install fu-size
```

## Use 使用

```typescript
// main.ts
import FuSize from 'fu-size'
app.directive('fu-size', FuSize)
```

## Example 示例
```vue
<template>
    <HelloWorld msg="You did it!" v-fu-size="changeSize" />
</template>

<script setup lang="ts">
const changeSize = (e) => {
  console.log(e)    // { width: 893, height: 97.1875 }
}
</script>
```
