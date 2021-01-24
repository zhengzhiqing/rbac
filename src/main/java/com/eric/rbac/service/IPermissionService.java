package com.eric.rbac.service;

import com.eric.rbac.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Eric Zheng
 * @since 2021-01-24
 */
public interface IPermissionService extends IService<Permission> {
    Permission getByCode(String permissionCode);
}
