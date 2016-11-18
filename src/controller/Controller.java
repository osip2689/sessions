package controller;


import view.MainView;
import view.SessRedactorView;
import view.StartView;

/**
 * Created by Андрей on 19.10.2016.
 */
public class Controller
{
    private StartView startView;
    private MainView mainView;
    private SessRedactorView sessRedactorView;

    public Controller()
    {
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
}
