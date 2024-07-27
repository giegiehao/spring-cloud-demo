package org.example.entity.VO;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import lombok.Data;
import org.example.entity.DO.User;

import java.util.List;

@Data
public class UserVO {
    private Integer userId;
    private String userName;
    private Integer userAge;
    private String userRole;

    public static UserVO of(User user) {
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(user, userVO);
        return userVO;
    }

    public static List<UserVO> ofList(List<User> users) {
        return BeanUtil.copyToList(users, UserVO.class);
    }
}
