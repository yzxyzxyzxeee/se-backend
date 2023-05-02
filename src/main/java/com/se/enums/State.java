package com.se.enums;

public enum State implements BaseEnum<State,String>{
    PENDING("待审批"), // 待总经理审批
    SUCCESS("审批完成"),
    FAILURE("审批失败");
    private final String value;

    State(String value){this.value=value;}
    @Override
    public String getValue() {
        return value;
    }
}
