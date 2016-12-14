package view;

import controller.Controller;
import model.Humans;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Андрей on 14.12.2016.
 */
public class RemoveHumanView extends JFrame {
    private Controller controller;
    private ActionListener listener, listenerCancel;
    private Humans humans;

    public RemoveHumanView(Controller controller, Humans humans) {
        this.controller = controller;
        this.humans = humans;
        init();
    }

    public void init() {
        add(new Pane(this));
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setSize(255,175);
        setLocationRelativeTo(null);
        setTitle("Удалить ученика");
        setVisible(true);
    }

    public class Pane extends JPanel{
        private RemoveHumanView removeHumanView;

        public Pane(RemoveHumanView removeHumanView) {
            this.removeHumanView = removeHumanView;
            setLayout(null);
            removeHumanView.setLayout(new BorderLayout());

            //Надпись в окне удаления
            JLabel label = new JLabel("Выберите номер ученика");
            label.setLocation(25, 15);
            label.setSize(160, 25);
            add(label);

            //Поле куда вводится номер ученика
            JTextField textField = new JTextField();
            textField.setLocation(25, 45);
            textField.setSize(50, 25);
            add(textField);

            //кнопка применяющяя удаление
            JButton btnOk = new JButton("Принять");
            btnOk.removeActionListener(listener);
            listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.removeHuman(humans, textField.getText());
                    controller.getMainView().getMainField().gettModel().fireTableStructureChanged();
                    controller.getMainView().getMainField().gettModel().fireTableDataChanged();
                    controller.getMainView().setEnabled(true);
                    removeHumanView.dispose();

                }
            };
            btnOk.addActionListener(listener);
            btnOk.setLocation(25, 85);
            btnOk.setSize(90, 25);
            add(btnOk);

            //кнопка отменяющая вызов функции
            JButton btnCancel = new JButton("Отмена");
            btnCancel.removeActionListener(listenerCancel);
            listenerCancel = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.getMainView().getMainField().gettModel().fireTableStructureChanged();
                    controller.getMainView().getMainField().gettModel().fireTableDataChanged();
                    controller.getMainView().setEnabled(true);
                    removeHumanView.dispose();
                }
            };
            btnCancel.addActionListener(listenerCancel);
            btnCancel.setLocation(130, 85);
            btnCancel.setSize(90,25);
            add(btnCancel);

            setVisible(true);
        }
    }
}
