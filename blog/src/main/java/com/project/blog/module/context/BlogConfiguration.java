package com.project.blog.module.context;

import com.project.platform.base.bean.MessagesLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BlogConfiguration {

    @Bean
    public MessagesLoader blogMessagesLoader() {
        List<String> messages = List.of("classpath:messages/exceptions-messages");
        return new MessagesLoader(messages);
    }
}
