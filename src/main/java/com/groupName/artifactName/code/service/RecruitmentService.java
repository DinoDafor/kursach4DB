package com.groupName.artifactName.code.service;

import com.groupName.artifactName.code.models.Order;
import com.groupName.artifactName.code.models.Recruitment;

import java.util.List;

public interface RecruitmentService {

        /**
         * Создает нового дона
         * @param recruitment - дон для создания
         */

        void create(Recruitment recruitment);


        /**
         * Возвращает список всех имеющихся донов
         * @return список донов
         */

        List<Recruitment> readAll();


        /**
         * Возвращает дона по его ID
         * @param id - ID дона
         * @return - объект дона с заданным ID
         */

        Recruitment read(int id);


        /**
         * Обновляет дона с заданным ID,
         * в соответствии с переданным доном
         * @param recruitment - дон в соответсвии с которым нужно обновить данные
         * @param id - id дона которого нужно обновить
         * @return - true если данные были обновлены, иначе false
         */

        boolean update(Recruitment recruitment, int id);


        /**
         * Удаляет дона с заданным ID
         * @param id - id дона, которого нужно удалить
         * @return - true если дон был удален, иначе false
         */

        boolean delete(int id);

        boolean recruit(String family, Integer soldierId);



}
