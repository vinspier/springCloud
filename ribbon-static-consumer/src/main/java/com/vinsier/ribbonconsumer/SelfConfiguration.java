package com.vinsier.ribbonconsumer;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * 静态维护服务列表配置类
 * */
public class SelfConfiguration {
    @Autowired
    IClientConfig iClientConfig;

    @Bean
    public IPing ping(IClientConfig iClientConfig){
        return new PingUrl();
    }

    @Bean
    public IRule rule(IClientConfig iClientConfig){
        return new AvailabilityFilteringRule();
    }

}
