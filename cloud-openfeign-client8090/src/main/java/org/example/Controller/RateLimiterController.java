package org.example.Controller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import org.example.apis.AccountFeignApi;
import org.example.resp.Resp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate")
@RequiredArgsConstructor
public class RateLimiterController {
    public final AccountFeignApi api;

    @GetMapping("/{id}")
    @RateLimiter(name = "cloud-demo-8080C", fallbackMethod = "fallback")
    public Resp<String> rateTest(@PathVariable("id") String id) {
        return api.bulkheadTest(id);
    }

    public Resp<Object> fallback(String id, Throwable t) {
        return Resp.error("错误").setData("服务炸了老弟");
    }
}

