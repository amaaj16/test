package com.example.test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class LoginRequestAspect {


    private static final Logger log = LoggerFactory.getLogger(LoginRequestAspect.class);
    @Around("execution(* com.example.test.controller.*.*(..))")
    public ResponseEntity<?> log(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant startTime = Instant.now();
        ResponseEntity<?> response= (ResponseEntity<?>) joinPoint.proceed();
        Instant endTime = Instant.now();
        log.info("Request finish in {} milliseconds",Duration.between(startTime, endTime).toMillis());
        return response;
    }
}
