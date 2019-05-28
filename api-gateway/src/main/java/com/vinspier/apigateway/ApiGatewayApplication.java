package com.vinspier.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
// 开启Zuul网关路由服务功能
@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {

	@Bean
	public MyFilter myFilter(){
		return new MyFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
