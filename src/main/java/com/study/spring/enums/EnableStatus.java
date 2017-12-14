package com.study.spring.enums;

public enum  EnableStatus {
    FALSE(0, false),
    TRUE(1, true);

    private final int intValue;
    private final boolean booleanValue;

    EnableStatus(int intValue, boolean booleanValue) {
        this.intValue = intValue;
        this.booleanValue = booleanValue;
    }

    public int getIntValue(){
        return this.intValue;
    }

    public boolean getBooleanValue(){
        return this.booleanValue;
    }
}
