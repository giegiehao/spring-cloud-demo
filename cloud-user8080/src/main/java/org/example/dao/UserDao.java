package org.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.DO.User;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2024-07-26 16:35:23
 */
public interface UserDao extends BaseMapper<User> {

}

