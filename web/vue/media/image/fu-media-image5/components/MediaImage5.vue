<template>
  <div class="app">
    <div class="item" v-for="item in images" :key="item.id">
      <img :src="item.src" :alt="item.alt+'@ijunfu'" >
    </div>
  </div>
</template>
<script setup lang="ts">
import { Image } from '@/types/Image'
defineProps<{
  images: Image[]
}>()
</script>
<style scoped lang="scss">
.app {
  margin: 10vw auto;
  width: 20vw;
  height: 20vw;
  display: grid;
  grid-template-rows: repeat(3, 1fr);
  grid-template-columns: repeat(3, 1fr);
  grid-template:
        'A A B'
        'C D B'
        'C E E';
  gap: 1vw;
  animation: ani 10s infinite linear;
}

.app .item {
  display: flex;
  justify-content: center;
  align-items: center;
  overflow: hidden;
  border: min(.1vw, .1vh) solid #222;
}

.app .item:nth-child(1) {
  grid-area: A;
}
.app .item:nth-child(2) {
  grid-area: B;
}
.app .item:nth-child(3) {
  grid-area: C;
}
.app .item:nth-child(4) {
  grid-area: D;
}
.app .item:nth-child(5) {
  grid-area: E;
}

.app .item img {
  width: 260%;
  height: 260%;
  object-fit: cover;
  animation: ani 10s infinite linear reverse;
}


@keyframes ani {
  to {
    transform: rotate(360deg);
  }
}
</style>