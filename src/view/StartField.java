package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Андрей on 09.11.2016.
 */
public class StartField extends JPanel
{
    private StartView startView;


    public StartField(final StartView startView)
    {
        this.startView = startView;
        this.setLayout(null);
        startView.setLayout(new BorderLayout());
        JButton ok = new JButton("Принять");
        ok.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainView mainView = new MainView(startView.getController());
                mainView.init();
                startView.dispose();

            }
        });
        ok.setLocation(385,245);
        ok.setSize(90,25);
        add(ok);
        JButton cancel = new JButton("Отмена");
        cancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        cancel.setLocation(265,245);
        cancel.setSize(90,25);
        add(cancel);
    }
}
