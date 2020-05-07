package cn.springboot.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author zyw
 */
@MapperScan( value = "cn.springboot.cache.mapper" )
@SpringBootApplication
@EnableCaching
public class SpringBootCache01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCache01Application.class, args);
    }

}
