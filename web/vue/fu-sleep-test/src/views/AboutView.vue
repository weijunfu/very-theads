<template>
  <div class="about">
    <h1>Markdown Editor</h1>
    <div>
      <div class="markdown-body" v-html="html"></div>
    </div>
    <div>
      <FuEditor v-model="content" @changeHtml="changeHtml" />
    </div>
    <div>
      <FuNumeralIncr :count="200" />
    </div>
    <div>
      <FuNumeralIncr :count="400" unit="%" />
    </div>
  </div>
</template>
<script setup lang="ts">
import { ref } from 'vue'
import FuEditor from '../components/FuEditor/index.vue'

const content = ref('')
const html = ref('')

const changeHtml = (value: string) => {
  html.value = value
}
</script>
<style>
@media (min-width: 1024px) {
  .about {
    min-height: calc(100vh * 3);
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }
}
</style>
