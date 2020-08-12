package com.zzl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Description:
 * Created by 乍暖还寒 on 2020/8/12 9:51
 * Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket getDocket(Environment environment){

        Profiles profiles = Profiles.of("dev");
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("404")
                .enable(flag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zzl.controller"))
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "乍寒还暖",
                "It helps you choose what to eat.",
                "1.0", "http://zl0810.com",
                new Contact("乍寒还暖", "http://zl0810.com", "zl_java@163.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }

}
