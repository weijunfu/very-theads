<script setup lang="ts">
import { ref, onMounted } from 'vue';
import * as echarts from 'echarts';

import random from '@/utils/random';
import china from '@/assets/map/china.json';
echarts.registerMap('china', china);

const mapRef = ref<HTMLElement | null>(null)

// 地图名称及数值
let data = [
  {name: '北京', value: random(100)},
  {name: '天津', value: random(100)},
  {name: '上海', value: random(100)},
  {name: '重庆', value: random(100)},
  {name: '河北', value: random(100)},
  {name: '河南', value: random(100)},
  {name: '云南', value: random(100)},
  {name: '辽宁', value: random(100)},
  {name: '黑龙江', value: random(100)},
  {name: '湖南', value: random(100)},
  {name: '安徽', value: random(100)},
  {name: '山东', value: random(100)},
  {name: '新疆', value: random(100)},
  {name: '江苏', value: random(100)},
  {name: '浙江', value: random(100)},
  {name: '江西', value: random(100)},
  {name: '湖北', value: random(100)},
  {name: '广西', value: random(100)},
  {name: '甘肃', value: random(100)},
  {name: '山西', value: random(100)},
  {name: '内蒙古', value: random(100)},
  {name: '陕西', value: random(100)},
  {name: '吉林', value: random(100)},
  {name: '福建', value: random(100)},
  {name: '贵州', value: random(100)},
  {name: '广东', value: random(100)},
  {name: '青海', value: random(100)},
  {name: '西藏', value: random(100)},
  {name: '四川', value: random(100)},
  {name: '宁夏', value: random(100)},
  {name: '海南', value: random(100)},
  {name: '台湾', value: random(100)},
  {name: '香港', value: random(100)},
  {name: '澳门', value: random(100)},
  {name: '南海诸岛', value: random(100)}
];

// 静态数据
const option = {
  backgroundColor: '#010347',
  tooltip: {
    trigger: 'item',
    formatter: '{b}：{c}'
  },
  visualMap: {
    min: 0,
    max: 500,
    text: ['最高', '最低'],
    realtime: false,
    calculable: false,
    inRange: {
      color: ['#E85827','#800020']
    },
    textStyle: {
      color: '#fff'
    }
  },
  geo: {
    show: true,
    map: 'china',
    itemStyle: {
      // areaColor: '#01215c',
      borderWidth: 1,
      borderColor: '#9ffcff',
      shadowColor: 'rgba(0,54,255,1)',
      shadowBlur: 30,
    }
  },
  series: [
    {
      name: 'china-map',
      type: 'map',
      map: 'china',
      data: data,
      label: {
        show: true,   // 显示文字
        formatter: '{b}',
        zoom: 1.5,  // 地图缩放
        color: 'rgba(255,255,255,.5)' // 文本颜色
      },
      emphasis: {
        label: {
          color: '#fff'           // 鼠标悬浮文字颜色
        },
        itemStyle: {
          areaColor: '#0462c2'    // 鼠标悬浮区域背景色
        }
      },
    }, {
      type: 'effectScatter',
      coordinateSystem: 'geo',
      data: [
          {
            name: '北京',
            value: [116.46, 39.92, 100]
          },
          {
            name: '上海',
            value: [121.48, 31.22, 100]
          },
          {
            name: '深圳',
            value: [114.07, 22.62, 100]
         },
        {
          name: '乌鲁木齐',
          value: [87.68, 43.77, 100]
        },
        {
          name: '台湾',
          value: [121.51, 25.03, 100]
        },
      ],
      symbolSize: 10,
      rippleEffect: {
        brushType: 'stroke',
        scale: 3,
      },
      label: {
        show: false,
      },
      showEffectOn: 'render',
      itemStyle: {
        shadowBlur: 10,
        color: 'yellow',
        shadowColor: 'yellow',
      }
    }, {
      name: '飞线',
      type: 'lines',
      effect: {
        show: true,
        period: 4,
        trailLength: 0.1,
        symbol: 'circle',
        symbolSize: 15,
      },
      label: {
        formatter: '{b}',
        position: 'right',
        show: true
      },
      lineStyle: {
        shadowBlur: 10,
        shadowColor: 'rgba(128,0,128,.1)',
        color: '#c1a43c',
        width: 1,
        opacity: 1,
        curveness: 0.3,
      },
      data: [
        {
          coords: [
            [116.46, 39.92, 100], // 北京
            [121.48, 31.22, 200], // 上海
          ]
        }, {
          coords: [
            [116.46, 39.92, 300], // 北京
            [114.07, 22.62, 400], // 深圳
          ]
        }, {
          coords: [
            [116.46, 39.92, 500], // 深圳
            [87.68, 43.77, 600],  // 乌鲁木齐
          ]
        }
      ]
    }
  ]
}

onMounted(() => {
  if(mapRef.value) {
    const myChart = echarts.init(mapRef.value)
    myChart.setOption(option)
  }
})

</script>

<template>
<div class="map" ref="mapRef">
</div>
</template>

<style scoped lang="scss">
.map {
  padding: 40px 20px;
  width: 100%;
  height: 100%;
}
</style>