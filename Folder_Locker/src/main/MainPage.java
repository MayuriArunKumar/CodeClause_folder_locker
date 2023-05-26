package main;
import main.actions.MainPageActions;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainPage {

    public static JLabel mainGround;
    public static JLabel topGround;

    public static JButton topRight_topGround;

    public static JButton optionButton, supportButton;

    public static JLabel leftTopGroundImage;

    public static JLabel midGroundSupport;

    public static JLabel midGround;
    public static DefaultTableModel tableModel;
    public static JTable table;

    public static JLabel bottomGround;
    public static JButton registerButton;
    public static JButton addButton;
    public static JButton unlockButton;
    public static JButton exitButton;
    public static JButton addInnerButton;

    public static void setMainPage(){
        mainGround=new JLabel();
        mainGround.setSize(713,390 );
        mainGround.setBackground(Color.PINK);
        mainGround.setOpaque(true);
        mainGround.setLayout(null);
        Main_Application.mainWindow.add(mainGround);

        setTopGround();
        setTopRightButton();
        setOptionButton();
        setsupportButton();
        setLeftTopGroundImage();
        setMidGroundSupport();
        setMidGround();
        setTable();
        setBottomGround();
        setRegisterButton();
        setInnerButton();
        setAddButton();
        setUnlockButton();
        setExitButton();

        MainPageActions.setAddButtonAction();
        MainPageActions.setUnlockButtonAction();


    }

    public static void setTopGround(){
        topGround = new JLabel();
        topGround.setLayout(null);
        topGround.setLocation(0,0);
        topGround.setSize(713,40);
        topGround.setBackground(Color.GRAY);
        topGround.setOpaque(true);
        mainGround.add(topGround);



    }

    public static void setTopRightButton(){
        topRight_topGround=new JButton();
        topRight_topGround.setLayout(null);
        topRight_topGround.setLocation(450,7);
        topRight_topGround.setSize(230,25);
        topRight_topGround.setBackground(new Color(204,204,204,255));
        topRight_topGround.setEnabled(false);
        topGround.add(topRight_topGround);
    }

    public static void setOptionButton(){
        ImageIcon optionIcon=new ImageIcon(Main_Application.class.getResource("/resources/options.png"));
        optionButton=new JButton("Options",optionIcon);
        optionButton.setSize(100,15);
        optionButton.setLocation(10,5);
        optionButton.setBackground(Color.WHITE);
        optionButton.setFocusPainted(false);
        optionButton.setIconTextGap(10);
        optionButton.setFont(new Font("Arial",Font.PLAIN,12));
        topRight_topGround.add(optionButton);
    }

    public static void setsupportButton(){
        ImageIcon supportIcon=new ImageIcon(Main_Application.class.getResource("/resources/support.png"));
        supportButton=new JButton("Support",supportIcon);
        supportButton.setSize(100,15);
        supportButton.setLocation(120,5);
        supportButton.setBackground(Color.WHITE);
        supportButton.setFocusPainted(false);
        supportButton.setIconTextGap(10);
        supportButton.setFont(new Font("Arial",Font.PLAIN,12));
        topRight_topGround.add(supportButton);
    }

    public static void setLeftTopGroundImage(){
        ImageIcon leftTopGroundImageIcon=new ImageIcon(Main_Application.class.getResource("/Resources/lockopen.png"));
        leftTopGroundImage=new JLabel();
        leftTopGroundImage.setLayout(null);
        leftTopGroundImage.setLocation(10,0);
        leftTopGroundImage.setSize(leftTopGroundImageIcon.getIconWidth(),leftTopGroundImageIcon.getIconHeight());
        leftTopGroundImage.setIcon(leftTopGroundImageIcon);
        topGround.add(leftTopGroundImage);

    }

    public static void setMidGroundSupport(){
        midGroundSupport=new JLabel();
        midGroundSupport.setLocation(0,40);
        midGroundSupport.setSize(713,350);
        midGroundSupport.setBackground(new Color(233,239,236,255));
        midGroundSupport.setOpaque(true);
        midGroundSupport.setBorder(new LineBorder(new Color(10,10,10),3));
        midGroundSupport.setLayout(null);
        mainGround.add(midGroundSupport);
    }

    public static void setMidGround(){
        midGround=new JLabel();
        midGround.setLocation(3,3);
        midGround.setSize(707,284);
        midGround.setLayout(null);
        midGround.setBackground(Color.WHITE);
        midGround.setOpaque(true);
        midGroundSupport.add(midGround);
    }

    public static void setTable(){
        tableModel=new DefaultTableModel();
        tableModel.addColumn("File Path");
        tableModel.addColumn("Status");
        table=new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setSize(702,278);
        scrollPane.setLocation(3,3);
        midGround.add(scrollPane);

        table.setBackground(new Color(233,239,236,255));
        table.setRowHeight(38);
        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(480);
        table.setShowVerticalLines(false);
        table.setFocusable(false);



    }

    public static void setBottomGround(){
        bottomGround=new JLabel();
        bottomGround.setLocation(3,287);
        bottomGround.setSize(707,60);
        bottomGround.setLayout(null);
        bottomGround.setBackground(Color.GRAY);
        bottomGround.setOpaque(true);
        midGroundSupport.add(bottomGround);
    }

    public static void setRegisterButton(){
        registerButton=new JButton("Register");
        registerButton.setSize(100,30);
        registerButton.setLocation(10,17);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(63,187,73,255));
        registerButton.setFont(new Font("Arial", Font.BOLD,12));
        registerButton.setFocusable(false);
        bottomGround.add(registerButton);
    }

    public static void setAddButton(){
        addButton=new JButton();
        addButton.setSize(105,32);
        addButton.setLocation(300,15);
        addButton.setFocusable(false);
        ImageIcon buttonImage=new ImageIcon(Main_Application.class.getResource("/Resources/ADD.png"));
        addButton.setIcon(buttonImage);
        addButton.setContentAreaFilled(false);
        bottomGround.add(addButton);
    }

    public static void setUnlockButton() {
        unlockButton = new JButton();
        unlockButton.setSize(105, 32);
        unlockButton.setLocation(410, 15);
        unlockButton.setFocusable(false);
        ImageIcon buttonImage = new ImageIcon(Main_Application.class.getResource("/Resources/unlockImage.png"));
        unlockButton.setIcon(buttonImage);
        unlockButton.setContentAreaFilled(false);
        bottomGround.add(unlockButton);
    }

    public static void setExitButton() {
        exitButton = new JButton();
        exitButton.setSize(105, 32);
        exitButton.setLocation(580, 15);
        exitButton.setFocusable(false);
        ImageIcon buttonImage = new ImageIcon(Main_Application.class.getResource("/Resources/lockexit.png"));
        exitButton.setIcon(buttonImage);
        exitButton.setContentAreaFilled(false);
        bottomGround.add(exitButton);
    }

    public static void setInnerButton(){
        addInnerButton=new JButton();
        addInnerButton.setSize(50,30);
        addInnerButton.setLocation(350,17);
        addInnerButton.setFocusable(false);
        ImageIcon buttonImage=new ImageIcon(Main_Application.class.getResource("/Resources/combo.png"));
        addInnerButton.setIcon(buttonImage);
        addInnerButton.setContentAreaFilled(false);
        bottomGround.add(addInnerButton);
    }
}
