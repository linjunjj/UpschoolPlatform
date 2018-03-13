package com.linjun.annotation;

import java.lang.annotation.*;

/**
 * @author 林俊
 * @create 2018/3/13.
 * @desc
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {

}
