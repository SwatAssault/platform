package com.project.platform.base.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Бин для загрузки ресурс бандлов с переводами
 * В любом месте (модуле) приложения можно
 * объявить "наследника" этого бина и загрузить бандлы
 * по специфическому пути
 */
@Component
@DependsOn({"messageSource"})
public class MessagesLoader {

    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;

    private final List<String> messages;

    public MessagesLoader(List<String> messages) {
        this.messages = messages;
    }

    @PostConstruct
    public void init() {
        messageSource.addBasenames(messages.toArray(String[]::new));
    }
}
