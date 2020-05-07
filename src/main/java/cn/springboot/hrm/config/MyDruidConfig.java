package cn.springboot.hrm.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyw
 */
@Configuration
public class MyDruidConfig {

        @ConfigurationProperties(prefix = "spring.datasource")
        @Bean
        public DataSource druid(){
            return new DruidDataSource();
        }

        /**
         * 配置Druid的监控
         * 1、配置一个管理后台的Servlet
         * @return bean
         */
        @Bean
        public ServletRegistrationBean<StatViewServlet> statViewServlet(){
            ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
            Map<String,String> initParams = new HashMap<>(100);

            initParams.put("loginUsername","admin");
            initParams.put("loginPassword","123456");
            //为空就是默认允许所有访问
            initParams.put("allow","");
            // initParams.put("deny","192.168.15.21"); //拦截此ip登录

            bean.setInitParameters(initParams);
            return bean;
        }


        /**
         *
         2、配置一个web监控的filter
         */
        @Bean
        public FilterRegistrationBean<WebStatFilter> webStatFilter(){
            FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>();
            bean.setFilter(new WebStatFilter());

            Map<String,String> initParams = new HashMap<>(100);
            initParams.put("exclusions","*.js,*.css,/druid/*");

            bean.setInitParameters(initParams);

            bean.setUrlPatterns(Collections.singletonList("/*"));

            return  bean;
        }
    }
