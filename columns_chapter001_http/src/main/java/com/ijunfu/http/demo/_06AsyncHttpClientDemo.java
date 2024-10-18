package com.ijunfu.http.demo;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;

import java.io.IOException;

/**
 * AsyncHttpClient 请求示例
 * @author ijunfu
 * @version 1.0.0
 *
 */
public class _06AsyncHttpClientDemo {

    public static void main(String[] args) throws IOException {
        AsyncHttpClient httpClient = Dsl.asyncHttpClient();

        String responseBody = httpClient.prepareGet("https://run.mocky.io/v3/7547330b-8c31-4ef0-898e-cf9f834b6862")
                .execute()
                .toCompletableFuture()
                .join()
                .getResponseBody();

        System.out.println(responseBody);

        httpClient.close();
    }
}
