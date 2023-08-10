package com.patika.bean;

import com.patika.dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {
    @Bean(initMethod = "initialBeanMethod",destroyMethod = "destroyBeanMethod") // bean başlamadanönce ve bittikten sonra çalışacak methodları böyle belirtiyoruz.
    @Scope("singleton")
    //@Scope("request")
    //@Scope("session")
    public BeanDto beanDto(){
        return BeanDto.builder().id(0L).beanName("bean Adi").beanData("Bean Data").build();
    }
}
