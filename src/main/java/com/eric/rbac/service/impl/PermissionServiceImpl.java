package com.eric.rbac.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eric.rbac.entity.Permission;
import com.eric.rbac.mapper.PermissionMapper;
import com.eric.rbac.service.IPermissionService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Eric Zheng
 * @since 2021-01-24
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Override
    public Permission getByCode(String permissionCode) {
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("permission_code", permissionCode);
        return getOne(queryWrapper);
    }

}
