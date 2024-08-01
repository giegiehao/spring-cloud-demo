package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.DO.EmployeeDO;
import org.example.entity.Employee;
import org.example.entity.VO.AccountVO;
import org.example.resp.Resp;
import org.example.service.TEmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * (TEmployee)表控制层
 *
 * @author makejava
 * @since 2024-07-26 19:02:12
 */
@RestController
@RequestMapping("tEmployee")
@RequiredArgsConstructor
public class TEmployeeController {
    /**
     * 服务对象
     */
    private final TEmployeeService tEmployeeService;
    private final RestTemplate restTemplate;
    private final String URL = "http://cloud-user8080";

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping
    public Resp<List<Employee>> getAll() {
        List<Employee> list = tEmployeeService.list();

        return Resp.success(list);
    }
    @GetMapping("/account")
    public Resp<List<AccountVO>> RestTemplateGetAccount() {
        Resp<List<AccountVO>> forObject = restTemplate.getForObject(URL+"/tAccount", Resp.class);
        List<AccountVO> data = forObject.getData();

        return Resp.success(data);
    }
}