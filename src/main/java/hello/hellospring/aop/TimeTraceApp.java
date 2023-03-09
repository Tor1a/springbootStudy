package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceApp {
    @Around("execution(* hello.hellospring..*(..)) ")
    public Object excute(ProceedingJoinPoint joinPoint) throws Throwable{
        Long start =System.currentTimeMillis();
        System.out.println("START" + joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally {
            Long finish = System.currentTimeMillis();
            Long timeMs = finish -start;
            System.out.println("END" + joinPoint.toString()+ "" +timeMs + "ms");
        }


    }
}
