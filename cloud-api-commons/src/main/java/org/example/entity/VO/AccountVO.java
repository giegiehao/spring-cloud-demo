package org.example.entity.VO;

import cn.hutool.core.bean.BeanUtil;
import lombok.Data;
import org.example.entity.DO.TAccount;

import java.util.List;

@Data
public class AccountVO {
    private Integer Id;

    private String username;

    public static AccountVO of(TAccount TAccount) {
        AccountVO accountVO = new AccountVO();
        BeanUtil.copyProperties(TAccount, accountVO);
        return accountVO;
    }

    public static List<AccountVO> ofList(List<TAccount> TAccounts) {
        return BeanUtil.copyToList(TAccounts, AccountVO.class);
    }
}
