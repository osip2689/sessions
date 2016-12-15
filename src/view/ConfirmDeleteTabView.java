package view;

import controller.Controller;
import model.Humans;
import model.Organization;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Андрей on 15.12.2016.
 */
public class ConfirmDeleteTabView extends JFrame {
    private Controller controller;
    private ActionListener listener, listenerCancel;

    public ConfirmDeleteTabView(Controller controller) {
        this.controller = controller;
        init();
    }

    public void init(){
        add(new Pane(this));
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setSize(240,100);
        setLocationRelativeTo(null);
        setTitle("Удалить месяц");
        setVisible(true);
    }

    public class Pane extends JPanel {
        private ConfirmDeleteTabView confirmDeleteTabView;

        public Pane(ConfirmDeleteTabView confirmDeleteTabView) {
            this.confirmDeleteTabView = confirmDeleteTabView;
            setLayout(null);

            JLabel label = new JLabel("Подтвердите удаление");
            label.setLocation(20, 15);
            label.setSize(150,15);
            add(label);

            JButton btnOk = new JButton("Удалить");
            btnOk.removeActionListener(listener);
            listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Organization org = controller.getModel().getOrg();
                    Humans humans = org.getList().get(org.getList().size() - 1);
                    if (org.getList().size() > 0) {
                        controller.getModel().getOrg().getList().remove(humans);
                        controller.getMainView().getMainField().getComboBox().removeItem(humans.getNamber());
                    }
                    controller.getMainView().setEnabled(true);
                    confirmDeleteTabView.dispose();

                }
            };
            btnOk.addActionListener(listener);
            btnOk.setLocation(20, 40);
            btnOk.setSize(90, 25);
            add(btnOk);

            //кнопка отменяющая вызов функции
            JButton btnCancel = new JButton("Отмена");
            btnCancel.removeActionListener(listenerCancel);
            listenerCancel = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.getMainView().setEnabled(true);
                    confirmDeleteTabView.dispose();
                }
            };
            btnCancel.addActionListener(listenerCancel);
            btnCancel.setLocation(130, 40);
            btnCancel.setSize(90,25);
            add(btnCancel);

            setVisible(true);
        }
    }
}
