package main.util;

import main.modell.LockedListModel;
import main.modell.PasswordModel;
import main.modell.RecentListModel;

import java.io.*;
import java.util.List;

public class FileOperations {

    public static String getPasswordFromFileForLogin(){
        try{
            File passwordFile=new File("C:/ProtectedFolderApp/password.log");
            if(passwordFile.exists()){
                ObjectInputStream instream=new ObjectInputStream(new FileInputStream(passwordFile));
                PasswordModel passwordModel=(PasswordModel) instream.readObject();
                return passwordModel.getPassword();

            }else{
                passwordFile.createNewFile();
                PasswordModel passwordModel=new PasswordModel("abc");
                ObjectOutputStream outstream=new ObjectOutputStream(new FileOutputStream(passwordFile));
                outstream.writeObject(passwordModel);
                return passwordModel.getPassword();
            }
        }catch(Exception e){
            e.printStackTrace();

        }
        return null;
    }
    public static Boolean isValidFile(String filePath){
        if(filePath==null || filePath.isEmpty()){
            return false;
        }
        File file =new File(filePath);
        if (file.exists() && !file.isDirectory()){
            return true;
        }
        return false;
    }

    public static void checkApplicationDirectory(){
        try{
            File appDir=new File("C:/ProtectedFolderApp");
            if(!appDir.exists()){
                appDir.mkdir();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveLockedListData(List<String> lockedList){
        ObjectOutputStream outStream = null;
        try{
            File lockedFile=new File("C:/ProtectedFolderApp/lockedFiles.log");
            if(lockedFile.exists()){
                LockedListModel lockedListModel=new LockedListModel(lockedList);
                outStream=new ObjectOutputStream(new FileOutputStream(lockedFile));
                outStream.writeObject(lockedListModel);

            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(outStream != null){
                try{
                    outStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static LockedListModel getLockedListData() {
        ObjectOutputStream outStream = null;
        ObjectInputStream inStream=null;
        try {
            File lockedFile = new File("C:/ProtectedFolderApp/lockedFiles.log");
            if (!lockedFile.exists()) {
                lockedFile.createNewFile();
                LockedListModel lockedListModel = new LockedListModel();
                outStream = new ObjectOutputStream(new FileOutputStream(lockedFile));
                outStream.writeObject(lockedListModel);
                return lockedListModel;

            }else{
                inStream=new ObjectInputStream(new FileInputStream(lockedFile));
                LockedListModel lockedListModel=(LockedListModel) inStream.readObject();
                return lockedListModel;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(inStream !=null){
                try{
                    inStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static RecentListModel getRecentListData() {
        ObjectOutputStream outStream = null;
        ObjectInputStream inStream=null;
        try {
            File recentFile = new File("C:/ProtectedFolderApp/recentFiles.log");
            if (!recentFile.exists()) {
                recentFile.createNewFile();
                RecentListModel recentListModel = new RecentListModel();
                outStream = new ObjectOutputStream(new FileOutputStream(recentFile));
                outStream.writeObject(recentListModel);
                return recentListModel;

            }else{
                inStream=new ObjectInputStream(new FileInputStream(recentFile));
                RecentListModel recentListModel=(RecentListModel) inStream.readObject();
                return recentListModel;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(inStream !=null){
                try{
                    inStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void saveRecentListData(List<String> lockedList){
        ObjectOutputStream outStream = null;
        try{
            File recentFile=new File("C:/ProtectedFolderApp/lockedFiles.log");
            if(recentFile.exists()){
                RecentListModel recentListModel=new RecentListModel(lockedList);
                outStream=new ObjectOutputStream(new FileOutputStream(recentFile));
                outStream.writeObject(recentListModel);

            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(outStream != null){
                try{
                    outStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
