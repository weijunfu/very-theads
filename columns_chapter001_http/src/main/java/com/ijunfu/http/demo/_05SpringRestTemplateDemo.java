package com.ijunfu.http.demo;

import org.springframework.web.client.RestTemplate;

/**
 * Spring RestTemplate请求示例
 * @author ijunfu
 * @version 1.0.0
 *
 */
public class _05SpringRestTemplateDemo {

    public static void main(String[] args) {
        // 1. 创建客户端
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://run.mocky.io/v3/7547330b-8c31-4ef0-898e-cf9f834b6862";

        // 2. 执行请求
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
    }
}
