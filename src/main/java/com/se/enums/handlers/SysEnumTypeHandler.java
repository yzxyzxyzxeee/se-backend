package com.se.enums.handlers;

import com.se.enums.BaseEnum;
import com.se.enums.CustomerType;
import com.se.enums.Gender;
import com.se.enums.sheetState.*;
import org.apache.ibatis.type.MappedTypes;

/**
 * 枚举转换的公共模块
 *
 */
@MappedTypes(value = {PurchaseSheetState.class, WarehouseInputSheetState.class, WarehouseOutputSheetState.class, CustomerType.class, SaleSheetState.class, PurchaseReturnsSheetState.class, ReceiptSheetState.class, Gender.class, PaySheetState.class, SalarySheetState.class})
public class SysEnumTypeHandler<E extends Enum<E> & BaseEnum> extends BaseEnumTypeHandler<E> {
    /**
     * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现
     *
     * @param type 配置文件中设置的转换类
     */
    public SysEnumTypeHandler(Class<E> type) {
        super(type);
    }
}