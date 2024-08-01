package org.example.controller;

import org.example.resp.Resp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class OtherController {
    @Value("${server.port}")
    private String port;
    @GetMapping("/port")
    public Resp<String> getPort() {
        return Resp.success("负载均衡当前端口：" + port);
    }
}
