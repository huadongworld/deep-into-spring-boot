package com.ys.autoconfigure.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * @author HuaDong
 * @date 2018/12/1 20:05
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLevelRepository
public @interface SecondLevelRepository {

    String value() default "";

}
