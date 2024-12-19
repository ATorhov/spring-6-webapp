package com.example.spring6di.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware, BeanPostProcessor {

    public LifeCycleDemoBean() {
        System.out.println("## I'm in the LifeCycleDemoBean Constructor ##");
    }

    private String javaVer;

    @Value("${java.specification.version}")
    public void setJavaVer(String javaVer) {
        this.javaVer = javaVer;
        System.out.println("## 1 Properties Set. Java Ver: "+this.javaVer);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("## 2 BeanNameAware My Bean Name is : "+name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## 3 BeanFactoryAware - Bean factory has been set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## 4 ApplicationContextAware - Application has been set");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("## 5 PostConstruct - The post construct method has been called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## 6 AfterPropertiesSet - Populate Properties The LifeCycle has its property");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("## 7 PreDestroy - The pre-destroy method has been called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## 8 DisposableBean.destroy - The LifeCycle has been terminated");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("## PostProcessBeforeInitialization: "+beanName);

        if (bean instanceof LifeCycleDemoBean) {
            LifeCycleDemoBean lifeCycleDemoBean = (LifeCycleDemoBean) bean;
            System.out.println("Calling before init");
            lifeCycleDemoBean.beforeInit();
        }

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("## PostProcessAfterInitialization: "+beanName);
        if (bean instanceof LifeCycleDemoBean) {
            LifeCycleDemoBean lifeCycleDemoBean = (LifeCycleDemoBean) bean;
            System.out.println("Calling after init");
            lifeCycleDemoBean.afterInit();
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    public void beforeInit(){
        System.out.println("## Before Init - Called by Bean Post Processor");
    }

    public void afterInit(){
        System.out.println("## After Init - Called by Bean Post Processor");
    }
}
