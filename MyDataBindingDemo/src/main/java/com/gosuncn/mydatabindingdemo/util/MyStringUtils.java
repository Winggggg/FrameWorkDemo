package com.gosuncn.mydatabindingdemo.util;

/**
 * Created by Administrator on 2018/5/4 0004.
 * 字符串工具类
 */

public class MyStringUtils {
    // 首字母大写
    public static String capitalize(final String word) {
        if (word.length() > 1) {
            return String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1);
        }
        return word;
    }
}
