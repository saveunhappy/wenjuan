package com.course.server.enums;

public enum GenderStatusEnum {
    MALE("男", "男"),
    FEMALE("女", "女");

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
