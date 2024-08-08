
# fu-button-flowing

> 流光按钮

## Install 安装

```shell
npm install fu-button-flowing
// or
yarn add fu-button-flowing
// or
pnpm install fu-button-flowing
```

## Use 使用

``` ts
import FuButtonFlowing from 'fu-button-flowing'
app.use(FuButtonFlowing)
```

# Example 示例

![示例](./imgs/example.gif)

```vue
<script setup lang="ts">

import { ref } from 'vue'

const author = ref('ijunfu')

</script>

<template>
  <div class="greetings">
    <fu-button-flowing :text="author" />
  </div>
</template>
```
