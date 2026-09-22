package com.telusko.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitorAspect {
    private static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspect.class);
    @Around("execution(* com.telusko.spring_boot_rest.service.JobService.getJob(..))")
    public Object monitorTIme(ProceedingJoinPoint jp) throws Throwable {
        long start=System.currentTimeMillis();
        Object obj=jp.proceed();
        long end=System.currentTimeMillis();
        LOGGER.info("Time Taken: "+(end-start)+" milliseconds");
        return obj;
    }
}
