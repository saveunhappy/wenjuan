package com.course.server.enums;

public enum GenderStatusEnum {
    MALE("1", "男性"),
    FEMALE("0", "女性");

    private String code;

    private String desc;

    GenderStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
