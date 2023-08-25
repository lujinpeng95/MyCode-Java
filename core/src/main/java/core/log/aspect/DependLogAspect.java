package core.log.aspect;

import com.google.gson.Gson;
import core.log.annotation.DependLogAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 对第三方依赖服务调用的日志监控
 * */
@Aspect
@Component
public class DependLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(DependLogAspect.class);

    public static final Gson GSON = new Gson();

    @Value("${log.dependLog.enableRsp:false}")
    private boolean enableRsp;

    @Pointcut("@annotation(dependLogAnnotation)")
    public void pointcut(DependLogAnnotation dependLogAnnotation) {
    }

    @Around(value = "pointcut(dependLogAnnotation)", argNames = "joinPoint,dependLogAnnotation")
    public Object around(ProceedingJoinPoint joinPoint, DependLogAnnotation dependLogAnnotation) throws Throwable {
        long now = System.currentTimeMillis();

        String dependLogType = dependLogAnnotation.dependLogType().toString();
        String signature = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();
        String paramJsonStr = Objects.isNull(args) ? null : GSON.toJson(args);
        Object result;

        StringBuilder sb = new StringBuilder();
        sb.append("DependType[").append(dependLogType).append(']');
        sb.append(" PointCutSignature[").append(signature).append(']');
        sb.append(" Args[").append(paramJsonStr).append(']');

        try {
            result = joinPoint.proceed(args);
        } catch (Exception e) {
            long cost = System.currentTimeMillis() - now;
            sb.append(" Cost[").append(cost).append(']');
            LOGGER.error(sb.toString(), e);
            throw e;
        }
        long cost = System.currentTimeMillis() - now;
        sb.append(" Cost[").append(cost).append(']');
        if (enableRsp) {
            String rspJsonStr = Objects.isNull(result) ? null : GSON.toJson(result);
            sb.append(" Rsp[").append(rspJsonStr).append(']');
        }
        LOGGER.info(sb.toString());
        return result;
    }

}
