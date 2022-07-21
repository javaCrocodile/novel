package com.example.novel.core.common.constant;

/**
 * 通用常量
 * @author:wxh
 * @date:2022/7/18
 **/
public class CommonConsts {
    /**
     * 是
     */
    public static final Integer YES = 1;

    /**
     * 否
     */
    public static final Integer NO = 0;

    public enum SexEnum{
        /**
         * 男
         */
        MALE(0, "男"),
        /**
         * 女
         */
        FEMALE(1, "女");

        private int code;
        private String desc;

        SexEnum(int code, String desc){
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }
}
