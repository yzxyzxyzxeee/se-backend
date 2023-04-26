package com.se.enums;

public enum Gender implements BaseEnum<Gender,String>{
    male("男"),
    female("女");
    Gender(String value){
        this.value=value;
    }
    private final String value;
    @Override
    public String getValue() {
        return null;
    }
}
