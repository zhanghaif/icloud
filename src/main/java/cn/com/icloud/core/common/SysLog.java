package cn.com.icloud.core.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @className: SysLog.java
 * @description: 日志管理
 * @author zhanghaifeng
 * @dateTime 2019年3月25日 下午1:21:12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SysLog {

    String module();

    String action();

    String[] params() default {};
}
