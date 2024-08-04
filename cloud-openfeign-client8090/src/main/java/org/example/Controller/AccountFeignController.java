package org.example.Controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.example.apis.AccountFeignApi;
import org.example.entity.VO.AccountVO;
import org.example.resp.Resp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feign")
public class AccountFeignController {
    private final AccountFeignApi accountClient;

    @GetMapping
    public Resp getAll() {
        System.out.println(DateUtil.now());
        System.out.println("通过feign getAll()方法转发请求");
        Resp<List<AccountVO>> account = null;
        try {
            account = accountClient.getAccount();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(DateUtil.now());
        }
        return account;
    }

    @GetMapping("/{id}")
    public Resp queryById(@PathVariable("id") String id) {
        System.out.println("通过feign queryById()方法转发请求");
        return accountClient.queryById(id);
    }

    @GetMapping("/port")
    public Resp<String> getPort() {
        return accountClient.getPort();
    }

    @GetMapping("/circuitBreaker/{sleep}")
    @CircuitBreaker(name = "cloud-demo-8080", fallbackMethod = "testFallback")
    public Resp<String> circuitBreakerTest(@PathVariable("sleep") Integer sleep) {
        return accountClient.circuitBreakerTest(sleep);
    }

    /**
     * 不使用feign服务调用，没有任务超时处理，即便超过了设定的值还是照常处理，但是当该断路器open状态时
     * 该请求还是会走服务降级
     * @param sleep
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/circuitBreaker/method/{sleep}")
    @CircuitBreaker(name = "cloud-demo-8080", fallbackMethod = "testFallback")
    public Resp<String> circuitBreakerMethod(@PathVariable("sleep") Integer sleep) throws InterruptedException {
        if (sleep == 99) {
            throw new RuntimeException();
        }
        TimeUnit.SECONDS.sleep(sleep);
        return Resp.success(sleep + "秒后成功返回");
    }

    public Resp<String> testFallback(Integer sleep, Throwable t) {
        return Resp.success("处理" + sleep + "秒的任务超时，系统繁忙");
    }


}
