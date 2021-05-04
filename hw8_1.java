/*
 * Title: hw8_1.java
 * Abstract: This program reads the user's input data and reverse the number.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 7/04/2021
 */
import java.util.ArrayList;
import java.util.Scanner;

public class hw8_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inpStr = scan.nextLine();
        char [] inpCharArr =  inpStr.toCharArray();
        ArrayList<Character> charArr = new ArrayList<Character>();


        for(int i = inpCharArr.length-1;i>=0;i--){

            charArr.add(inpCharArr[i]);

        }
        while(Integer.parseInt(String.valueOf(charArr.get(0)))==0){
            charArr.remove(0);
        }

        for(Character c: charArr){
            System.out.print(c);
        }
    }
}
