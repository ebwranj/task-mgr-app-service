package com.sample.task.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


    @Configuration
    @EnableTransactionManagement
    @ComponentScans(value = { @ComponentScan("com.sample.task.*")})
    public class AppConfig {
        @Bean
        public LocalEntityManagerFactoryBean geEntityManagerFactoryBean() {
            LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
            factoryBean.setPersistenceUnitName("LOCAL_PERSISTENCE");
            return factoryBean;
        }
        @Bean
        public JpaTransactionManager geJpaTransactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(geEntityManagerFactoryBean().getObject());
            return transactionManager;
        }
       /* @Bean
        @Primary
        public ObjectMapper objectMapper() {
            ObjectMapper objectMapper = new ObjectMapper();

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            return objectMapper;
        }*/
    }

