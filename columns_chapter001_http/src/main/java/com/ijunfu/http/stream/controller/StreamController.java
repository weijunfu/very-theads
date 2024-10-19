package com.ijunfu.http.stream.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import reactor.core.publisher.Flux;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.Duration;
import java.util.stream.IntStream;

/**
 * 流式请求
 * @author ijunfu
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/stream")
public class StreamController {

    /**
     *  流式查询接口一：HttpServletResponse
     * @author ijunfu
     * @version 1.0.0
     * @param	response
     * @return void
     */
    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void download(HttpServletResponse response) {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=steam-data.txt");

        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()))) {
            IntStream.range(0, 1000).forEach(i -> {
                try {
                    bw.write(String.format("Line: %04d\tijunfu", i+1));
                    bw.newLine();
                    bw.flush();

                    Thread.sleep(200);  // Simulate delay
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/slow")
    public StreamingResponseBody stream() {
        return outputStream -> {
            try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                for(int i=0; i<100; i++) {
                    bw.write(String.format("Line: %04d\tijunfu", i+1));
                    bw.newLine();
                    bw.flush();

                    Thread.sleep(100);  // Simulate delay
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    @GetMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<String> steamFlux() {
        return Flux.interval(Duration.ofSeconds(1L))
                .map(sequence -> "flux-" + sequence)
                .take(10);
    }

    @GetMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> streamSse(){
        return Flux.interval(Duration.ofSeconds(1L))
                .map(sequence -> ServerSentEvent.<String>builder()
                        .id(String.valueOf(sequence))
                        .event("periodic-update")
                        .data("SSE Event - " + sequence)
                        .build())
                .take(10);
    }
}
