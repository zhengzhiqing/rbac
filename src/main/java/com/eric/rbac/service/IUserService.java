package com.eric.rbac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eric.rbac.entity.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Eric Zheng
 * @since 2021-01-24
 */
public interface IUserService extends IService<User> {
    IPage<User> pageUser();
}
