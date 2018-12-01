package com.ys.autoconfigure.condition;


import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author HuaDong
 * @date 2018/12/1 21:04
 *
 * Java 系统属性 条件判断
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {

    /**
     * Java 系统属性名称
     * @return
     */
    String name();

    /**
     * Java 系统属性值
     * @return
     */
    String value();
}
