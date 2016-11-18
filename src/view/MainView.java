package view;

import controller.Controller;

import javax.swing.*;

/**
 * Created by Андрей on 08.11.2016.
 */
public class MainView extends JFrame
{
    private Controller controller;

    public MainView(Controller controller)
    {
        this.controller = controller;
        controller.setMainView(this);
        init();
    }

    public void init()
    {
        add(new MainField(this));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("БД");
        setVisible(true);
    }

    public Controller getController()
    {
        return controller;
    }
}