package com.ijunfu.http.demo;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

import java.io.IOException;

/**
 * Apache HttpClient GET 请求示例
 * @author ijunfu
 * @version 1.0.0
 *
 */
public class _02ApacheClientDemo {

    public static void main(String[] args) {
        String url = "https://run.mocky.io/v3/7547330b-8c31-4ef0-898e-cf9f834b6862";

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            ClassicHttpRequest httpGet = ClassicRequestBuilder.get(url)
                    .build();

            httpclient.execute(httpGet, response -> {
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
                final HttpEntity entity = response.getEntity();

                System.out.println(String.format("Response Body: %s", EntityUtils.toString(entity)));

                EntityUtils.consume(entity);
                return null;
            });
        } catch (IOException e) {

        }
    }
}
