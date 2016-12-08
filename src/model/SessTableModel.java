package model;

import javax.swing.table.AbstractTableModel;

/**
 * Created by Андрей on 08.12.2016.
 */
public class SessTableModel extends AbstractTableModel
{
    private Organization organization;

    public SessTableModel(Organization organization)
    {
        super();
        this.organization = organization;
    }

    @Override
    public int getRowCount()
    {
        if (organization.getSessions().size() != 0)
        {
            return organization.getSessions().size();
        } else return 0;
    }

    @Override
    public int getColumnCount()
    {
        return 2;
    }

    @Override
    public Object getValueAt(int r, int c)
    {
        if (organization.getSessions().size() != 0)
        {
            switch (c)
            {
                case 0:
                    return organization.getSessions().get(r).getName();
                case 1:
                    return organization.getSessions().get(r).getPrice();
                default:
                    return null;
            }
        } else return null;
    }

    @Override
    public boolean isCellEditable(int r, int c)
    {
        return true;
    }

    @Override
    public String getColumnName(int column)
    {
        switch (column)
        {
            case 0:
                return "Название";
            case 1:
                return "Цена";
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int r, int c)
    {
        switch (c)
        {
            case 0:
                organization.getSessions().get(r).setName((String) aValue);
                break;
            case 1:
                organization.getSessions().get(r).setPrice((String) aValue);
                break;
            default:
                break;
        }
    }
}
