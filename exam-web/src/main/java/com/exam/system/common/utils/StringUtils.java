package com.exam.system.common.utils;

/**
 * @packageName：com.exam.system.common.utils
 * @desrciption: 字符串工具类
 * @author: gaowei
 * @date： 2017-11-17 17:03
 * @history: (version) author date desc
 */
public class StringUtils {

    public static final String EMPTY_STRING = "";
    public static final String BLANK_SPACE = " ";
    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";

    public StringUtils() {
    }

    public static boolean contains(String str, String searchStr) {
        if (str != null && searchStr != null) {
            return str.indexOf(searchStr) >= 0;
        } else {
            return false;
        }
    }

    public static boolean equals(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        } else {
            return str1.equals(str2);
        }
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        } else {
            return str1.equalsIgnoreCase(str2);
        }
    }

    public static int indexOf(String str, String searchStr) {
        return str != null && searchStr != null ? str.indexOf(searchStr) : -1;
    }

    public static int indexOf(String str, String searchStr, int startPos) {
        if (str != null && searchStr != null) {
            return searchStr.length() == 0 && startPos >= str.length() ? str.length() : str.indexOf(searchStr, startPos);
        } else {
            return -1;
        }
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String substring(String str, int start, int end) {
        if (str == null) {
            return null;
        } else {
            if (end < 0) {
                end += str.length();
            }

            if (start < 0) {
                start += str.length();
            }

            if (end > str.length()) {
                end = str.length();
            }

            if (start > end) {
                return "";
            } else {
                if (start < 0) {
                    start = 0;
                }

                if (end < 0) {
                    end = 0;
                }

                return str.substring(start, end);
            }
        }
    }

}
