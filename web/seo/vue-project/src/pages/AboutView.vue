<template>
  <div class="about">
    <h1>{{ cityRef + ' - ' + qualityRef }}</h1>
    <div>
      <q-btn color="white" text-color="black" label="Standard" />
      <q-btn color="primary" label="Primary" />
      <q-btn color="secondary" label="Secondary" />
      <q-btn color="amber" glossy label="Amber" />
      <q-btn color="brown-5" label="Brown 5" />
      <q-btn color="deep-orange" glossy label="Deep Orange" />
      <q-btn color="purple" label="Purple" />
      <q-btn color="black" label="Black" />
    </div>
    <div>
      <q-btn color="primary" icon="mail" label="On Left" />
      <q-btn color="secondary" icon-right="mail" label="On Right" />
      <q-btn color="red" icon="mail" icon-right="send" label="On Left and Right" />
      <q-btn icon="phone" label="Stacked" stack glossy color="purple" />
    </div>
  </div>
</template>

<script setup>
import { ref, getCurrentInstance } from 'vue'
import { usePageMeta, baseUrl } from '../utils/usePageMeta'

import { onMounted } from 'vue'

const app = getCurrentInstance()
const $axios = app.appContext.config.globalProperties.$axios

const title = 'About Us - My Website'
const description = 'Learn more about our company and team on this page.'
const pageUrl = `${baseUrl}/about`

usePageMeta({
  title,
  description,
  pageUrl,
  type: 'website'
})

const cityRef = ref('')
const qualityRef = ref('')
onMounted(async () => {
  await $axios({
    url: '/api/weather/city/101030100',
    method: 'get'
  })
    .then((res) => {
      console.log('about', res)
      const { cityInfo, data } = res.data
      cityRef.value = cityInfo.city
      qualityRef.value = data.quality
    })
    .catch((err) => console.error('about', err))
})
</script>

<style scoped lang="scss">
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;

    div {
      margin-top: 2rem;
      display: grid;
      gap: 1rem;
      grid-template-rows: repeat(2, 1fr);
      &:nth-of-type(1) {
        grid-template-columns: repeat(4, 1fr);
      }

      &:nth-of-type(2) {
        grid-template-columns: repeat(2, 1fr);
      }
    }
  }
}
</style>
