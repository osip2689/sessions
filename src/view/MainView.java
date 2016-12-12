package view;

import controller.Controller;

import javax.swing.*;

/**
 * Created by Андрей on 08.11.2016.
 */
public class MainView extends JFrame {
    private Controller controller;
    private MainField mainField;

    public MainView(Controller controller) {
        this.controller = controller;
        controller.setMainView(this);
        init();
    }

    public void init() {
        mainField = new MainField(this);
        add(mainField);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("БД");
        setVisible(true);
    }

    public Controller getController() {
        return controller;
    }

    public MainField getMainField() {
        return mainField;
    }

    public void setMainField(MainField mainField) {
        this.mainField = mainField;
    }
}