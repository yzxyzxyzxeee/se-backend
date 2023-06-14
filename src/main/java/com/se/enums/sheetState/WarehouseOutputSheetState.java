package com.se.enums.sheetState;

import com.se.enums.BaseEnum;

public enum WarehouseOutputSheetState implements BaseEnum<PurchaseSheetState, String> {

    DRAFT("草稿"), // 待仓库管理员确认
    PENDING("待审批"), // 待总经理审批
    SUCCESS("审批完成"),
    FAILURE("审批失败");

    private final String value;

    WarehouseOutputSheetState(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
