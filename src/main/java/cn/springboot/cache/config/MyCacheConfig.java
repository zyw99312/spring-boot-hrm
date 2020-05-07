package cn.springboot.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zyw
 */
@Configuration
public class MyCacheConfig {
    @Bean("myGenerator")
    public KeyGenerator keyGenerator(){
        return (o, method, params) -> method.getName()+"["+ Arrays.asList(params).toString()+"]";
    }
}
