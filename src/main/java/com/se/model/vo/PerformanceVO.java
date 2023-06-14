package com.se.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PerformanceVO {

        private String name;
        private int p1;
        private int p2;
        private int p3;
        private int p4;
        private int p5;

}
