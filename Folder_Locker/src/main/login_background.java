package main;
import main.actions.LoginActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class login_background {
    public static JLabel loginBackground;
    public static JLabel lockCloseImage;
    public static JLabel loginImage;
    public static JButton loginButton;
    public static JButton cancleButton;
    public static JPasswordField passwordTextField;
    public static JLabel wrongPasswordMessage;



    public static void setMainBackground(){
        loginBackground=new JLabel();
        loginBackground.setSize(712,390);
        loginBackground.setLocation(0,0);
        loginBackground.setLayout(null);

        Main_Application.mainWindow.add(loginBackground);
        ImageIcon loginBackgroundIcon=new ImageIcon(Main_Application.class.getResource
                ("/resources/login.png"));
        loginBackground.setIcon(loginBackgroundIcon);

        setLockCloseImage();
        setMainLoginScreen();
        setLoginButton();
        setCancelButton();
        setPasswordTextField();
        LoginActions.setCancelButtonAction();
        LoginActions.setLoginButtonAction();
        setWrongPasswordMessage();
        loginByEnterKey();




    }
    public static void setLockCloseImage(){
        lockCloseImage=new JLabel();

        lockCloseImage.setLocation(230,20);
        lockCloseImage.setLayout(null);
        loginBackground.add(lockCloseImage);
        ImageIcon loginBackgrounfIcon=new ImageIcon(Main_Application.class.getResource
                ("/resources/lockclose.png"));
        lockCloseImage.setSize(loginBackgrounfIcon.getIconWidth(),loginBackgrounfIcon.getIconHeight());
        lockCloseImage.setIcon(loginBackgrounfIcon);


    }

    public static void setMainLoginScreen(){
        loginImage=new JLabel();

        loginImage.setLocation(107,206);
        loginImage.setLayout(null);
        loginBackground.add(loginImage);
        ImageIcon loginBackgrounfIcon=new ImageIcon(Main_Application.class.getResource
                ("/resources/login2.png"));
        loginImage.setSize(loginBackgrounfIcon.getIconWidth(),loginBackgrounfIcon.getIconHeight());
        loginImage.setIcon(loginBackgrounfIcon);


    }

    public static void setLoginButton(){
        loginButton=new JButton("Login");
        loginButton.setSize(80,20);
        loginButton.setLocation(260,97);
        loginButton.setBackground(new Color(204,204,204,255));
        loginImage.add(loginButton);
    }

    public static void setCancelButton(){
        cancleButton =new JButton("Cancel");
        cancleButton.setSize(80,20);
        cancleButton.setLocation(350,97);
        cancleButton.setBackground(new Color(204,204,204,255));
        loginImage.add(cancleButton);
    }

    public static void setPasswordTextField(){
        passwordTextField=new JPasswordField();
        passwordTextField.setLocation(50,61);
        passwordTextField.setSize(373,28);
        passwordTextField.setBackground(new Color(204,204,204,255));
        passwordTextField.setLayout(null);
        passwordTextField.setBorder(null);
        passwordTextField.setFont(new Font("Arial", Font.PLAIN,25));
        loginImage.add(passwordTextField);
    }

    public static void setWrongPasswordMessage(){
        wrongPasswordMessage=new JLabel("Wrong Password");
        wrongPasswordMessage.setSize(220,28);
        loginImage.add(wrongPasswordMessage);
        wrongPasswordMessage.setLocation(53,93);
        wrongPasswordMessage.setFont(new Font("Arial",Font.PLAIN,20));
        wrongPasswordMessage.setForeground(Color.RED);
        wrongPasswordMessage.setVisible(false);
    }

    public static void loginByEnterKey(){
        passwordTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int code=e.getKeyChar();
                if(code==10){
                    loginButton.doClick();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }



}
