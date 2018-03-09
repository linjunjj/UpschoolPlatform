package com.linjun.utils;

/**
 * @author 林俊
 * @create 2018/3/9.
 * @desc 常量
 **/
public class Constant {
    /**
     * 超级管理员ID
     */
    public static final int SUPER_ADMIN = 1;

    /**
     * ORACLE、MYSQL
     */
    public static final String USE_DATA = "MYSQL";
    /**
     * 分页条数
     */
    public static final int pageSize=10;

    /**
     * 菜单类型
     *
     * @author lipengjun
     * @email 939961241@qq.com
     * @date 2016年11月15日 下午1:24:29
     */
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        private MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 定时任务状态
     *
     * @author lipengjun
     * @email 939961241@qq.com
     * @date 2016年12月3日 上午12:07:22
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL(0),
        /**
         * 暂停
         */
        PAUSE(1);

        private int value;

        private ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 云服务商
     */
    public enum CloudService {
        /**
         * 七牛云
         */
        QINIU(1),
        /**
         * 阿里云
         */
        ALIYUN(2),
        /**
         * 腾讯云
         */
        QCLOUD(3);

        /**
         * 腾讯云
         */


        private int value;

        private CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 是否类型
     */
    public enum YESNO{
        /**
         * 是
         */
        YES("0"),
        /**
         * 否
         */
        NO("1");
        private String value;

        private YESNO(String value){
            this.value=value;
        }
        public String getValue(){
            return value;
        }
    }
}
