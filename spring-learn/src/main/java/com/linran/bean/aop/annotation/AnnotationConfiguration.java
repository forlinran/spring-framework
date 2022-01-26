package com.linran.bean.aop.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.linran.bean.aop.annotation"})
@EnableAspectJAutoProxy
public class AnnotationConfiguration {
}
