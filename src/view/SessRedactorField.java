package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Андрей on 10.11.2016.
 */
public class SessRedactorField extends JPanel
{
    public SessRedactorField(final SessRedactorView sessRedactorView)
    {
        setLayout(null);
        JButton btnSave = new JButton("Сохранить");
        btnSave.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                sessRedactorView.getController().getMainView().setEnabled(true);
                sessRedactorView.dispose();
            }
        });
        btnSave.setLocation(650, 530);
        btnSave.setSize(110, 25);
        add(btnSave);

        JButton btnAdd = new JButton("Добавить");
        btnAdd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        btnAdd.setLocation(50, 530);
        btnAdd.setSize(90, 25);
        add(btnAdd);
        JButton btnRemove = new JButton("Удалить");
        btnRemove.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        btnRemove.setLocation(150, 530);
        btnRemove.setSize(90, 25);
        add(btnRemove);
    }
}
