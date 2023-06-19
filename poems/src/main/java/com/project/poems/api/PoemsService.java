package com.project.poems.api;

/**
 *  Сервис интерграции с PoemsDB
 */
public interface PoemsService {

    // TODO передалать под dto
    /**
     * Получение всех авторов
     *
     * @return json со всеми аторами
     */
    String getAllAuthors();
}
