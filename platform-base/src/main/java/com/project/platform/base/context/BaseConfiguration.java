package com.project.platform.base.context;

import com.project.platform.base.bean.MessagesLoader;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.List;

@Configuration
public class BaseConfiguration {

    @Bean
    public MessagesLoader baseMessagesLoader() {
        List<String> messages = List.of("classpath:messages/base-messages");
        return new MessagesLoader(messages);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
