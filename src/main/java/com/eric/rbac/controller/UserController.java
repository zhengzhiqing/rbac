package com.eric.rbac.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eric.rbac.common.AccessControl;
import com.eric.rbac.common.BaseController;
import com.eric.rbac.entity.User;
import com.eric.rbac.service.IUserService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Eric Zheng
 * @since 2021-01-24
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @GetMapping("/all")
    @AccessControl("user:query")
    private List<User> listAll() {
        List<User> userList = userService.list();
        userList.forEach((u -> log.info(u.toString())));
        return userList;
    }

    @PostMapping("/create")
    @AccessControl("user:create")
    private void create(@RequestParam String name,
                        @RequestParam String email,
                        @RequestParam Integer age) {
        User user = new User();
        user.setName(name)
                .setEmail(email)
                .setAge(age);
        userService.save(user);
    }

    @PostMapping("/update")
    @AccessControl("user:update")
    private void update(@RequestParam Integer id,
                        @RequestParam String name,
                        @RequestParam Integer version) {
        User user = new User();
        user.setName(name).setId(id).setVersion(version);
        userService.updateById(user);
    }

    @PostMapping("/delete")
    @AccessControl("user:delete")
    private void delete(@RequestParam Integer id,
                        @RequestParam Integer version) {
        User user = new User();
        user.setId(id)
                .setDeleted(true)
                .setVersion(version);
        userService.updateById(user);
    }

    @GetMapping("/paging")
    private List<User> paging() {
        IPage<User> userIPage = userService.pageUser();
        return userIPage.getRecords();
    }
}
