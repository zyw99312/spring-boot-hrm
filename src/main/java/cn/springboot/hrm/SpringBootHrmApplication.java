package cn.springboot.hrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author zyw
 */
@MapperScan(value = "cn.springboot.hrm.mapper")
@SpringBootApplication
@EnableCaching
public class SpringBootHrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHrmApplication.class, args);
    }

}
