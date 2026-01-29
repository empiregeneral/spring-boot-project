package cn.edu.hdu.acm.problem1629.model.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CombinationType {
    String value(); // Bit, Backtrace
}
