package com.sephiroth.jpademo.base;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author: 吴占超
 * @Description: 缓存数据库管理器
 * @Date: Create in 09:27 2018/2/23
 * @Modified By:
 */
@Configuration
// 注解开启我们的项目支持缓存
@EnableCaching
public class RedisConfiguration {

    /**
     *  @Author: 吴占超
     *  @Description: 缓存管理器
     *  @Date:  09:32 2018/2/23
     *  @param redisTemplate
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }
}
