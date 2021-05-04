/*
 * Title: hw2_1.java
 * Abstract: This program reads the user's input data(two timestamps) and outputs the time passed between first and second timestamp.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 02/09/2021
 */
import java.util.ArrayList;
import java.util.Scanner;

public class hw2_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String t1 = scan.nextLine();
        String t2 = scan.nextLine();
        ArrayList<Integer> nums1 = new ArrayList<Integer>();
        ArrayList<Integer> nums2 = new ArrayList<Integer>();

        for(String s: t1.split(":")){
            nums1.add(Integer.parseInt(s));
        }
        for(String s: t2.split(":")){
            nums2.add(Integer.parseInt(s));
        }

        int num1Seconds=0,num2Seconds=0;

        num1Seconds+=(nums1.get(0)*60*60);
        num1Seconds+=(nums1.get(1)*60);
        num1Seconds+=(nums1.get(2));

        num2Seconds+=(nums2.get(0)*60*60);
        num2Seconds+=(nums2.get(1)*60);
        num2Seconds+=(nums2.get(2));


        int difference;
        int eqFlag=0;
        int twentyFourHours = 24*60*60;
        int outputSeconds=0;
        ArrayList<Integer> output = new ArrayList<Integer>();



        if(num1Seconds>num2Seconds){
            difference=num1Seconds-num2Seconds;
            outputSeconds=twentyFourHours-difference;
        }
        else if(num1Seconds<num2Seconds){
           difference=num2Seconds-num1Seconds;
           outputSeconds=difference;
        }
        else if(num1Seconds==num2Seconds){
            eqFlag=1;
        }

        output.add(outputSeconds/3600);
        outputSeconds-=((outputSeconds/3600)*3600);
        output.add(outputSeconds/60);
        outputSeconds-=((outputSeconds/60)*60);
        output.add(outputSeconds);

        System.out.printf("%02d:%02d:%02d",output.get(0),output.get(1),output.get(2));

    }

}
