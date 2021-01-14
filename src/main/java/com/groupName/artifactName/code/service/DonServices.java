package com.groupName.artifactName.code.service;

import com.groupName.artifactName.code.models.Don;

import java.util.List;

public interface DonServices {


    /**
     * Создает нового дона
     * @param don - дон для создания
     */

    void create(Don don);


    /**
     * Возвращает список всех имеющихся донов
     * @return список донов
     */

    List<Don> readAll();


    /**
     * Возвращает дона по его ID
     * @param id - ID дона
     * @return - объект дона с заданным ID
     */

    Don read(int id);


    /**
     * Обновляет дона с заданным ID,
     * в соответствии с переданным доном
     * @param don - дон в соответсвии с которым нужно обновить данные
     * @param id - id дона которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */

    boolean update(Don don, int id);


    /**
     * Удаляет дона с заданным ID
     * @param id - id дона, которого нужно удалить
     * @return - true если дон был удален, иначе false
     */

    boolean delete(int id);
}