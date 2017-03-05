package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static String[] arr = {"a", "1", "b", "2", "a2", "3", "b2", "4", "a1"};
    private static String[] sortedArr;

    public static void main(String[] args) {

        sortedArr = arr;
        Arrays.sort(sortedArr);
        getClosestStrings(arr, 2);
    }

    private static void getClosestStrings(String[] arr, int n) {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            String c = arr[i];
            indexList = getIndexList(i, n);
            System.out.print("The closest " + n + " items for " + c + " is ");
            for (int j = 0; j < indexList.size(); j++){
                int index = indexList.get(j);
                if (index != i){
                    System.out.print(sortedArr[index]);
                    System.out.print(" ");
                }

            }

            System.out.println();
        }
    }

    private static List<Integer> getIndexList(int index, int n){
        List<Integer> indexList = new ArrayList<>();
        int leftRange = 0;
        int rightRange = 0;
        if (n % 2 == 0){
            leftRange = (n + 1)/ 2;
            rightRange = (n + 1)/ 2;
        } else {
            leftRange = (n + 1)/ 2 - 1;
            rightRange = (n + 1)/ 2;
        }


        if (index - leftRange < 0){
            int diff = leftRange - index;
            leftRange = 0;
            rightRange = index + rightRange + diff;
        } else if (index + rightRange > (arr.length - 1)){
            int diff = rightRange + index - (arr.length - 1);
            rightRange = arr.length - 1;
            leftRange = index - leftRange - diff;

        } else {
            leftRange = index - leftRange;
            rightRange = index + rightRange;
        }

        for (int i = leftRange; i <= rightRange; i++){
            indexList.add(i);
        }

        return indexList;
    }

}
