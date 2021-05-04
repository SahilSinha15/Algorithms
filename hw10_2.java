/*
 * Title: hw9_2.java
 * Abstract: This program takes in user input and performs radix sort.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 4/26/2021
 */
import java.util.ArrayList;
import java.util.Scanner;

public class hw10_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int max=0;
        scan.nextLine();
        String numsStr = scan.nextLine();
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<ArrayList<Integer>> countBins = new ArrayList<>();
        String[] numbers = numsStr.split(" ");
        for(String s: numbers){
            nums.add(Integer.parseInt(s));
        }


        for(int tempN : nums){
            String temp = String.valueOf(tempN);
            char[] tempArr= temp.toCharArray();
            int tempDeg= tempArr.length;
            if(max<tempDeg){
                max=tempDeg;
            }

        }
        for(int i=0;i<10;i++){
            countBins.add(new ArrayList<>());
        }

        for(int j = max-1;j>=0;j--) {
            for (int tempN : nums) {
                int flag = 0;
                String temp = String.valueOf(tempN);
                for (int i = String.valueOf(tempN).length(); i < max; i++) {
                    flag = 1;
                    String temp2 = "0";
                    temp = temp2 + temp;
                }
                if (flag == 1) {
//                System.out.println(temp);
                } else {
                    temp = String.valueOf(tempN);
//                System.out.println(temp);
                }
                char[] charArr = temp.toCharArray();
                int countNum = Integer.parseInt(String.valueOf(charArr[j]));
//            System.out.println(countNum);
                countBins.get(countNum).add(Integer.parseInt(temp));
            }
            //---------------------------------------------------------------------------------------------------
//        System.out.println(countBins);
            nums = new ArrayList<>();
            for (ArrayList<Integer> arr : countBins) {
                for (int tempN : arr) {
                    nums.add(tempN);
                }
            }
            for(int a: nums ){
                System.out.print(a+" ");
            }
            System.out.println();
            countBins = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                countBins.add(new ArrayList<>());
            }
        }
    }
}
