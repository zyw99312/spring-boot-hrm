package cn.springboot.cache;

import cn.springboot.cache.entity.Employee;
import cn.springboot.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootCache01ApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object,Employee> empRedisTemplate;

    @Test
    void contextLoads() {

        Employee empById = employeeMapper.queryById(1);
        System.out.println(empById);
    }
    @Test
    public void testRedis01(){
        //给Redis中保存数据
        //write
        //stringRedisTemplate.opsForValue().append("msg","钟友维19990312");
        //read
        //System.out.println(stringRedisTemplate.opsForValue().get("msg"));
        stringRedisTemplate.opsForList().leftPush("myList","钟");
        stringRedisTemplate.opsForList().leftPush("myList","友");
        stringRedisTemplate.opsForList().leftPush("myList","维");
    }

    @Test
    public void testRedis02(){
        Employee empById = employeeMapper.queryById(2);
        //redisTemplate.opsForValue().set("emp-01",empById);
        empRedisTemplate.opsForValue().set("emp-01",empById);
    }

}
