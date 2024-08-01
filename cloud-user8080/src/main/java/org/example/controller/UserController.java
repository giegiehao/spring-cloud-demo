package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.DO.User;

import org.example.entity.VO.UserVO;
import org.example.resp.Resp;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2024-07-26 16:34:57
 */
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    /**
     * 服务对象
     */
    private final UserService userService;

    @GetMapping
    public Resp<List<UserVO>> getUsers() {
        List<User> list = userService.list();
        List<UserVO> userVOS = UserVO.ofList(list);
        return Resp.success(userVOS);
    }
}

