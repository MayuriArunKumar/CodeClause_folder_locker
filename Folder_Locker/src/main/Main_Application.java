package main;
import main.dialogpanel.FilePanelDialog;
import main.util.FileOperations;
import main.util.LockedFileDataList;
import main.util.RecentDataList;

import javax.swing.*;
import java.awt.*;

public class Main_Application {

    public static JFrame mainWindow;

    public static void main(String ag[]) {
        mainWindow=new JFrame("Folder Locker");
        mainWindow.setSize(720,422);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        Dimension dimension= Toolkit.getDefaultToolkit().getScreenSize();
        int x=dimension.width/2- mainWindow.getWidth()/2;
        int y= dimension.height/2- mainWindow.getHeight()/2;
        mainWindow.setLocation(x,y);

        mainWindow.setLayout(null);

        login_background.setMainBackground();

        MainPage.setMainPage();

        FileOperations.checkApplicationDirectory();

        RecentDataList.poplateRecentFileData();

        LockedFileDataList.populateLockedFileData();

        mainWindow.setVisible(true);


    }
}
