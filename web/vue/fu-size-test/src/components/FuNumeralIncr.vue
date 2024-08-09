<template>
<div class="fu-numeral-incr" ref="numeralRef" :data-count="count">
    <span>0</span>
    <span v-if="unit">{{ unit }}</span>
</div>
</template>
<script setup lang="ts">
import { ref, onMounted, onUnmounted } from 'vue'

const numeralRef = ref(null)

defineProps({
    count: {
        type: Number,
        required: true
    }, 
    unit: {
        type: String,
        required: false
    }
})

function counter(element:HTMLElement) {
    if(!element) return

    if(!element.dataset.count) {
        console.error('not data-count attribute')
        return
    }

    let firstChild = element.querySelector('span:nth-child(1)')

    const targetValue = parseInt(element.dataset.count)
    
    let currentValue = parseInt(firstChild.textContent ? firstChild.textContent : '0', 10)

    let startTime = performance.now();
  
    function updateNumber(timestamp) {
      const progress = timestamp - startTime;
      const duration = 1000; // 动画持续时间，单位毫秒
      const value = Math.min(targetValue, currentValue + (targetValue - currentValue) * progress / duration);
  
      firstChild.textContent = value.toFixed(0); // 更新元素内容
  
      if (progress < duration) {
        requestAnimationFrame(updateNumber);
      }
    }
  
    requestAnimationFrame(updateNumber);
}

let observer:IntersectionObserver
onMounted(() => {
    if(numeralRef.value) {
        observer = new IntersectionObserver((entries) => {
            entries.forEach((entry) => {
                if(entry.isIntersecting) {
                    counter(numeralRef.value)
                } else {
                    let numEle = numeralRef.value.querySelector('span:nth-child(1)')
                    numEle.innerText = 0
                }
            })
        })

        observer.observe(numeralRef.value);
    }
})

onUnmounted(() => {
    if(observer && numeralRef.value) {
        // 取消观察目标元素
        observer.unobserve(numeralRef.value);
    }
})

</script>