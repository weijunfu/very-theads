<script setup lang="ts">
import { ref } from 'vue'
import { Image } from 'fu-media-image5/types/Image'

import HelloWorld from './components/HelloWorld.vue'
import TheWelcome from './components/TheWelcome.vue'

import { ElLoading } from 'element-plus'

import { startLoading, endLoading} from 'fu-loading'
import MediaImage5 from "@/components/MediaImage5.vue";

const changeSize = (e) => {
  console.log(e)

  // const loading = ElLoading.service({
  //   lock: true,
  //   text: 'Loading',
  //   background: 'rgba(0, 0, 0, 0.7)',
  // })
  
  startLoading()
  startLoading()

  // FuLoading.startLoading()

  setTimeout(()=> {
    endLoading()
    
    setTimeout(()=> {
      endLoading()
    }, 3000)

  }, 3000)


}

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
  <header>
    <img alt="Vue logo" class="logo" src="./assets/logo.svg" width="125" height="125" />

    <div class="wrapper">
      <HelloWorld msg="You did it!" v-fu-size="changeSize" />

      <div class="image-wrapper">
        <media-image5 :images="images" />
<!--        <fu-media-image5 :images="images" />-->
      </div>
      <div class="image-wrapper">
          <fu-media-image5 :images="images" />
      </div>
    </div>
  </header>

  <main>
    <TheWelcome />
  </main>
</template>

<style scoped lang="scss">
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;

    .image-wrapper {
      width: 500px;
      min-height: 500px;
      height: auto;
    }
  }
}
</style>
