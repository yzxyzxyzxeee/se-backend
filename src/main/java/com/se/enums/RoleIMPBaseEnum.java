package com.se.enums;


public enum RoleIMPBaseEnum implements BaseEnum<RoleIMPBaseEnum,String> {
//用于控制层传输
    STAFF("职员"),
    GM("总经理"), // 总经理
    ADMIN ("最高权限");// 最高权限

    private final String value;

    RoleIMPBaseEnum(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
