package controller;


import model.Humans;

/**
 * Created by Андрей on 05.12.2016.
 */
public interface EventListener {
    void createOrganization();
    void addHuman(Humans h);
    void addSession();
    void addSessionForAll();
}
