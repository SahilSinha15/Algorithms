/*
 * Title: hw6_1.java
 * Abstract: This program reads the user's input data and
 *           implements quicksort using two strategies.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 12/03/2021
 */
import java.util.ArrayList;
import java.util.Scanner;

public class hw6_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String inputString = scan.nextLine();
        String[] elements = inputString.split(" ");
        ArrayList<Integer> nums = new ArrayList<>(n);
        ArrayList<Integer> clone = new ArrayList<>(n);

        for(String s : elements){
            nums.add(Integer.parseInt(s));
            clone.add(Integer.parseInt(s));
        }
        //---------------------------------Approach 1-------------------------------------
        int iPointer = 0;
        int jPointer = n-1;
        while(iPointer!=jPointer){
            if(nums.get(iPointer)<0){
                iPointer++;
            }
            if(nums.get(jPointer)>0){
                jPointer--;
            }
            if(iPointer>jPointer){
                break;
            }
            if(nums.get(iPointer)>0 && nums.get(jPointer)<0){
                int temp = nums.get(iPointer);
                nums.set(iPointer,nums.get(jPointer));
                nums.set(jPointer,temp);

            }
        }
        //---------------------------------Approach 2-------------------------------------
        int iPointer2=0;
        int jPointer2=0;

        while(jPointer2<n){

            if(clone.get(iPointer2)<0){
                iPointer2++;
            }
            else if(clone.get(iPointer2)>0 && clone.get(jPointer2)<0 && iPointer2<jPointer2){

                int temp = clone.get(iPointer2);
                clone.set(iPointer2,clone.get(jPointer2));
                clone.set(jPointer2,temp);
                iPointer2++;
                jPointer2++;
            }

            else{
                jPointer2++;
            }
            if(iPointer2>=n || jPointer2>=n){
                break;
            }


        }
        //--------------------------------------------------------------------------------
        for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i:clone){
            System.out.print(i+" ");
        }

    }
}
