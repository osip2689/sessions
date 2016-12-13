package model;

import javax.swing.table.AbstractTableModel;

/**
 * Created by Андрей on 08.12.2016.
 */
public class MainTableModel extends AbstractTableModel {
    private Organization organization;
    private Humans humans;

    public MainTableModel(Organization organization, Humans humans) {
        super();
        this.organization = organization;
        this.humans = humans;
    }

    @Override
    public int getRowCount() {
        return humans.getListHum().size();
    }

    @Override
    public int getColumnCount() {
        if (humans.getListHum().size() == 0) {
            return 2;
        } else
            return humans.getListHum().get(0).getListSess().size() + 2;
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (c) {
            case 0:
                return humans.getListHum().get(r).getId();
            case 1:
                return humans.getListHum().get(r).getName();
            default:
                return humans.getListHum().get(r).getListSess().get(c - 2).getCount();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Номер";
            case 1:
                return "ФИО";
            default:
                if (humans.getListHum().size() != 0) {
                    return organization.getList().get(0).getListHum().get(0).getListSess().get(column - 2).getName();
                } else return null;
        }
    }

    @Override
    public boolean isCellEditable(int r, int c) {
        switch (c) {
            case 0:
                return false;
            default:
                return true;
        }

    }


    @Override
    public void setValueAt(Object aValue, int r, int c) {
        switch (c) {
            case 0:
                humans.getListHum().get(r).setId((Integer) aValue);
                break;
            case 1:
                humans.getListHum().get(r).setName((String) aValue);
                break;
            default:
                humans.getListHum().get(r).getListSess().get(c - 2).setCount((String) aValue);
        }
    }

    public Humans getHumans() {
        return humans;
    }
}