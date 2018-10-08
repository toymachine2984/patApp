package app.comp.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger  {
    org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @Around("execution(* app.comp.controller.*.*(..)) || execution(* app.comp.service.*.*(..))"
            + "|| execution(* app.comp.dao.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        logger.info("execution time : " + executionTime);
        return proceed;
    }
}
