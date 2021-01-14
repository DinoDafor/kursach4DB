package com.groupName.artifactName.code.service;

import com.groupName.artifactName.code.models.Order;

import java.util.List;

public interface OrderService {
    /**
     * Создает нового дона
     * @param order - дон для создания
     */

    void create(Order order);


    /**
     * Возвращает список всех имеющихся донов
     * @return список донов
     */

    List<Order> readAll();


    /**
     * Возвращает дона по его ID
     * @param id - ID дона
     * @return - объект дона с заданным ID
     */

    Order read(int id);


    /**
     * Обновляет дона с заданным ID,
     * в соответствии с переданным доном
     * @param order - дон в соответсвии с которым нужно обновить данные
     * @param id - id дона которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */

    boolean update(Order order, int id);


    /**
     * Удаляет дона с заданным ID
     * @param id - id дона, которого нужно удалить
     * @return - true если дон был удален, иначе false
     */

    boolean delete(int id);

    boolean giveOrder(String family, Integer orderID);

    String findFamilyByDon(Integer don);
}
