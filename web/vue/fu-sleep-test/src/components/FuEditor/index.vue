<template>
  <div id="editor">
    <mavon-editor v-model="content" :subfield="true" :toolbars="toolbars" @change="change" />
  </div>
</template>
<script setup lang="ts" name="FuEditor">
import { computed, reactive } from 'vue'

const emit = defineEmits(['update:modelValue', 'changeHtml'])

const props = defineProps({
  modelValue: {
    type: String,
    required: true
  }
})

const content = computed({
  get: () => props.modelValue,
  set: (val: string) => emit('update:modelValue', val)
})

const toolbars = reactive({
  bold: true,
  italic: true,
  header: true,
  underline: true,
  strikethrough: true,
  mark: true,
  superscript: true,
  subscript: true,
  quote: true,
  ol: true,
  ul: true,
  link: true,
  imagelink: true,
  code: true,
  table: true,
  //   fullscreen: true,
  //   readmodel: true,
  //   htmlcode: true,
  //   help: true,
  /* 1.3.5 */
  undo: true,
  redo: true,
  trash: true,
  save: true,
  /* 1.4.2 */
  navigation: true,
  alignleft: true,
  aligncenter: true,
  alignright: true,
  subfield: true,
  toc: true,
  /* 2.1.0 */
  codeTheme: true,
  /* 2.1.9 */
  previewTheme: true
})

const change = (value: string, render: string) => {
  emit('changeHtml', render)
}
</script>
<style scoped lang="scss">
#editor {
  margin: auto;
  width: 80%;
  height: 580px;
}
</style>
