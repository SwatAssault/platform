package com.project.poems.api;

import com.project.poems.dto.AllAuthorsDTO;
import com.project.poems.dto.AuthorStats;

import java.util.List;

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

    /**
     * Получение статистики по авторам
     *
     * @return Коллекция статистики по авторам {@link AuthorStats}
     */
    List<AuthorStats> getStatistics();
}
