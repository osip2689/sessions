package view;

import model.SessTableModel;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Андрей on 10.11.2016.
 */
public class SessRedactorField extends JPanel
{
    private SessRedactorView sessRedactorView;
    private SessTableModel tModel;
    private JTable jTable;
    private JTableHeader jTableHeader;

    public SessRedactorField(final SessRedactorView sessRedactorView)
    {
        this.sessRedactorView = sessRedactorView;
        this.setLayout(null);
        sessRedactorView.setLayout(new BorderLayout());
        tModel = new SessTableModel(sessRedactorView.getController().getModel().getOrg());
        jTable = new JTable(tModel);
        jTableHeader = jTable.getTableHeader();
        jTableHeader.setLocation(50, 20);
        jTableHeader.setSize(700, 20);
        jTableHeader.setVisible(true);
        add(jTableHeader);
        jTable.setLocation(50, 40);
        jTable.setSize(700, 300);
        jTable.setVisible(true);
        add(jTable);
        JButton btnSave = new JButton("Сохранить");
        btnSave.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                sessRedactorView.getController().getMainView().getMainField().gettModel().fireTableStructureChanged();
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
                sessRedactorView.getController().addSession();
                //sessRedactorView.getController().addSessionForAll();
                tModel.fireTableDataChanged();
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
