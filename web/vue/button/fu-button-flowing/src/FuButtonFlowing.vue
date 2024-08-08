<template>
<div class="fu-button-flowing">
    <span></span>
    <span></span>
    <span></span>
    <span></span>
    {{ text }}
</div>
</template>
<script setup lang="ts">
defineProps({
    text: {
        type: String,
        required: true
    }
})
</script>
<style scoped lang="scss">

/* 生成动画 */
@mixin keyframes($name, $attr) {
    @keyframes #{$name} {
        0% { #{$attr}: -100%; }
        50%,100% { #{$attr}: 100% }
    }
}

@include keyframes(to-right, left);
@include keyframes(to-bottom, top);
@include keyframes(to-left, right);
@include keyframes(to-top, bottom);

$themeColor: var(--fu-button-color, #03e9f4);
.fu-button-flowing {
    color: $themeColor;
    position: relative;
    display: inline-block;
    padding: 4vmin 5vmin;
    text-transform: uppercase;
    letter-spacing: 1vmin;
    overflow: hidden;
    font-weight: bold;

    &:hover {
        cursor: pointer;
        background-color: $themeColor;
        color: #fff;
        box-shadow: 
            0 0 0.5vmin $themeColor,
            0 0 1vmin $themeColor,
            0 0 1.5vmin $themeColor;
    }

    &>span {
        position: absolute;
        display: block;

        $borderSize: 2px;
        &:nth-child(1) {
            top: 0;
            left: 0;
            width: 100%;
            height: $borderSize;
            background: linear-gradient(90deg, transparent, $themeColor);
            animation: to-right 1s linear infinite;
        }

        &:nth-child(2) {
            top: -100%;
            right: 0;
            width: $borderSize;
            height: 100%;
            background: linear-gradient(180deg, transparent, $themeColor);
            animation: to-bottom 1s .25s linear infinite;
        }

        &:nth-child(3) {
            bottom: 0;
            right: 0;
            width: 100%;
            height: $borderSize;
            background: linear-gradient(270deg, transparent, $themeColor);
            animation: to-left 1s .5s linear infinite;
        }

        &:nth-child(4) {
            bottom: 100%;
            left: 0;
            width: $borderSize;
            height: 100%;
            background: linear-gradient(360deg, transparent, $themeColor);
            animation: to-top 1s .75s linear infinite;
        }
    }


}

</style>