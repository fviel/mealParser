package com.fviel.mealParser.meal.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTimeAspect {

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        Long startTime = System.currentTimeMillis();

        //executes the method
        Object result = joinPoint.proceed();

        Long executionTime = System.currentTimeMillis() - startTime;

        System.out.println("####" + joinPoint.getSignature() + " executed in " + executionTime + "ms");

        //returns the result of the method
        return result;
    }    
}
