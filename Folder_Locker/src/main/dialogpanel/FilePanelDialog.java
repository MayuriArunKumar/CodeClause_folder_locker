package main.dialogpanel;

import main.actions.FileExplorerThread;
import main.actions.FilePanelDialogActions;
import main.util.FileExplorer;
import main.util.RecentDataList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FilePanelDialog {
    public JDialog filePanelDialog;
    public JLabel recentPanelHeading;
    public JLabel recentFilePanel;

     public DefaultTableModel recentTableModel;
     public JTable recentTable;

     public JLabel locklistPanelHeading;
     public JLabel lockListPanel;
     public DefaultTableModel lockListTabelModel;
     public JTable lockListTabel;

     public JButton addButton;
     public JButton removeButton;
     public JButton okButton;
     public JButton cancelButton;
     public JLabel fileExplorerPanel;
     public JLabel loaderLabel;
     public JButton clearutton;
     public JTree fileSystemTree;

    public FilePanelDialog(){
        filePanelDialog=new JDialog();
        filePanelDialog.setSize(720,435);
        filePanelDialog.setTitle("Add Files and Folders");
        Dimension dimension= Toolkit.getDefaultToolkit().getScreenSize();
        int x=dimension.width/2- filePanelDialog.getWidth()/2;
        int y= dimension.height/2- filePanelDialog.getHeight()/2;
        filePanelDialog.setLocation(x,y);
        filePanelDialog.setLayout(null);
        filePanelDialog.setAlwaysOnTop(true);
        filePanelDialog.setResizable(false);
        filePanelDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        setRecentPanelHeading();
        setRecentFilePanel();
        setRecentTabel();
        populateRecentTable();
        setLocklistPanelHeading();
        setLockListPanel();
        setLockListTabel();
        setAddButton();
        FilePanelDialogActions.setAddButtonAction(this);
        setRemoveButton();
        FilePanelDialogActions.setRemoveButtonAction(this);
        setOkButton();
        FilePanelDialogActions.setOkButtonAction(this);
        setCancelButton();
        FilePanelDialogActions.setCancelButtonAction(this);
        setFileExplorerPanel();
        setFileSystem();
        setLoaderLabel();
        setClearButton();
        FilePanelDialogActions.setClearButtonAction(this);

        filePanelDialog.setVisible(true);

    }

    public void setRecentPanelHeading(){
        recentPanelHeading=new JLabel("Recent Unlocked Files");
        filePanelDialog.add(recentPanelHeading);
        recentPanelHeading.setSize(200,30);
        recentPanelHeading.setLocation(10,10);
    }

    public void setRecentFilePanel(){
        recentFilePanel=new JLabel();
        recentFilePanel.setSize(250,100);
        recentFilePanel.setLocation(10,40);
        recentFilePanel.setLayout(null);
        recentFilePanel.setBackground(new Color(250,255,255,255));
        recentFilePanel.setOpaque(true);
        recentFilePanel.setBorder(new LineBorder(new Color(10,10,10),1));
        filePanelDialog.add(recentFilePanel);
    }

    public void setRecentTabel(){
        recentTableModel=new DefaultTableModel();
        recentTableModel.addColumn("Recent Files");


        recentTable=new JTable(recentTableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane scrollPane=new JScrollPane(recentTable);
        scrollPane.setSize(244,94);
        scrollPane.setLocation(3,3);
        recentFilePanel.add(scrollPane);

        recentTable.setBackground(new Color(250,255,255,255));
        recentTable.setRowHeight(20);
        recentTable.getTableHeader().setReorderingAllowed(false);
        recentTable.getTableHeader().getColumnModel().getColumn(0).setResizable(false);

        recentTable.setShowVerticalLines(false);
        recentTable.setFocusable(false);
        scrollPane.setViewportBorder(new LineBorder(new Color(200,200,200),1));
        scrollPane.getViewport().setBackground(new Color(250,255,255,255));



    }

    public void populateRecentTable(){
        for(String fileString:RecentDataList.getRecentFiles()){
            recentTableModel.addRow(new Object[]{fileString});
        }
    }

    public void setLocklistPanelHeading(){
        locklistPanelHeading=new JLabel("Lock File Path");
        filePanelDialog.add(locklistPanelHeading);
        locklistPanelHeading.setSize(200,30);
        locklistPanelHeading.setLocation(420,10);
    }

    public void setLockListPanel(){
        lockListPanel=new JLabel();
        lockListPanel.setSize(283,310);
        lockListPanel.setLocation(420,40);
        lockListPanel.setLayout(null);
        lockListPanel.setBackground(new Color(250,255,255,255));
        lockListPanel.setOpaque(true);
        lockListPanel.setBorder(new LineBorder(new Color(10,10,10),1));
        filePanelDialog.add(lockListPanel);
    }

    public void setLockListTabel(){
        lockListTabelModel=new DefaultTableModel();
        lockListTabelModel.addColumn("Lock File");


        lockListTabel=new JTable(lockListTabelModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane scrollPane=new JScrollPane(lockListTabel);
        scrollPane.setSize(277,304);
        scrollPane.setLocation(3,3);
        lockListPanel.add(scrollPane);

        lockListTabel.setBackground(new Color(250,255,255,255));
        lockListTabel.setRowHeight(30);
        lockListTabel.getTableHeader().setReorderingAllowed(false);
        lockListTabel.getTableHeader().getColumnModel().getColumn(0).setResizable(false);

        lockListTabel.setShowVerticalLines(false);
        lockListTabel.setFocusable(false);
        scrollPane.setViewportBorder(new LineBorder(new Color(200,200,200),1));
        scrollPane.getViewport().setBackground(new Color(250,255,255,255));



    }

    public void setAddButton(){
        addButton=new JButton("Add>>");
        addButton.setSize(100,35);
        addButton.setLocation(290,160);
        addButton.setBackground(new Color(250,255,255,255));
        addButton.setFocusable(false);
        filePanelDialog.add(addButton);
    }

    public void setRemoveButton(){
        removeButton=new JButton("Remove<<");
        removeButton.setSize(100,35);
        removeButton.setLocation(290,210);
        removeButton.setBackground(new Color(250,255,255,255));
        removeButton.setFocusable(false);
        filePanelDialog.add(removeButton);
    }
    public void setOkButton(){
        okButton=new JButton("Ok");
        okButton.setSize(100,35);
        okButton.setLocation(495,360);
        okButton.setBackground(new Color(250,255,255,255));
        okButton.setFocusable(false);
        filePanelDialog.add(okButton);
    }
    public void setCancelButton(){
        cancelButton=new JButton("Cancel");
        cancelButton.setSize(100,35);
        cancelButton.setLocation(600,360);
        cancelButton.setBackground(new Color(250,255,255,255));
        cancelButton.setFocusable(false);
        filePanelDialog.add(cancelButton);
    }

    public void setFileExplorerPanel(){
        fileExplorerPanel=new JLabel();
        fileExplorerPanel.setSize(250,200);
        fileExplorerPanel.setLocation(10,150);
        fileExplorerPanel.setLayout(null);
        fileExplorerPanel.setBackground(new Color(250,255,255,255));
        fileExplorerPanel.setOpaque(true);
        fileExplorerPanel.setBorder(new LineBorder(new Color(10,10,10),1));
        filePanelDialog.add(fileExplorerPanel);
    }
    public void setFileSystem(){
        FileExplorerThread fileExplorerThread=new FileExplorerThread(this);
        fileExplorerThread.start();
    }
    public void setLoaderLabel(){
        loaderLabel=new JLabel("Please Wait");
        fileExplorerPanel.add(loaderLabel);
        loaderLabel.setSize(200,30);
        loaderLabel.setLocation(80,60);
    }
    public void setClearButton(){
        clearutton=new JButton("Clear");
        clearutton.setSize(100,35);
        clearutton.setLocation(290,260);
        clearutton.setBackground(new Color(250,255,255,255));
        clearutton.setFocusable(false);
        filePanelDialog.add(clearutton);
    }
}
