package com.se.enums.sheetState;

import com.se.enums.BaseEnum;

public enum  PaySheetState implements BaseEnum<PaySheetState, String> {
    PENDING("待审批"),
    SUCCESS("审批完成"),
    FAILURE("审批失败");

    private final String value;

    PaySheetState(String value){this.value=value;}

    @Override
    public String getValue() {
        return value;
    }
}
