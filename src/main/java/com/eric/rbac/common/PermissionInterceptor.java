package com.eric.rbac.common;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.eric.rbac.service.IUserPermissionService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PermissionInterceptor implements HandlerInterceptor {

    @Autowired
    private IUserPermissionService userPermissionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        AccessControl accessControl = method.getAnnotation(AccessControl.class);
        if (accessControl == null) {
            return true;
        }

        String permissionCode = accessControl.value();
        if (StringUtils.isNotBlank(permissionCode)) {
            int userId = getUserId(request);
            if (userPermissionService.hasPermission(userId, permissionCode)) {
                log.warn("用户【{}】有操作权限【{}】", userId, permissionCode);
            } else {
                log.warn("用户【{}】无操作权限【{}】", userId, permissionCode);
                throw new RuntimeException("没有操作权限");
            }
        }

        return true;
    }

    /**
     * TODO 从请求中获取解析出用户ID
     *
     * @param request
     * @return
     */
    private Integer getUserId(HttpServletRequest request) {
        return 1;
    }

}
