package com.korebit.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Alpha {
    private final String name;
    private int appearances;
    private Long bestTime;

    public void updateTime(long newTime) {
        if (newTime < this.bestTime || this.bestTime == 0) {
            this.bestTime = newTime;
        }
    }
}
