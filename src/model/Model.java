package model;


import java.util.ArrayList;

/**
 * Created by Андрей on 20.10.2016.
 */
public class Model
{
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

    public String[] getItems()
    {
        int size = org.getList().size();
        if (size != 0) {
            String[] items = new String[size];
            for (int i = 0; i < size; i++)
            {
                items[i] = org.getList().get(i).getNamber();
            }
            return items;
        }
        else return new String[0];
    }

    public boolean checkListForHumans(ArrayList<Humans> list, String s)
    {
        for (Humans h: list)
        {
            if (h.getNamber().equals(s))
            {
                return true;
            }
        }
        return false;
    }
}
