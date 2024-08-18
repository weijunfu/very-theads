<template>
  <h2>Test page</h2>
</template>

<script setup>
import { usePageMeta, baseUrl } from '../utils/usePageMeta'

const title = 'Test - My Website'
const description = 'Learn more about our company and team on this page.'
const pageUrl = `${baseUrl}/test`

usePageMeta({
  title,
  description,
  pageUrl,
  type: 'website'
})
</script>
