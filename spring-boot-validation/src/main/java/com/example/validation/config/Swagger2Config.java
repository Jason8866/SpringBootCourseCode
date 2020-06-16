package com.example.validation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author Zhicheng
 * @Description TODO
 * @Date 2020/6/16 11:21
 * @Version 1.0
 **/
@Configuration
@EnableSwagger2
//@EnableSwaggerBootstrapUI 官方监控UI需要删除这一句
public class Swagger2Config extends WebMvcConfigurationSupport {

   /* @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.validation"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot 培训教程")   //标题
                .description("示例API文档") //描述
                .termsOfServiceUrl("https://www.xprogrammer.net") //这里配置的是服务网站
                .contact(new Contact("Kevin Zhang", "https://www.xprogrammer.net", "goodman@example.com")) // 三个参数依次是姓名，个人网站，邮箱
                .version("1.0") //版本
                .build();
    }*/


   @Bean
   public Docket createRestApi() {
       return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
               .apis(RequestHandlerSelectors.basePackage("com.example.validation")).paths(PathSelectors.any()).build();
   }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/").setCachePeriod(0);
        // 解决静态资源无法访问

        //registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

        // 解决swagger无法访问

        //registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

        // 解决swagger的js文件无法访问

        //registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("RESTful APIs").version("1.0").build();
    }
}
