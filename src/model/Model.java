package model;


import java.util.ArrayList;

/**
 * Created by Андрей on 20.10.2016.
 */
public class Model {
    private Organization org;

    public void createOrganization() {
        org = new Organization();
    }

    public Organization getOrg() {
        return org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }

    public String[] getItems() {
        int size = org.getList().size();
        if (size != 0) {
            String[] items = new String[size];
            for (int i = 0; i < size; i++) {
                items[i] = org.getList().get(i).getNamber();
            }
            return items;
        } else return new String[0];
    }

    public boolean checkListForHumans(ArrayList<Humans> list, String s) {
        for (Humans h : list) {
            if (h.getNamber().equals(s)) {
                return true;
            }
        }
        return false;
    }

    public void addHuman(Humans h) {
        Human human = new Human();
        human.setId(h.getListHum().size() + 1);
        if (org.getSessions().size() != 0) {
            human.setListSess(new ArrayList<Session>());
            for (int i = 0; i < org.getSessions().size(); i++) {
                human.getListSess().add(new Session());
                human.getListSess().get(i).setName(org.getSessions().get(i).getName());
                human.getListSess().get(i).setPrice(org.getSessions().get(i).getPrice());
            }
        }
        h.getListHum().add(human);
    }

    public void addSession() {
        /*for (int i = 0; i < org.getList().size(); i++)
        {
            for (int j = 0; j < org.getList().get(i).getListHum().size(); j++)
            {
                org.getList().get(i).getListHum().get(j).getListSess().add(new Session());
            }
        }
        org.setSessions(org.getList().get(0).getListHum().get(0).getListSess());*/
        for (Humans humans : org.getList()) {
            for (Human human : humans.getListHum()) {
                human.getListSess().add(new Session());
            }
        }
        org.setSessions(org.getList().get(0).getListHum().get(0).getListSess());
    }

    public void addSessionForAll() {
        Session session = org.getSessions().get(org.getSessions().size() - 1);
        for (Humans humans : org.getList()) {
            for (Human human : humans.getListHum()) {
                human.getListSess().add(session);
            }
        }
    }

    public void removeHumans(Humans h) {
    }
}
