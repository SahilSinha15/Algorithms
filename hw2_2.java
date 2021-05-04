/*
 * Title: hw2_2.java
 * Abstract: This program reads the user's input data and
 *           outputs binary representation with respective elements according to binary representation.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 02/09/2021
 */
import java.util.ArrayList;
import java.util.Scanner;

public class hw2_2 {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int deg = scan.nextInt();
        if(deg==0){
            System.out.println("0:EMPTY");
            System.exit(1);
        }


        int n = (int) Math.pow(2,deg);
        scan.nextLine();
        String inputLine = scan.nextLine();
        String[] elems = inputLine.split(" ");


        for(int i=0;i<n;i++){
            String temp = Integer.toBinaryString(i);
            char[] tempArr = temp.toCharArray();
            if(temp.length()==deg){
                System.out.print(temp);
                System.out.print(":");

                for(int k=0;k<deg;k++){
                    int tt = tempArr[k];
                    if(tt==49){
                        System.out.print(elems[k]+" ");
                    }
                }

                System.out.println();

            }
            else{
                int zeros = deg-temp.length();
                String binNum = "";
                for(int j =0;j<zeros;j++){
                    binNum+="0";
                }
                binNum+=temp;
                System.out.print(binNum+":");
                char[] tempArr2 = binNum.toCharArray();

                if(temp.equals("0")){
                    System.out.println("EMPTY");
                    continue;
                }
                for(int k=0;k<deg;k++) {

                        int tt = tempArr2[k];
                        if (tt == 49) {
                            System.out.print(elems[k] + " ");
                        }
                    }
                    System.out.println();

            }
        }

    }
}
