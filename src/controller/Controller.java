package controller;


import model.Humans;
import model.Model;
import view.MainView;
import view.SessRedactorView;
import view.StartView;

/**
 * Created by Андрей on 19.10.2016.
 */
public class Controller implements EventListener {
    private StartView startView;
    private MainView mainView;
    private SessRedactorView sessRedactorView;
    private Model model;

    public Controller() {
        model = new Model();
        startView = new StartView(this);
        startView.init();

    }

    public static void main(String[] args)
    {
        new Controller();
    }

    public StartView getStartView()
    {
        return startView;
    }

    public MainView getMainView()
    {
        return mainView;
    }

    public SessRedactorView getSessRedactorView()
    {
        return sessRedactorView;
    }

    public void setStartView(StartView startView)
    {
        this.startView = startView;
    }

    public void setMainView(MainView mainView)
    {
        this.mainView = mainView;
    }

    public void setSessRedactorView(SessRedactorView sessRedactorView)
    {
        this.sessRedactorView = sessRedactorView;
    }

    @Override
    public void createOrganization() {
        model.createOrganization();
    }

    @Override
    public void addHuman(Humans h) {
        model.addHuman(h);
    }

    @Override
    public void removeHuman(Humans h, String s) {
        model.removeHumans(h, s);
    }

    @Override
    public void addSession() {
        model.addSession();
    }

    public Model getModel() {
        return model;
    }
}
