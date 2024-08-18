<script setup lang="ts">
import TheWelcome from '../components/TheWelcome.vue'

import { usePageMeta, baseUrl } from '../utils/usePageMeta'

const title = 'Home - My Website'
const description = 'Learn more about our company and team on this page.'
const pageUrl = `${baseUrl}/about`

usePageMeta({
  title,
  description,
  pageUrl,
  type: 'website'
})
</script>

<template>
  <main>
    <TheWelcome />
  </main>
</template>
