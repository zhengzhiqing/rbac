package com.eric.rbac.service.impl;

import com.eric.rbac.entity.Role;
import com.eric.rbac.mapper.RoleMapper;
import com.eric.rbac.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
