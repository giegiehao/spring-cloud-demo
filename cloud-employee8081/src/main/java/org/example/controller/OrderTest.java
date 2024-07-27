package org.example.controller;

import org.example.resp.Resp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class OrderTest {
    @Value("${server.port}")
    private String port;
    @GetMapping
    public Resp<String> getInfo(@Value("${demo.info}") String info){

        return Resp.success(port + ":" + info);
    }
}
