package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.DO.Account;
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

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping
    public Resp<List<AccountVO>> getAll() {
        List<Account> list = tAccountService.list();
        List<AccountVO> accountVOS = AccountVO.ofList(list);
        return Resp.success(accountVOS);
    }
}

