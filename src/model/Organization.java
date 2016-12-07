package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 02.12.2016.
 */
public class Organization {
    private String name;
    private String adress;
    private String inn;
    private String kpp;

    private List<Humans> list = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public List<Humans> getList() {
        return list;
    }

    public void setList(List<Humans> list) {
        this.list = list;
    }
}
