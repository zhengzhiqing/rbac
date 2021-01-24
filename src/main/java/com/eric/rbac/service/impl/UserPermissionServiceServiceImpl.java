package com.eric.rbac.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.eric.rbac.entity.Permission;
import com.eric.rbac.entity.RolePermission;
import com.eric.rbac.entity.UserRole;
import com.eric.rbac.service.IPermissionService;
import com.eric.rbac.service.IRolePermissionService;
import com.eric.rbac.service.IUserPermissionService;
import com.eric.rbac.service.IUserRoleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserPermissionServiceServiceImpl implements IUserPermissionService {

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private IRolePermissionService rolePermissionService;

    @Autowired
    private IUserRoleService userRoleService;

    /**
     * 用户是否有权限执行操作
     * @param userId
     * @param permissionCode
     * @return
     */
    @Override
    public boolean hasPermission(Integer userId, String permissionCode) {
        Permission permission = permissionService.getByCode(permissionCode);
        if (permission == null) {
            log.warn("权限还未在数据库中配置【】", permissionCode);
            return false;
        }
        List<RolePermission> rolePermissionList = rolePermissionService.listByPermission(permission.getId());
        List<Integer> roleIds = rolePermissionList.stream().map(RolePermission::getRoleId).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(roleIds)) {
            log.warn("权限还未分配给任何角色【】", permissionCode);
            return false;
        }
        List<UserRole> userRoles = userRoleService.listByUserId(userId, roleIds);
        if (CollectionUtils.isEmpty(userRoles)) {
            return false;
        }
        return true;
    }
}
