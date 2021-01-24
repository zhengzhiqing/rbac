package com.eric.rbac.service;

import java.util.List;

import com.eric.rbac.entity.RolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Eric Zheng
 * @since 2021-01-24
 */
public interface IRolePermissionService extends IService<RolePermission> {
    List<RolePermission> listByPermission(Integer permissionId);
}
