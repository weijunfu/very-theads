package com.ijunfu.http.demo;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Spring WebClient 请求示例
 * @author ijunfu
 * @version 1.0.0
 *
 */
public class _04SpringWebClientDemo {

    public static void main(String[] args) {

        // 1. 创建客户端
        WebClient client = WebClient.create("https://run.mocky.io");

        // 2. 发送请求
        client.get()
                .uri("/v3/7547330b-8c31-4ef0-898e-cf9f834b6862")
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(System.out::println);

    }
}
