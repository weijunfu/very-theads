
# [Vue UI] 旋转图册 - fu-media-image5

## Install 安装

```shell
npm install fu-media-image5
// or
yarn add fu-media-image5
// or 
pnpm install fu-media-image5
```

## Use 使用 
```ts
// main.ts / main.js
import FuMediaImage5 from 'fu-media-image5';
app.use(FuMediaImage5);
```
```vue
<script setup lang="ts">
import { Image } from 'fu-media-image5/types/Image'

const images = ref<Image[]>([
{
id: '1', src: 'https://picsum.photos/300/200?t=1', alt: '随机图片'
}, {
id: '2', src: 'https://picsum.photos/300/200?t=2', alt: '随机图片'
},{
id: '3', src: 'https://picsum.photos/300/200?t=3', alt: '随机图片'
},{
id: '4', src: 'https://picsum.photos/300/200?t=4', alt: '随机图片'
},{
id: '5', src: 'https://picsum.photos/300/200?t=5', alt: '随机图片'
}
])
</script>
<template>
  <div class="image-wrapper">
    <fu-media-image5 :images="images" />
  </div>
</template>
<style>
  .image-wrapper {
    width: 500px;
    min-height: 500px;
    height: auto;
  }
</style>
```

## show 展示
![效果展示](./resources/example.gif)