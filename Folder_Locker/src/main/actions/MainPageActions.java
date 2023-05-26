package main.actions;

import main.MainPage;
import main.MainPage;
import main.dialogpanel.FilePanelDialog;
import main.util.ArrayManipulation;
import main.util.LockedFileDataList;
import main.util.RecentDataList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MainPageActions {

    public static void setAddButtonAction(){
        MainPage.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FilePanelDialog();
            }
        });
    }

    public static Boolean isRowAlreadyExist(String rowValue){
        Vector<Vector> data=MainPage.tableModel.getDataVector();
        for(Vector vectorValue:data){
            if(vectorValue.get(0).equals(rowValue)){
                return true;
            }
        }
        return false;
    }

    public static void setUnlockButtonAction(){
        MainPage.unlockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] rowIndexes= MainPage.table.getSelectedRows();
                if(rowIndexes.length==0){
                    return;
                }
                ArrayManipulation.reverseArrayOfInt(rowIndexes);
                List<String> dataList= new ArrayList<>();
                for(int rowNumber:rowIndexes){
                    String value=(String) MainPage.table.getValueAt(rowNumber,0);
                    dataList.add(value);
                    MainPage.tableModel.removeRow(rowNumber);
                }
                RecentDataList.appendRecentFiles(dataList);
                LockedFileDataList.removedLockedFiles(dataList);

            }
        });
    }
}
