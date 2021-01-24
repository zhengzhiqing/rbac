package com.eric.rbac.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eric.rbac.entity.User;
import com.eric.rbac.mapper.UserMapper;
import com.eric.rbac.service.IUserService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Eric Zheng
 * @since 2021-01-24
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    public IPage<User> pageUser() {
        //1、创建page对象
        //传入两个参数：当前页 和 每页显示的记录数
        Page<User> page = new Page<>(1, 3);
        //调用mp分页查询的方法
        //在调用mp分页查询过程中，底层将分页所有数据封装到page对象里面
        IPage<User> result = userMapper.selectPage(page, null);

        //通过page对象获取分页数据
        log.info("current page：" + page.getCurrent());//获取当前页
        log.info("page size：" + page.getSize());//每页显示的记录数
        log.info("current records：" + page.getRecords());//每页数据的list集合

        log.info("total records：" + page.getTotal());//总记录数
        log.info("total pages：" + page.getPages());//总页数

        log.info("has next page：" + page.hasNext());//是否有下一页
        log.info("has previous page：" + page.hasPrevious());//是否有上一页

        return result;

    }
}
