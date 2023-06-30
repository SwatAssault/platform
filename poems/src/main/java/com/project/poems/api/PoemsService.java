package com.project.poems.api;

import com.project.poems.dto.AllAuthorsDTO;
import com.project.poems.dto.AuthorStats;
import com.project.poems.dto.AllPoemsTitles;

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

    /**
     * Получение всех поэм автора по его имени
     *
     * @param authorName имя автора
     * @return Коллекция названий поэм автора {@link AllPoemsTitles}
     */
    List<String> getAuthorTitles(String authorName);
}
