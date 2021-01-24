package com.eric.rbac.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eric.rbac.entity.UserRole;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Eric Zheng
 * @since 2021-01-24
 */
public interface IUserRoleService extends IService<UserRole> {
    List<UserRole> listByUserId(Integer userId, List<Integer> roleIds);
}
