<template>
    <div class="player-wrapper">
        <div class="youtube-player" ref="player"></div>
    </div>
</template>
<script setup lang="ts">

import { onMounted, ref } from 'vue'

const emit = defineEmits(['onReady'])

const player = ref(null)

const props = defineProps({
    videoId: {
        type: String,
        required: true
    },
    options: {
        type: Object,
        default: {}
    }
})

function onPlayerReady(event) {
    console.log('Youtube onReady');
    event.target.playVideo()
    emit('onReady')
}

function onPlayerStateChange(event) {
    if (event.data == YT.PlayerState.PLAYING) {
        console.log('play Youtube');
    }
}

function initPlayer(){
    if(player.value) {
        this.player = new YT.Player(player.value, {
            height: '100%',
            width: '100%',
            videoId: props.videoId,
            events: {
                'onReady': onPlayerReady,
                'onStateChange': onPlayerReady
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
.player-wrapper {
    width: 100%;
    height: 100%;
    position: relative;
    overflow: hidden;
}

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