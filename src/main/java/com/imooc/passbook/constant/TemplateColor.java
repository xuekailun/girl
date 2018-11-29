package com.imooc.passbook.constant;

/**
 * 优惠券模板的背景颜色
 */
public enum TemplateColor {
    RED(1,"红色"),
    GREEN(2,"绿色"),
    BLUE(3,"蓝色");

    TemplateColor(Integer code, String color) {
        this.code = code;
        this.color = color;
    }

    /** 背景颜色的代码*/
    private Integer code;

    /** 颜色的描述 */
    private String color;

    public Integer getCode() {
        return code;
    }

    public String getColor() {
        return color;
    }
}
