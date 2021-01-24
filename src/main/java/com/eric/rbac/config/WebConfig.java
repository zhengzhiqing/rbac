package com.eric.rbac.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.eric.rbac.common.PermissionInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private PermissionInterceptor permissionInterceptor;

    /**
     * 是否开启权限控制，默认开启
     * 如果权限服务不可用影响业务，可以手动在配置中心关闭
     */
    @Value("${acl.enabled:true}")
    private boolean aclEnabled;

    /**
     * 权限校验白名单
     * 根据应用实际需要配置
     */
    private final List<String> aclWhiteList = Arrays.asList(
            "/static/**",
            "/logout",
            "/e/**",
            "/error/**",
            "/test/**",
            "/health");

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (aclEnabled) {
            registry.addInterceptor(permissionInterceptor)
                    .addPathPatterns("/**")
                    .excludePathPatterns(aclWhiteList);
        }
    }

}