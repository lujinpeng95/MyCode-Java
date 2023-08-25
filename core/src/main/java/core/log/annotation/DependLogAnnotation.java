package core.log.annotation;


import core.log.enums.DependLogType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志注解-添加在需要输出日志的依赖方法上
 * DependLogType：依赖的服务类型枚举
 * */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DependLogAnnotation {
    DependLogType dependLogType();
}
