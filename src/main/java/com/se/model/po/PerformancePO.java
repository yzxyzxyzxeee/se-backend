package com.se.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PerformancePO {
    private String name;
    private int month;
    private String p1;
    private String p2;
    private String p3;
    private String p4;
    private String p5;
}
