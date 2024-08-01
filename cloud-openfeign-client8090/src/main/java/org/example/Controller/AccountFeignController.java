package org.example.Controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import lombok.RequiredArgsConstructor;
import org.example.apis.AccountFeignApi;
import org.example.entity.VO.AccountVO;
import org.example.resp.Resp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feign/account")
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
}
