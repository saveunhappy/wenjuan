package com.course.server.enums;

public enum AdoptStatus {
    APPLY("1", "申请领养"),
    FINISHED("0","领养完成");

    private String code;

    private String desc;

    AdoptStatus(String code, String desc) {
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
