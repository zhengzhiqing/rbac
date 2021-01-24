package com.eric.rbac.entity;

import com.eric.rbac.common.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Eric Zheng
 * @since 2021-01-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private String email;

    private Integer age;


}
