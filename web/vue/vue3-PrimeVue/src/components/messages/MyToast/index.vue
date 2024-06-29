<template>
  <div class="toast">
    <Toast />

    <div class="row">
      <h2>基础</h2>
      <Button label="Show" @click="show()" />
    </div>

    <div class="row">
      <h2>不同状态的Toast</h2>
      <Button label="Success" severity="success" @click="showSuccess()" />
      <Button label="Info" severity="info" @click="showInfo()" />
      <Button label="Warn" severity="warning" @click="showWarn()" />
      <Button label="Error" severity="danger" @click="showError()" />
      <Button label="Contrast" severity="contrast" @click="showContrast()" />
      <Button label="Secondary" severity="secondary" @click="showSecondary()" />
    </div>

    <div class="row">
      <h2>显示在不同位置</h2>
      <Toast position="top-left" group="tl" />
      <Toast position="bottom-left" group="bl" />
      <Toast position="top-right" group="tr" />
      <Toast position="bottom-right" group="br" />

      <Button label="左上" @click="showPosition('tl')" />
      <Button label="左下" @click="showPosition('bl')" />
      <Button label="右上" @click="showPosition('tr')" />
      <Button label="右下" @click="showPosition('br')" />
    </div>

    <div class="row">
      <h2>显示多条信息</h2>
      <Button label="显示多条信息" @click="showMult()" />
    </div>

    <div class="row">
      <h2>清除消息</h2>
      <Button label="显示消息" @click="showMessage()" />
      <Button label="清除" severity="info" @click="cleanMessage()" />
    </div>

    <div class="row">
      <h2>自定义显示模板</h2>
      <Toast position="bottom-center" group="ct">
        <template #message="slotProps">
          <i class="pi pi-user"></i>
          <span>{{ slotProps.message.summary }}</span>
        </template>
      </Toast>
      <Button label="自定义模板" @click="showTemplate()" />
    </div>
  </div>
</template>
<script setup lang="ts">
import Toast from 'primevue/toast'
import { useToast } from 'primevue/usetoast'
const toast = useToast()

const show = () => {
  toast.add({
    severity: 'info',
    summary: '这是标题',
    detail: '这是详情...',
    life: 2000 // 存活时长，单位毫秒
  })
}

const showSuccess = () => {
  toast.add({ severity: 'success', summary: '成功', detail: '已保存', life: 2000 })
}
const showInfo = () => {
  toast.add({ severity: 'info', summary: '提示', detail: '已发送', life: 2000 })
}
const showWarn = () => {
  toast.add({ severity: 'warn', summary: '警告', detail: '请联系客服', life: 2000 })
}
const showError = () => {
  toast.add({ severity: 'error', summary: '错误', detail: '请联系客服', life: 2000 })
}
const showContrast = () => {
  toast.add({ severity: 'contrast', summary: '', detail: 'Welcome to you!', life: 2000 })
}
const showSecondary = () => {
  toast.add({ severity: 'secondary', summary: '', detail: 'My name is ijunfu', life: 2000 })
}

const showPosition = (group) => {
  toast.add({
    severity: 'info',
    summary: 'Info Message',
    detail: 'Message Content',
    group: group,
    life: 3000
  })
}

const showMult = () => {
  toast.add({ severity: 'success', summary: 'Success', detail: 'Message Content', life: 3000 })
  toast.add({ severity: 'info', summary: 'Info', detail: 'Message Content', life: 3050 })
  toast.add({ severity: 'warn', summary: 'Warning', detail: 'Message Content', life: 3100 })
  toast.add({ severity: 'error', summary: 'Error', detail: 'Message Content', life: 3150 })
}

const showMessage = () => {
  toast.add({ severity: 'info', summary: '提示', detail: '已发送' })
}

const cleanMessage = () => {
  toast.removeAllGroups()
}

const showTemplate = () => {
  toast.add({ severity: 'success', summary: '通知', group: 'ct', life: 3000 })
}
</script>
<style scoped lang="scss">
.toast {
  .row {
    margin-top: 0.5rem;
  }
}
</style>
