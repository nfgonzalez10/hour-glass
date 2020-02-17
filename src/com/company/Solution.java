package com.company;

import java.util.Scanner;
import java.util.Vector;

public class Solution {

  int[] vector = new int[9];
  int total = 0;
  boolean flagEnter= false;

  int searchHourGlass(int[][] array) {
    int n = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        if (i <= 3 && j <= 3) {
          for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
              addElementArray(n, array[k][l]);
              n++;
              if (n == 9) {
                n = 0;
                sumAllElementOfVector(vector);
              }
            }
          }
        }
      }
    }
    return total;
  }

  void sumAllElementOfVector(int[] subArray) {
    int subTotal = 0;
    for (int element = 0; element < subArray.length; element++) {
      if (element != 3 && element != 5) {
        subTotal += subArray[element];
      }
    }
    if (total == 0 && !flagEnter){
       flagEnter = true;
      total = subTotal;
    }
    if (total < subTotal) {
      total = subTotal;
    }
    subTotal = 0;
    vector = new int[9];

  }

  void addElementArray(int position, int element) {
    vector[position] = element;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int[][] arr = new int[6][6];

    for (int i = 0; i < 6; i++) {
      String[] arrRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 6; j++) {
        int arrItem = Integer.parseInt(arrRowItems[j]);
        arr[i][j] = arrItem;
      }
    }
    Solution solution = new Solution();
    int x = solution.searchHourGlass(arr);
    System.out.println("total" + x);
    scanner.close();
  }
}
