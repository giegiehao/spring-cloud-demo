package org.example.controller;

import net.sf.jsqlparser.statement.select.KSQLWindow;
import org.example.resp.Resp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
public class OtherController {
    @Value("${server.port}")
    private String port;
    @GetMapping("/port")
    public Resp<String> getPort() {
        return Resp.success("负载均衡当前端口：" + port);
    }

    /**
     * 用来测试断路器运行
     * @param sleep
     * @return
     */
    @GetMapping("/circuitBreaker/{sleep}")
    public Resp<String> circuitBreakerTest(@PathVariable("sleep") Integer sleep) {
        System.out.println("请求原服务");
        if (sleep == 99) {
            throw new RuntimeException("模拟业务错误");
        }

        try {
            TimeUnit.SECONDS.sleep(sleep);
        }catch (Exception e) {
            throw new RuntimeException();
        }

        return Resp.success("处理"+ sleep + "秒后成功");
    }

    @GetMapping("/bulkhead/{id}")
    public Resp<String> bulkheadTest(@PathVariable("id") String id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return Resp.success("8080服务端正确响应：id" + id);
    }
}
