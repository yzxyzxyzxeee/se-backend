package com.se.model.po;

import com.se.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromotionPO {
    private String id;
    private String type;
    private String operator;
    private State state;
}
