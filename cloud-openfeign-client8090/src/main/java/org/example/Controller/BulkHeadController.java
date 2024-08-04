package org.example.Controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import lombok.RequiredArgsConstructor;
import org.example.apis.AccountFeignApi;
import org.example.resp.Resp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/bulkhead")
@RequiredArgsConstructor
public class BulkHeadController {
    private final AccountFeignApi api;

    /**
     * 信号量隔离
     * @param id
     * @return
     */
    @GetMapping("/semaphorebulkhead/{id}")
    @Bulkhead(name = "cloud-demo-8080A", fallbackMethod = "fallback", type = Bulkhead.Type.SEMAPHORE)
    public Resp<String> semaphoreBulkheadTest(@PathVariable("id") String id) {
//        return api.bulkheadTest(id);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Resp.success("成功");
    }

    public Resp<String> fallback(String id, Throwable e) {
        return Resp.error("服务器炸了，无法处理：id：" + id);
    }

    /**
     * 线程池隔离
     * @param id
     * @return
     */
    @GetMapping("/threadPoolBulkhead/{id}")
    @Bulkhead(name = "cloud-demo-8080B", fallbackMethod = "poolFallback", type = Bulkhead.Type.THREADPOOL)
    public CompletableFuture<Resp<String>> threadPoolBulkheadTest(@PathVariable("id") String id) {
        return CompletableFuture.supplyAsync(() -> {
            Resp<String> stringResp = api.bulkheadTest(id);
            stringResp.setData(stringResp.getData() + "\t" + Thread.currentThread().getName());
            return stringResp;
        });
    }

    public CompletableFuture<Resp<String>> poolFallback(String id, Throwable t) {
        return CompletableFuture.supplyAsync(() -> Resp.error("服务器炸了，无法处理：id：" + id));
    }
}
