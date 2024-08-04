package org.example.apis;

import org.example.entity.VO.AccountVO;
import org.example.resp.Resp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "cloud-user8080")
public interface AccountFeignApi {
    @GetMapping("/tAccount")
    Resp<List<AccountVO>> getAccount();

    @GetMapping("/tAccount/{id}")
    Resp<AccountVO> queryById(@PathVariable("id") String id);

    @GetMapping("/test/port")
    Resp<String> getPort();

    @GetMapping("/test/circuitBreaker/{sleep}")
    Resp<String> circuitBreakerTest(@PathVariable("sleep") Integer sleep);

    @GetMapping("/test/bulkhead/{id}")
    Resp<String> bulkheadTest(@PathVariable("id") String id);
}
