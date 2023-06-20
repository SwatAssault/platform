package com.project.poems.api;

import com.project.poems.dto.AllAuthorsDTO;

/**
 *  Сервис интеграции с PoemsDB
 */
public interface PoemsService {

    /**
     * Получение всех авторов
     *
     * @return {@link AllAuthorsDTO}
     */
    AllAuthorsDTO getAllAuthors();
}
