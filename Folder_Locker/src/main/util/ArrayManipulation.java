package main.util;

public class ArrayManipulation {
    public static void reverseArrayOfInt(int[] rowIndexes){
        for(int i=0;i<rowIndexes.length/2;i++){
            int temp=rowIndexes[0];
            rowIndexes[0]=rowIndexes[rowIndexes.length-1-i];
            rowIndexes[rowIndexes.length-1-i]=temp;
        }
    }
}
