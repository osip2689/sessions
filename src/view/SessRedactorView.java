package view;

import controller.Controller;

import javax.swing.*;

/**
 * Created by Андрей on 10.11.2016.
 */
public class SessRedactorView extends JFrame
{
    private SessRedactorField field;
    private Controller controller;


    public SessRedactorView(Controller controller)
    {
        this.controller = controller;
        controller.setSessRedactorView(this);
        init();
    }

    public void init()
    {
        field = new SessRedactorField(this);
        add(field);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Редактор занятий");
        setVisible(true);
    }

    public Controller getController()
    {
        return controller;
    }
}
