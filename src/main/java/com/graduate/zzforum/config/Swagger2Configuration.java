package com.graduate.zzforum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger2Configuration {
//    @Bean
//    public Docket createRestApi() {
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.graduate.zzforum"))
//                .paths(PathSelectors.any()).build();
//        return docket;
//    }
//    public ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                // 设置页面标题
//                .title("使用swagger2构建小程序后端api接口文档")
//                // 设置联系人
//                .contact(new Contact("IT人故事会", "http://idig8.com", "公众号：编程坑太多"))
//                // 描述
//                .description("欢迎访问接口文档")
//                // 定义版本号
//                .version("1.0").build();
//    }
}
