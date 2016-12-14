package view;

import model.Humans;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by Андрей on 09.11.2016.
 */
public class StartField extends JPanel {
    private StartView startView;

    public StartField(final StartView startView) {
        this.startView = startView;
        this.setLayout(null);

        JLabel nameOrg = new JLabel("Наименование организации");
        nameOrg.setLocation(25, 25);
        nameOrg.setSize(200, 25);
        final JTextField name = new JTextField();
        name.setLocation(25, 50);
        name.setSize(450, 25);

        JLabel adressOrg = new JLabel("Адресс");
        adressOrg.setLocation(25, 75);
        adressOrg.setSize(200, 25);
        final JTextField adress = new JTextField();
        adress.setLocation(25, 100);
        adress.setSize(450, 25);

        JLabel innOrg = new JLabel("ИНН организации");
        innOrg.setLocation(25, 125);
        innOrg.setSize(200, 25);
        final JTextField inn = new JTextField();
        inn.setLocation(25, 150);
        inn.setSize(450, 25);

        JLabel kppOrg = new JLabel("КПП организации");
        kppOrg.setLocation(25, 175);
        kppOrg.setSize(200, 25);
        final JTextField kpp = new JTextField();
        kpp.setLocation(25, 200);
        kpp.setSize(450, 25);

        add(kpp);
        add(kppOrg);

        add(adressOrg);
        add(adress);

        add(innOrg);
        add(inn);

        add(name);
        add(nameOrg);

        startView.setLayout(new BorderLayout());
        JButton ok = new JButton("Принять");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                startView.getController().createOrganization();
                startView.getController().getModel().getOrg().setName(name.getText());
                startView.getController().getModel().getOrg().setAdress(adress.getText());
                startView.getController().getModel().getOrg().setInn(inn.getText());
                startView.getController().getModel().getOrg().setKpp(kpp.getText());

                java.util.List<Humans> hum = new ArrayList<>();
                Humans h = new Humans();
                h.setNamber("11.2016");
                hum.add(h);
                startView.getController().getModel().getOrg().setList(hum);

                MainView mainView = new MainView(startView.getController());
                mainView.init();
                startView.dispose();
            }
        });
        ok.setLocation(385, 245);
        ok.setSize(90, 25);
        add(ok);

        JButton cancel = new JButton("Отмена");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cancel.setLocation(265, 245);
        cancel.setSize(90, 25);
        add(cancel);
    }
}
