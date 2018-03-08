package com.linjun.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataFilter {
    String userAlias() default "";
    String deptAlias() default  "";
    boolean self() default  true;
}
