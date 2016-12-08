package model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 19.10.2016.
 */
public class Human
{
    private int id;
    private String name;
    private List<Session> listSess = new ArrayList<>();

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Session> getListSess()
    {
        return listSess;
    }

    public void setListSess(List<Session> listSess)
    {
        this.listSess = listSess;
    }
}
