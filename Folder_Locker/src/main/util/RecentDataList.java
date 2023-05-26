package main.util;

import main.MainPage;
import main.modell.LockedListModel;
import main.modell.RecentListModel;

import java.util.ArrayList;
import java.util.List;

import static main.util.FileOperations.getLockedListData;

public class RecentDataList {

    public static List<String> recentFiles=new ArrayList<>();

    public static List<String> getRecentFiles(){
        return recentFiles;
    }

    public static void poplateRecentFileData(){
        RecentListModel recentListModel= FileOperations.getRecentListData();
        if(recentListModel == null || recentListModel.getRecentList()==null|| recentListModel.getRecentList().size()==0){
            return;
        }
        recentFiles.addAll(recentListModel.getRecentList());
    }

    public static void appendRecentFiles(List<String> files){
        if(files.size()==0){
            return;
        }
        recentFiles.addAll(files);
        FileOperations.saveRecentListData(recentFiles);

    }

}
