package com.eric.rbac.service;

public interface IUserPermissionService {
    boolean hasPermission(Integer userId, String permissionCode);
}
