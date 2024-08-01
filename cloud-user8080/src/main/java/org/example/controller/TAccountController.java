package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.DO.TAccount;
import org.example.entity.VO.AccountVO;
import org.example.resp.Resp;
import org.example.service.TAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (TAccount)表控制层
 *
 * @author makejava
 * @since 2024-07-26 18:28:19
 */
@RestController
@RequestMapping("tAccount")
@RequiredArgsConstructor
public class TAccountController {
    /**
     * 服务对象
     */
    private final TAccountService tAccountService;

    @GetMapping
    public Resp<List<AccountVO>> getAll() {
        try {
            Thread.sleep(62000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<TAccount> list = tAccountService.list();
        List<AccountVO> accountVOS = AccountVO.ofList(list);
        return Resp.success(accountVOS);
    }

    @GetMapping("/{id}")
    public Resp<AccountVO> queryById(@PathVariable("id") String id) {
        TAccount byId = tAccountService.getById(id);
        AccountVO accountVO = AccountVO.of(byId);
        return Resp.success(accountVO);
    }
}

