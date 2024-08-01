package org.example.entity.DO;

import lombok.Data;

/**
 * (TAccount)表实体类
 *
 * @author makejava
 * @since 2024-07-26 18:28:19
 */
@SuppressWarnings("serial")
@Data
public class TAccount {
    public Integer E_id;

    private String username;

    private String password;

}

