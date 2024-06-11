<template>
<!-- 登录 -->
<div class="login">
    <van-nav-bar
        title="登录"
        left-text="返回"
        left-arrow
        @click-left="onClickLeft"
    />

    <div class="login-wrapper">
        <van-form 
        class="login-form" 
        @submit="onSubmit">
        <van-cell-group inset>
            <van-field
            v-model="username"
            name="用户名"
            label="用户名"
            placeholder="用户名"
            :rules="[{ required: true, message: '请填写用户名' }]"
            />
            <van-field
            v-model="password"
            type="password"
            name="密码"
            label="密码"
            placeholder="密码"
            :rules="[{ required: true, message: '请填写密码' }]"
            />
        </van-cell-group>
        <div style="margin: 16px;">
            <van-button round block type="primary" native-type="submit">
            提交
            </van-button>
        </div>
    </van-form>
    </div>

</div>
</template>
<script setup lang="ts">

import { ref } from 'vue'

const onClickLeft = () => history.back()

const username = ref('');
const password = ref('');
const onSubmit = (values) => {
    console.log('submit', values);
};

</script>
<style scoped lang="scss">

.login {
    display: flex;
    flex-direction: column;
    align-items: center;

    &-wrapper {
        width: 80%;
        --van-cell-line-height: 48px;
        --van-cell-font-size: 18px;
        --van-button-normal-font-size: 40px;
        --van-button-default-height: 80px;

        &-form {
        
            .van-cell+.van-cell {
                margin-top: 16px;
            }
        }
    }

    
}

</style>