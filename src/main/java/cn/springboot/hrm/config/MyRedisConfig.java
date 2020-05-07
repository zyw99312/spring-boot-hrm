package cn.springboot.hrm.config;

import cn.springboot.hrm.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

/**
 * @author zyw
 */
@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<String, Object> adminRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        template.setDefaultSerializer(serializer);
        return template;
    }
/*    @Bean
    public RedisTemplate<Object, Department> deptRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Department> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Department> serializer = new Jackson2JsonRedisSerializer<>(Department.class);
        template.setDefaultSerializer(serializer);
        return template;
    }
    @Bean
    public RedisTemplate<Object, Position> posRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Position> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Position> serializer = new Jackson2JsonRedisSerializer<>(Position.class);
        template.setDefaultSerializer(serializer);
        return template;
    }
    @Bean
    public RedisTemplate<Object, Employees> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Employees> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employees> serializer = new Jackson2JsonRedisSerializer<>(Employees.class);
        template.setDefaultSerializer(serializer);
        return template;
    }*/

    @Bean
    public RedisCacheManager employeeRedisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration cacheConfiguration =
                RedisCacheConfiguration.defaultCacheConfig()
                        // 设置缓存过期时间为一天
                        .entryTtl(Duration.ofDays(1))
                        // 禁用缓存空值，不缓存null校验
                        //.disableCachingNullValues()
                        // 设置CacheManager的值序列化方式为json序列化，可加入@Class属性
                        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new
                                GenericJackson2JsonRedisSerializer()));
        // 设置默认的cache组件
        return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(cacheConfiguration).build();
    }
}
