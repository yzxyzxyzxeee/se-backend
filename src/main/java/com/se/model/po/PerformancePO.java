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
    private int p1;
    private int p2;
    private int p3;
    private int p4;
    private int p5;
}
