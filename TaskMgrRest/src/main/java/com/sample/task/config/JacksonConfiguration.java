/*
package com.assignment.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class JacksonConfiguration {

    @Autowired
    ObjectMapper mapper;

    private RequestMappingHandlerAdapter annotationMethodHandlerAdapter;

    @PostConstruct
    public void init() {
        List<HttpMessageConverter<?>> messageConverters = annotationMethodHandlerAdapter.getMessageConverters();
        for (HttpMessageConverter<?> messageConverter : messageConverters) {
            if (messageConverter instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter m = (MappingJackson2HttpMessageConverter) messageConverter;
                m.setObjectMapper(mapper);
            }
        }
    }

    @Autowired
    public void setAnnotationMethodHandlerAdapter(RequestMappingHandlerAdapter annotationMethodHandlerAdapter) {
        this.annotationMethodHandlerAdapter  = annotationMethodHandlerAdapter;
    }
}
*/
