package org.example.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * (TAccount)表实体类
 *
 * @author makejava
 * @since 2024-07-26 18:28:19
 */
@SuppressWarnings("serial")
@Data
@TableName("t_account")
public class Account {
    @TableId(type = IdType.AUTO, value = "e_id")
    private Integer Id;

    private String username;

    private String password;


}

