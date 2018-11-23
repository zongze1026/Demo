package com.huatong.config.datasource;



/**
 * Create By xzz on 2018/11/21
 */
public class DynamicDataSourceHolder {

    private static final ThreadLocal<String> dataSourceHolder = new ThreadLocal<>();


    /**
     * 设置数据源的key
     */
    public static void setKey(String key) {
        dataSourceHolder.set(key);
    }

    /**
     * 获取key
     */
    public static String getKey() {
        return dataSourceHolder.get();
    }

    /**
     * 清除key
     */
    public static void clear() {
        dataSourceHolder.remove();
    }



}
