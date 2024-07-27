package org.example.entity.VO;

import cn.hutool.core.bean.BeanUtil;
import lombok.Data;
import org.example.entity.DO.Account;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Data
public class AccountVO {
    private Integer Id;

    private String username;

    public static AccountVO of(Account account) {
        AccountVO accountVO = new AccountVO();
        BeanUtil.copyProperties(account, accountVO);
        return accountVO;
    }

    public static List<AccountVO> ofList(List<Account> accounts) {
        return BeanUtil.copyToList(accounts, AccountVO.class);
    }
}
