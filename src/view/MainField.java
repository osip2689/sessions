package view;

import model.Human;
import model.Humans;
import model.MainTableModel;
import model.Organization;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Андрей on 09.11.2016.
 */
public class MainField extends JPanel {

    private MainView mainView;
    private MainTableModel tModel;
    private JTable jTable;
    private JTableHeader jTableHeader;
    private JButton btnAdd, btnRemoveTab;
    private ActionListener listenerAdd;

    public MainField(final MainView mainView) {
        this.mainView = mainView;
        setLayout(null);
        mainView.setLayout(new BorderLayout());

        JLabel labelorg = new JLabel("");
        labelorg.setSize(720, 25);
        labelorg.setLocation(300, 5);
        add(labelorg);

        // список всех месяцев
        JComboBox comboBox = new JComboBox(mainView.getController().getModel().getItems());
        comboBox.setEnabled(true);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox) e.getSource();
                String item = (String) box.getSelectedItem();
                labelorg.setText(mainView.getController().getModel().getOrg().getName() +
                        " | " + item);
                if (jTable != null) {
                    remove(jTable);
                }
                initTable(item);
            }
        });

        comboBox.setLocation(10, 30);
        comboBox.setSize(150, 25);
        add(comboBox);

        // кнопка добавляющая занятие
        JButton btnAddSess = new JButton("Занятия");
        btnAddSess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SessRedactorView(mainView.getController());
                //mainView.setEnabled(false);
            }
        });
        btnAddSess.setLocation(350, 660);
        btnAddSess.setSize(90, 25);
        add(btnAddSess);

        //кнопка добалвяющая человека
        btnAdd = new JButton("Добавить");
        btnAdd.setLocation(170, 660);
        btnAdd.setSize(90, 25);
        add(btnAdd);

        //новый месяц: добавляется в лист организации новый (!пока)пустой месяц
        JButton btnAddTab = new JButton("Новый месяц");
        btnAddTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Organization org = mainView.getController().getModel().getOrg();
                Humans humans = new Humans();
                humans.setListHum(new ArrayList<Human>());
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM.yyyy");
                humans.setNamber(dateFormat.format(new Date()) + "");
                //проверяю есть ли месяц такой же месяц, если нет то добавляю
                if (!mainView.getController().getModel()
                        .checkListForHumans((ArrayList<Humans>) org.getList(), humans.getNamber())) {
                    mainView.getController().getModel().getOrg().getList().add(humans);
                    comboBox.addItem(humans.getNamber());
                }
            }
        });
        btnAddTab.setLocation(10, 75);
        btnAddTab.setSize(150, 25);
        add(btnAddTab);

        //соответсвенно удаление последнего месяца
        btnRemoveTab = new JButton("Удалить месяц");
        btnRemoveTab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Organization org = mainView.getController().getModel().getOrg();
                Humans humans = org.getList().get(org.getList().size() - 1);
                if (org.getList().size() > 0) {
                    mainView.getController().getModel().getOrg().getList().remove(humans);
                    comboBox.removeItem(humans.getNamber());
                }
            }
        });
        btnRemoveTab.setLocation(10, 120);
        btnRemoveTab.setSize(150, 25);
        add(btnRemoveTab);
    }

    //метод который рисует таблицу при выборе из списка
    public void initTable(String item) {
        for (Humans h : mainView.getController().getModel().getOrg().getList()) {
            if (h.getNamber().equals(item)) {
                tModel = new MainTableModel(h);
                jTable = new JTable(tModel);
                jTableHeader = jTable.getTableHeader();
                jTableHeader.setLocation(170, 30);
                jTableHeader.setVisible(true);
                jTableHeader.setSize(1080, 20);
                jTable.setSize(1080, 600);
                jTable.setVisible(true);
                jTable.setLocation(170, 50);
                add(jTable);
                add(jTableHeader);
                //назначаю кнопке добавить человека действие
                listenerAdd = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainView.getController().addHuman(h);
                        tModel.fireTableDataChanged();
                        tModel.fireTableStructureChanged();
                    }
                };
                btnAdd.addActionListener(listenerAdd);

                mainView.setMainField(this);
                tModel.fireTableStructureChanged();
            }
        }
    }

    public MainTableModel gettModel() {
        return tModel;
    }
}
