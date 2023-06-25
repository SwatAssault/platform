package com.project.platform.base.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

/**
 * Базовый сервис
 * Несет в себе утилитарный функционал, который может
 * быть использован в любом месте приложения. Также задуман для
 * наследования любым сервисом на уровне бизнес логики
 */
@Service
@DependsOn({"messagesLoader"})
public abstract class BaseService {

    private static MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        BaseService.messageSource = messageSource;
    }

    /**
     * Получить проперти из ресурс бандла
     *
     * @param messageId id проперти
     * @param defaultValue значение по умолчанию. Будет использовано, если проперти по умолчанию не найдено
     * @return проперти
     */
    public static String getMessage(String messageId, String defaultValue) {
        return messageSource.getMessage(messageId, null, defaultValue, LocaleContextHolder.getLocale());
    }
}
