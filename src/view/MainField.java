package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Андрей on 09.11.2016.
 */
public class MainField extends JPanel
{
    private MainView mainView;
    private String[] items = {
            "Элемент списка 1",
            "Элемент списка 2",
            "Элемент списка 3"
    };
    public MainField(final MainView mainView)
    {
        this.mainView = mainView;
        this.setLayout(null);
        mainView.setLayout(new BorderLayout());
        final JLabel label = new JLabel(" ");
        label.setSize(150,25);
        label.setLocation(100,100);
        add(label);
        JComboBox comboBox = new JComboBox(items);
        comboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JComboBox box = (JComboBox)e.getSource();
                String item = (String)box.getSelectedItem();
                label.setText(item);
            }
        });

        comboBox.setLocation(10,25);
        comboBox.setSize(150,25);
        add(comboBox);

        JButton btnAddSess = new JButton("Занятия");
        btnAddSess.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new SessRedactorView(mainView.getController());
                mainView.setEnabled(false);
            }
        });
        btnAddSess.setLocation(350, 650);
        btnAddSess.setSize(90,25);
        add(btnAddSess);
    }
}
