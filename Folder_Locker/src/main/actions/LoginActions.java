package main.actions;
import main.login_background;
import main.util.FileOperations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginActions {

    public static void setCancelButtonAction(){
        login_background.cancleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }

        });

    }

    public static void setLoginButtonAction(){
        login_background.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                char passwordArray[]=login_background.passwordTextField.getPassword();
                String password=String.valueOf(passwordArray);
                if(password.equals(FileOperations.getPasswordFromFileForLogin())){
                    scrollLoginScreen();

                    login_background.wrongPasswordMessage.setVisible(false);
                }else{

                    login_background.wrongPasswordMessage.setVisible(true);
                }


            }
        });
    }
    public static void scrollLoginScreen(){
        LoginScreenOpenThread loginScreenOpenThread=new LoginScreenOpenThread();
        loginScreenOpenThread.start();
    }
}
