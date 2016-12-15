package controller;


import model.Humans;

/**
 * Created by Андрей on 05.12.2016.
 */
public interface EventListener {

    // создание организации
    void createOrganization();

    //добавить ученика
    void addHuman(Humans h);

    //удалить ученика по номеру
    void removeHuman(Humans h, String s);

    //добавить занятие
    void addSession();

    //удалить занятие
    void removeSession();

    //скопировать учеников из предыдущей таблицы
    void copyLastTable(Humans h);
}
