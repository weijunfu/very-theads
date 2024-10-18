package com.ijunfu.http.demo;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * OkHttp 请求示例
 * @author ijunfu
 * @version 1.0.0
 *
 */
public class _03OkHttpDemo {

    public static void main(String[] args) {
        String url = "https://run.mocky.io/v3/7547330b-8c31-4ef0-898e-cf9f834b6862";

        // 1. 创建客户端
        OkHttpClient client = new OkHttpClient();

        // 2. 创建请求
        Request request = new Request.Builder().url(url).build();

        // 3. 执行请求
        try (Response response = client.newCall(request).execute()) {
            System.out.println(String.format("Response Body: %s", response.body().string()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
