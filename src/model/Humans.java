package model;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 20.10.2016.
 */
public class Humans
{
    String namber;
    List<Human> listHum = new ArrayList<>();

    public String getNamber()
    {
        return namber;
    }

    public void setNamber(String namber)
    {
        this.namber = namber;
    }

    public List<Human> getListHum()
    {
        return listHum;
    }

    public void setListHum(List<Human> listHum) {
        this.listHum = listHum;
    }
}
