package com.se.enums.sheetState;

import com.se.enums.BaseEnum;

public enum WarehouseInputSheetState implements BaseEnum<WarehouseInputSheetState, String> {

    DRAFT("草稿"), // 待仓库管理员确认
    PENDING("待审批"), // 待总经理审批
    SUCCESS("审批完成"),
    FAILURE("审批失败");

    private final String value;

    WarehouseInputSheetState(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
