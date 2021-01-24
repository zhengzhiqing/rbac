package com.eric.rbac.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public abstract class BaseController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 获取用户信息
     * @return
     */
    protected UserContext getUserContext() {
        //TODO 从ThreadLocal中获取
        return new UserContext();
    }
}
