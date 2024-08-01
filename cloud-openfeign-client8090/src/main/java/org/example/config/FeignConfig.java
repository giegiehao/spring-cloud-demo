package org.example.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
//    @Bean
//    public Retryer retryer() {
//        // 初始间隔时间100ms，重试间隔时间最大1s，最多请求3次
//        return new Retryer.Default(100, 1, 3);
//    }

    @Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }
}
