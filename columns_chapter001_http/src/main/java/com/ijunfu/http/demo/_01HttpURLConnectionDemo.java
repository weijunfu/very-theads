package com.ijunfu.http.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

/**
 * HttpURLConnection GET 示例
 * @author ijunfu
 * @version 1.0.0
 *
 */
public class _01HttpURLConnectionDemo {

    public static void main(String[] args) {
        String url = "https://run.mocky.io/v3/7547330b-8c31-4ef0-898e-cf9f834b6862";

        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);

            int responseCode = conn.getResponseCode();

            if(HttpURLConnection.HTTP_OK == responseCode) {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = "";
                StringBuffer responseBody = new StringBuffer();
                while((line = br.readLine()) != null) {
                    responseBody.append(line).append("\n");
                }
                br.close();

                System.out.println(String.format("Response Body：%s", responseBody));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(Objects.nonNull(conn)) {
                conn.disconnect();
            }
        }
    }

}
