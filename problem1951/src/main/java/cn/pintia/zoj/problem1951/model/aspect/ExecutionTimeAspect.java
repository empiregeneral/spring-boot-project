package cn.pintia.zoj.problem1951.model.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    private static final Logger log = LoggerFactory.getLogger(ExecutionTimeAspect.class);

    @Around("@annotation(cn.pintia.zoj.problem1951.model.annonation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            Object result = joinPoint.proceed(); // 执行目标方法
            return result;
        } finally {
            long end = System.nanoTime();
            long durationMs = (end - start) / 1_000_000; // 纳秒转毫秒
            String methodName = joinPoint.getSignature().toShortString();
            log.info("Method {} executed in {} ms", methodName, durationMs);
        }
    }
}