package com.huatong.aop;
import com.huatong.annotation.DynamicDatasource;
import com.huatong.domain.Person;
import com.huatong.domain.Student;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

/**
 * Create By xzz on 2018/11/19
 */
@Component
@Aspect
public class DynamicDatasourceAspect {


    @Before("@annotation(com.huatong.annotation.DynamicDatasource)")
    public void beforeSwitchDS(JoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

    }



}
