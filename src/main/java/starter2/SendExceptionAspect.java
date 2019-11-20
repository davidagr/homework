package starter2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SendExceptionAspect {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Sender sender;

    @Around("execution(* (@SendException *).*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        log.info("Aspect {} works", joinPoint.getSignature().toShortString());
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            sender.send(e.getClass().getSimpleName() + " : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
