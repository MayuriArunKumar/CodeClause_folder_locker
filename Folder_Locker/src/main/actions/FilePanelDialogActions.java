package main.actions;

import main.MainPage;
import main.dialogpanel.FilePanelDialog;
import main.util.ArrayManipulation;
import main.util.FileExplorer;
import main.util.FileOperations;
import main.util.LockedFileDataList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FilePanelDialogActions {

    public static void setAddButtonAction(FilePanelDialog dialogObject){
        dialogObject.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows;
                selectedRows = dialogObject.recentTable.getSelectedRows();
                for (int rowNumber:selectedRows) {

                    String rowValue=(String) dialogObject.recentTable.getValueAt(rowNumber,0);
                    if(FileOperations.isValidFile(rowValue)){
                        if(!isRowAlreadyExist(rowValue,dialogObject)){
                            dialogObject.lockListTabelModel.addRow(new Object[]{rowValue});
                        }
                    }

                }

                String filePath=FileExplorer.getSelectedFile();
                if(FileOperations.isValidFile(filePath)){
                    if(!isRowAlreadyExist(filePath,dialogObject)){
                        dialogObject.lockListTabelModel.addRow(new Object[]{filePath});
                    }
                }

            }
        });
    }

    public static Boolean isRowAlreadyExist(String rowValue, FilePanelDialog dialogObject){
        Vector<Vector> data=dialogObject.lockListTabelModel.getDataVector();
        for (Vector vectorValue : data){
            if(vectorValue.get(0).equals(rowValue)){
                return true;
            }
        }
        return false;
    }

    public static void setRemoveButtonAction(FilePanelDialog dialogObject){
        dialogObject.removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int[] rowIndexes= dialogObject.lockListTabel.getSelectedRows();
               if(rowIndexes.length==0){
                   return;
               }
               ArrayManipulation.reverseArrayOfInt(rowIndexes);
               for(int rowNumber:rowIndexes){
                   dialogObject.lockListTabelModel.removeRow(rowNumber);
               }
            }
        });
    }
    public static void setCancelButtonAction(FilePanelDialog dialogObject){
        dialogObject.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogObject.filePanelDialog.dispose();
            }
        });
    }

    public static void setClearButtonAction(FilePanelDialog dialogObject){
        dialogObject.clearutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogObject.recentTable.clearSelection();
                dialogObject.lockListTabel.clearSelection();
                if(dialogObject.fileSystemTree!=null){
                    FileExplorer.clearSelection(dialogObject.fileSystemTree);
                }
                dialogObject.fileSystemTree.clearSelection();
            }
        });
    }
    public static void setOkButtonAction(FilePanelDialog dialogObject){
        dialogObject.okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<Vector> dataVector=dialogObject.lockListTabelModel.getDataVector();
                List<String> files =new ArrayList<>();
                for(Vector data:dataVector){
                    System.out.println(data.get(0));
                    String value=data.get(0).toString();
                    if(!MainPageActions.isRowAlreadyExist(value)){
                        MainPage.tableModel.addRow(new Object[]{value,"Active"});
                        files.add(value);
                    }
                }
                LockedFileDataList.appendLockedFiles(files);
                dialogObject.filePanelDialog.dispose();
            }
        });
    }
}
