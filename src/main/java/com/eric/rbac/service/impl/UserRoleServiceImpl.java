package com.eric.rbac.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eric.rbac.entity.UserRole;
import com.eric.rbac.mapper.UserRoleMapper;
import com.eric.rbac.service.IUserRoleService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Eric Zheng
 * @since 2021-01-24
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
    @Override
    public List<UserRole> listByUserId(Integer userId, List<Integer> roleIds) {
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("user_id", userId)
                .in("role_id", roleIds);
        return list(queryWrapper);
    }
}
