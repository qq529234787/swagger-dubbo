package com.deepoove.dubbo.provider.springboot;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.deepoove.swagger.dubbo.annotations.EnableDubboSwagger;

@Configuration
//@ImportResource({ "classpath:dubbo/*.xml" })
//@PropertySource("classpath:swagger-dubbo.properties")
@DubboComponentScan(basePackages = { "com.deepoove.dubbo.provider.springboot" })
@EnableDubboSwagger
public class DubboConfig {

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-example-app");
        applicationConfig.setOwner("Sayi");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://172.24.4.141:2181");// TODO
        registryConfig.setClient("curator");
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(29880);
        return protocol;
    }

}
