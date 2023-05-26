package main.util;

import main.MainPage;
import main.modell.LockedListModel;

import java.util.ArrayList;
import java.util.List;

import static main.util.FileOperations.getLockedListData;

public class LockedFileDataList {

    public static List<String> LockedFiles=new ArrayList<>();

    public static void appendLockedFiles(List<String> files){
        if(files.size()==0){
            return;
        }
        LockedFiles.addAll(files);
        FileOperations.saveLockedListData(LockedFiles);

    }

    public static void populateLockedFileData(){
        LockedListModel lockedListModel= getLockedListData();
        if(lockedListModel == null || lockedListModel.getLockedList()==null|| lockedListModel.getLockedList().size()==0){
            return;
        }
        LockedFiles.addAll(lockedListModel.getLockedList());
        for(String data:LockedFiles){
            MainPage.tableModel.addRow(new Object[]{data,"Active"});
        }
    }

    public static void removedLockedFiles(List<String> files){
        if(files.size()==0){
            return;
        }
        LockedFiles.removeAll(files);
        FileOperations.saveLockedListData(LockedFiles);

    }
}
