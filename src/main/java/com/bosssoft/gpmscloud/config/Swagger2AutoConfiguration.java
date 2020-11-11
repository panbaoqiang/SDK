package com.bosssoft.gpmscloud.config;

import com.bosssoft.gpmscloud.properties.Swagger2Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Swagger2AutoConfiguration
 * @Description:swagger2配置
 * @author: lindy
 * @date: 2019年3月8日 下午9:06:38
 * @version:V1.0
 */
@Configuration
@EnableSwagger2
@Profile("!prod")
@ConditionalOnProperty(name = "gpmscloud.swagger2.enable", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties({Swagger2Properties.class})
public class Swagger2AutoConfiguration {

    @Autowired
    private Swagger2Properties swagger2Properties;

    private static final String TOKEN = "access_token";

    private static final String TOKEN_VALUE = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidW5pdHktcmVzb3VyY2UiXSwidXNlclJlZ2lvbkNvZGVOb3ciOiIiLCJ1c2VyQWNjb3VudCI6ImFnZW5jeSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJzeXN0ZW1UeXBlIjoiMyIsInVzZXJUeXBlTm93IjoiMyIsInVzZXJOYW1lIjoi5Luj55CG5py65p6E55So5oi3IiwiZXhwIjoxNTU1MTYwMTgwLCJ1c2VySWQiOiIxMTExMTMiLCJqdGkiOiI3OGE4YzZjNi0xN2JmLTQ3MDItYjU5NS0xYTk1YTY4ZWUxY2QiLCJjbGllbnRfaWQiOiJncC1nYXRld2F5LWNlbnRlciJ9.OJ_CVfo-CBMUpkxPCuSdoOmmfHtg52-jEnDFXcCIS7PTrj0LMcgmDyNHZshhUABectWmgX_xqC73-hR2SzgNSnYTXZOeswSFzoG0RR5ZC2grMFzVhwFYSTtc5TDb0qsBjGYVtTcqecUMVcqcIC24b1NvTdUM_uScgR-tLckHMaZqF9WKlDY2KeXtXzBqnXK9z-C8Z11JrzOEzmXL3hFwQTArgshDPRVpvkny1hozoxRY5CzKHl_YPkphR8MGZYe-izDbBhA8lbaqzDcNy42E_-WZYyeMMsDGYjakGb_lBjVa0dgCd0qr3csFpPJzPmxysKDBR7boC5lcBBoryHxq6Q";

    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name(TOKEN).description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(true).defaultValue(TOKEN_VALUE).build();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(swagger2Properties.getBasePackage()))
                .paths(PathSelectors.any()).build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swagger2Properties.getTitle())
                .description(swagger2Properties.getDescription())
                .termsOfServiceUrl(swagger2Properties.getTermsOfServiceUrl())
                .contact(new Contact("", "", ""))
                .version(swagger2Properties.getVersion())
                .build();
    }


}
