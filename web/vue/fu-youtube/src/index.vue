<template>
    <div class="player-wrapper">
        <!-- 封面 -->
        <img :class="['youtube-poster', videoLoaded?'hidden':'']" :src="poster" alt="Youtube Poster,fu-youtube,ijunfu"/>
        
        <!-- 播放器 -->
        <div :class="['youtube-player', videoLoaded?'':'hidden']" ref="playerRef"></div>
    </div>
</template>
<script setup lang="ts">

import { computed, onMounted, ref, watch } from 'vue'

const emit = defineEmits(['onReady'])

const playerRef = ref(null)
const videoLoaded = ref(false)

const props = defineProps({
    videoId: {
        type: String,
        required: true
    },
    options: {
        type: Object,
        default: {}
    },
    // quality: {
    //     type: String,
    //     default: 'default' // 可以是 'small', 'medium', 'large', 'hd720', 'hd1080', 'highres'
    // }
})

const poster = computed(() => `https://img.youtube.com/vi/${props.videoId}/maxresdefault.jpg`)

let player = null

function onPlayerReady(event) {
    
    videoLoaded.value = true

    event.target.playVideo()
    
    emit('onReady')
}

function onPlayerStateChange(event) {
    if (event.data == YT.PlayerState.PLAYING) {
        console.log('play Youtube ...');
    }
}

function onPlayerError(event) {
    videoLoaded.value = false
    console.error(`Youtube load error: ${event.data}`)
}

function initPlayer(){
    if(playerRef.value) {
        player = new YT.Player(playerRef.value, {
            height: '100%',
            width: '100%',
            videoId: props.videoId,
            events: {
                'onReady': onPlayerReady,
                'onStateChange': onPlayerStateChange,
                'onError': onPlayerError
            },
            playerVars: props.options
        })
    } 
}

onMounted(() => {
    // 加载Youtube IFrame API
    const youtubeIframeApiId = 'youtube-iframe-api'
    if(!document.getElementById(youtubeIframeApiId)) {
        const tag = document.createElement('script')
        tag.id = youtubeIframeApiId
        tag.src = 'https://www.youtube.com/iframe_api'

        const firstscriptTag = document.getElementsByTagName('script')[0]
        firstscriptTag.parentNode?.insertBefore(tag, firstscriptTag)
    }

    // 等待 Youtube IFrame API加载完成之后初始化播放器
    window.onYouTubeIframeAPIReady = initPlayer
})

</script>
<style scoped>

.hidden {
    display: none;
}

.player-wrapper {
    width: 100%;
    height: 100%;
    position: relative;
    overflow: hidden;
}

/* 视频封面 */
.youtube-poster {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    object-fit: cover;
}

/* Youtube 播放器 */
.youtube-player {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    transform: scale(2);
    object-fit: contain;
}

</style>