package main.actions;

import main.dialogpanel.FilePanelDialog;
import main.util.FileExplorer;

import javax.swing.*;

public class FileExplorerThread extends Thread{
    public FilePanelDialog filePanelDialog;
    public FileExplorerThread(FilePanelDialog filePanelDialog){
        this.filePanelDialog=filePanelDialog;

    }
    @Override
    public void run(){
        setFileSystem();
    }
    public void setFileSystem(){
        JScrollPane fileScrollPane= FileExplorer.getFileExplorerScrollPanel();
        filePanelDialog.fileExplorerPanel.add(fileScrollPane);
        filePanelDialog.loaderLabel.setVisible(false);
        fileScrollPane.setSize(250,200);
        fileScrollPane.setLocation(0,0);
        filePanelDialog.fileExplorerPanel.validate();
        JTree tree=(JTree)fileScrollPane.getViewport().getView();
        filePanelDialog.fileSystemTree=tree;
        FileExplorer.clearSelection(filePanelDialog.fileSystemTree);
    }
}
