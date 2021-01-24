package com.eric.rbac.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eric.rbac.entity.RolePermission;
import com.eric.rbac.mapper.RolePermissionMapper;
import com.eric.rbac.service.IRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Eric Zheng
 * @since 2021-01-24
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {

    @Override
    public List<RolePermission> listByPermission(Integer permissionId) {
        QueryWrapper<RolePermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("permission_id", permissionId);
        return list(queryWrapper);
    }
}
