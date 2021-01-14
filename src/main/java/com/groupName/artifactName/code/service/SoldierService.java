package com.groupName.artifactName.code.service;



import com.groupName.artifactName.code.models.Soldier;

import java.util.List;

public interface SoldierService {
    /**
     * Создает нового дона
     * @param soldier - дон для создания
     */

    void create(Soldier soldier);


    /**
     * Возвращает список всех имеющихся донов
     * @return список донов
     */

    List<Soldier> readAll();


    /**
     * Возвращает дона по его ID
     * @param id - ID дона
     * @return - объект дона с заданным ID
     */

    Soldier read(int id);


    /**
     * Обновляет дона с заданным ID,
     * в соответствии с переданным доном
     * @param soldier - дон в соответсвии с которым нужно обновить данные
     * @param id - id дона которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */

    boolean update(Soldier soldier, int id);


    /**
     * Удаляет дона с заданным ID
     * @param id - id дона, которого нужно удалить
     * @return - true если дон был удален, иначе false
     */

    boolean delete(int id);
}
