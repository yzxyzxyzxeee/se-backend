package com.se.enums.sheetState;

import com.se.enums.BaseEnum;


public enum ReceiptSheetState implements BaseEnum<ReceiptSheetState, String> {
    PENDING("待审批"),
    SUCCESS("审批完成"),
    FAILURE("审批失败");

    private final String value;

    ReceiptSheetState(String value){this.value=value;}

    @Override
    public String getValue() {
        return value;
    }
}
