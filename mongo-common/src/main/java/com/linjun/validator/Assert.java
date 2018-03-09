package com.linjun.validator;

import com.linjun.utils.RRException;
import org.apache.commons.lang.StringUtils;

/**
 * @author 林俊
 * @create 2018/3/9.
 * @desc
 **/
public abstract class Assert {
    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new RRException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new RRException(message);
        }
    }
}
