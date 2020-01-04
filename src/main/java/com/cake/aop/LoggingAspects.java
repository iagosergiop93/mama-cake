package com.cake.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspects {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * This AOP annotation is used to parameterize pointcut expressions. This pointcut joins to all
     * joinpoints in the com.revature package and all of its subpackages.
     */
    @Pointcut("within(com.cake..*)")
    public void logAll() {}

    /**
     * Logs basic information when a method is invoked, before its execution is allowed. Information
     * logged includes the qualified name of the method invoked and the local time of its invocation.
     * The values of the input arguments are present as well for debugging purposes.
     */
    @Before("logAll()")
    public void logMethodStart(JoinPoint jp) {
        String methodSig = jp.getTarget().getClass().toString() + "." + jp.getSignature().getName();
        String argStr = Arrays.toString(jp.getArgs());
        logger.info("{} invoked at {}", methodSig, LocalTime.now());
        logger.info("Input arguments: {}", argStr);
    }

    /**
     * Logs basic information when a method successfully returns after. Information logged includes
     * the qualified name of the method invoked and the local time of its successful completion. The
     * value of the returned object is present as well for debugging purposes.
     */
    @AfterReturning(pointcut = "logAll()", returning = "rtrn")
    public void logMethodReturn(JoinPoint jp, Object rtrn) {
        String methodSig = jp.getTarget().getClass().toString() + "." + jp.getSignature().getName();
        logger.info("{} successfully returned at {}", methodSig, LocalTime.now());
        logger.info("Object returned: {}", rtrn);
    }

    /**
     * Logs basic information when a method throws any exception during its execution. Information
     * logged includes the qualified name of the method invoked and the local time when the exception
     * was thrown.
     */
    @AfterThrowing(pointcut = "logAll()", throwing = "e")
    public void errorOccurrence(JoinPoint jp, Exception e) {
        String methodSig = jp.getTarget().getClass().toString() + "." + jp.getSignature().getName();
        logger.info("{} thrown in method: {}", e.getMessage(), methodSig);
    }

}
