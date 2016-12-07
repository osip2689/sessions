package model;


import java.util.ArrayList;

/**
 * Created by Андрей on 20.10.2016.
 */
public class Humans
{
    String namber;
    ArrayList<Human> listHum = new ArrayList<>();

    public String getNamber()
    {
        return namber;
    }

    public void setNamber(String namber)
    {
        this.namber = namber;
    }

    public ArrayList<Human> getListHum()
    {
        return listHum;
    }

    public void setListHum(ArrayList<Human> listHum)
    {
        this.listHum = listHum;
    }
}
