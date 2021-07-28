package com.topdent.swl.demo.config;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Blue_Sky 7/28/21
 */
@Data
@Component
@ConfigurationProperties("swagger")
@EnableOpenApi
public class SwaggerConfiguration {
    /**
     * 是否开启swagger，生产环境一般关闭，所以这里定义一个变量
     */
    private Boolean enable;

    /**
     * 项目应用名
     */
    private String applicationName;

    /**
     * 项目版本信息
     */
    private String applicationVersion;

    /**
     * 项目描述信息
     */
    private String applicationDescription;
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                // Define whether swagger is turned on, false is turned off, it can be controlled by variables, and it is turned off online
                .enable(enable)
                //Configure api document meta information
                .apiInfo(apiInfo())
                // Choose which interfaces to publish as swagger doc
                .select()
                //apis() controls which interfaces are exposed to swagger,
                // RequestHandlerSelectors.any() all exposed
                // RequestHandlerSelectors.basePackage("com.XXXX.*") specifies the package location
                // withMethodAnnotation(ApiOperation.class) is marked with this annotation ApiOperation
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(applicationName)
                .description(applicationDescription)
                .contact(new Contact("Blue-Sky","https://narutopden.github.io/portfolio.io","topdent@yahoo.com"))
                .version(applicationVersion)
                .build();
    }


}
