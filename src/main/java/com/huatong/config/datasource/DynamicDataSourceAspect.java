package com.huatong.config.datasource;

import com.huatong.annotation.DynamicDatasource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

/**
 * Create By xzz on 2018/11/21
 */
@Aspect
@Component
@Order(0)
public class DynamicDataSourceAspect {


    /**
     * 选择数据源
     */
    @Before("@annotation(com.huatong.annotation.DynamicDatasource)")
    public void selectDataSource(JoinPoint point) {

        try {
            MethodSignature signature = (MethodSignature) point.getSignature();
            //获取当前方法的字节码对象
            Method method = signature.getMethod();
            //判断是否有DynamicDatasource注解
            if (method.isAnnotationPresent(DynamicDatasource.class)) {
                DynamicDatasource annotation = method.getAnnotation(DynamicDatasource.class);
                String key = annotation.value();
                DynamicDataSourceHolder.setKey(key);
                System.out.println("================选择dataSource的key：" + key + "=================");
            }
        } catch (Exception e) {
            System.out.println("============异常出现=================");
        }
    }

    /**
     * 清除数据源
     */
    @After("@annotation(com.huatong.annotation.DynamicDatasource)")
    public void removeDataSource() {
        DynamicDataSourceHolder.clear();
    }


}
