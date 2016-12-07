package view;

import model.Human;
import model.Humans;
import model.Organization;

import javax.swing.*;
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

    public MainField(final MainView mainView) {
        this.mainView = mainView;
        this.setLayout(null);
        mainView.setLayout(new BorderLayout());

        JLabel labelorg = new JLabel("");
        labelorg.setText(mainView.getController().getModel().getOrg().getName());
        labelorg.setSize(150, 25);
        labelorg.setLocation(300, 25);
        add(labelorg);

        // список всех месяцев
        JComboBox comboBox = new JComboBox(mainView.getController().getModel().getItems());
        comboBox.setEnabled(true);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox) e.getSource();
                String item = (String) box.getSelectedItem();
            }
        });

        comboBox.setLocation(10, 25);
        comboBox.setSize(150, 25);
        add(comboBox);

        // кнопка добавляющая занятие
        JButton btnAddSess = new JButton("Занятия");
        btnAddSess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SessRedactorView(mainView.getController());
                mainView.setEnabled(false);
            }
        });
        btnAddSess.setLocation(350, 650);
        btnAddSess.setSize(90, 25);
        add(btnAddSess);

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
        JButton btnRemoveTab = new JButton("Удалить месяц");
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
        btnRemoveTab.setLocation(10, 125);
        btnRemoveTab.setSize(150, 25);
        add(btnRemoveTab);
    }
}
