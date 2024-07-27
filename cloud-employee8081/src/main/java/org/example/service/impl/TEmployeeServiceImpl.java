package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.TEmployeeDao;
import org.example.entity.DO.Employee;
import org.example.service.TEmployeeService;
import org.springframework.stereotype.Service;

/**
 * (TEmployee)表服务实现类
 *
 * @author makejava
 * @since 2024-07-26 19:02:12
 */
@Service("tEmployeeService")
public class TEmployeeServiceImpl extends ServiceImpl<TEmployeeDao, Employee> implements TEmployeeService {


}

