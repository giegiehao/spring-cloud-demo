package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.resp.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class OtherTest {
    @Value("${server.port}")
    private String port;

    private final DiscoveryClient discoveryClient;

    private final RestTemplate restTemplate;
    private final String URL = "http://cloud-user8080";

    @GetMapping
    public Resp<String> getInfo(@Value("${demo.info}") String info){

        return Resp.success(port + ":" + info);
    }

    @GetMapping("/loadBalance")
    public Resp<String> getPort() {
        return restTemplate.getForObject(URL+"/test/port", Resp.class);
    }

    @GetMapping("/loadBalance/service")
    public void getService() {
        //获取在consul上注册的服务
        for (String service : discoveryClient.getServices()) {
            System.out.println(service);
        }

        //获得当前服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-user8080");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
    }
}
