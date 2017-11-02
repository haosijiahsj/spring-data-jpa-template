package com.zzz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by hushengjun on 2017/9/14.
 * app
 */
@EntityScan({"com.zzz.domain"})
@EnableJpaRepositories({"com.zzz.dao"})
@EnableTransactionManagement
@Configuration
@EnableAutoConfiguration
@ImportResource({"classpath:config/applicationContext.xml"})
public class Application implements EmbeddedServletContainerCustomizer {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    private static final int WEB_PORT = 8080;

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(WEB_PORT);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("The Application of zzz-sample Started Successfully...");
    }

}
