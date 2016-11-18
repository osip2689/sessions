package view;



import controller.Controller;

import javax.swing.*;

/**
 * Created by Андрей on 08.11.2016.
 */
public class StartView extends JFrame
{
    private Controller controller;

    public StartView(Controller controller)
    {

        this.controller = controller;
        init();
    }

    public void init()
    {
        add(new StartField(this));
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setSize(510,320);
        setLocationRelativeTo(null);
        setTitle("Настройки организации");
        setVisible(true);
    }

    public Controller getController()
    {
        return controller;
    }
}
