package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.example.entity.DO.EmployeeDO;

/**
 * (TEmployee)实体类
 *
 * @author makejava
 * @since 2024-07-26 18:49:48
 */
@Data
@TableName("t_employee")
public class Employee extends EmployeeDO{
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private String department;

    private String position;

}

