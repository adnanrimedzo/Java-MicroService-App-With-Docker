package org.exampledriven.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableZuulProxy
@EnableSwagger2
@SpringBootApplication
public class SpringCloudZuulExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulExampleApplication.class, args);
	}
}
