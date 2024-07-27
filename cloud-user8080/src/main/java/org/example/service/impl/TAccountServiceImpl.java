package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.TAccountDao;
import org.example.entity.DO.Account;
import org.example.service.TAccountService;
import org.springframework.stereotype.Service;

/**
 * (TAccount)表服务实现类
 *
 * @author makejava
 * @since 2024-07-26 18:28:21
 */
@Service("tAccountService")
public class TAccountServiceImpl extends ServiceImpl<TAccountDao, Account> implements TAccountService {

}

