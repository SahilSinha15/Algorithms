/*
 * Title: hw1_1.java
 * Abstract: This program reads the user's input data and
 *           finds the uncommon elements from two lists of integers.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 02/03/2021
 */
import java.util.Scanner;

public class hw1_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1,n2;
        int flag=0;
        n1=scan.nextInt();
        int[] ar1 = new int[n1];
        for(int i=0;i<n1;i++){
            ar1[i]=scan.nextInt();
        }
        n2=scan.nextInt();
        int[] ar2 = new int[n2];
        for(int i=0;i<n2;i++){
            ar2[i]=scan.nextInt();
        }
        int[] uncommon = new int[n1+n2];
        int uncommonNum = 0;

        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(ar1[i]==ar2[j]){
                    flag=1;
                }
            }
            if(flag==1){
                flag=0;
                continue;
            }
            else if(flag==0){
                uncommon[uncommonNum]=ar1[i];
                uncommonNum+=1;
            }
        }
        for(int i=0;i<n2;i++){
            for(int j=0;j<n1;j++){
                if(ar2[i]==ar1[j]){
                    flag=1;
                }
            }
            if(flag==1){
                flag=0;
                continue;
            }
            else if(flag==0){
                uncommon[uncommonNum]=ar2[i];
                uncommonNum+=1;
            }
        }


        for(int i=1;i<uncommonNum;i++){
            int num= uncommon[i];
            int j = i-1;
            while(j>=0 && uncommon[j]<num){
                    uncommon[j+1]=uncommon[j];
                    j-=1;
            }
            uncommon[j+1]=num;
        }


        System.out.print("Answer:");
        if(uncommonNum!=0) {
            for (int i = 0; i < uncommonNum; i++) {
                System.out.print(" ");
                System.out.print(uncommon[i]);
            }
        }
        else{
            System.out.print("NONE");
        }
    }
}
