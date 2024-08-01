package org.example.entity.DO;

import lombok.Data;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2024-07-26 15:32:53
 */

@Data
@SuppressWarnings("serial")
public class User {

    private Integer userId;

    private String userName;

    private Integer userAge;

    private String userPassword;

    private String userRole;


}

