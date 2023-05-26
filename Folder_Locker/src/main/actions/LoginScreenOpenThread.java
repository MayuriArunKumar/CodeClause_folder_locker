package main.actions;
import main.login_background;

public class LoginScreenOpenThread extends Thread{

    @Override
    public void run(){
        for (int i=1;i<=715;i++){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            login_background.loginBackground.setLocation(i,0);
        }
    }

}
