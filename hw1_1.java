/*
 * Title: hw1_1.java
 * Abstract: This program reads the user's input data and
 *           finds the most occurring number and its frequency.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 02/03/2021
 */
import java.util.Scanner;
public class hw1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        if(n==0){
            System.exit(1);
        }
        int nums[] = new int[n];
        int uniqueNums[] = new int[n];
        int uniqueCount=0;
        int counts[] = new int[n];
        int flag=0;
        int tempCount=0;
        int maxCount=0;
        int maxIndex=0;
        for (int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        for (int i=0;i<n;i++) {
            for (int num : uniqueNums) {
                if (num == nums[i]) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                uniqueNums[uniqueCount] = nums[i];
                uniqueCount += 1;
            } else if (flag == 1) {
                flag = 0;
                continue;
            }
        }
        for(int i=0;i<uniqueNums.length;i++){
            for(int j=0;j<uniqueNums.length;j++){
                if(uniqueNums[i] == nums[j]){
                    tempCount+=1;
                }
            }
            counts[i]=tempCount;
            tempCount=0;
        }

        for(int i=0;i<uniqueCount;i++){
            if(maxCount<counts[i]){
                maxCount=counts[i];
                maxIndex=i;
            }
            if(maxCount==counts[i]){
                if(uniqueNums[i]>uniqueNums[maxIndex]) {
                    maxCount = counts[i];
                    maxIndex=i;
                }

            }
        }
        System.out.println("Number:"+uniqueNums[maxIndex]);
        System.out.println("Frequency:"+maxCount);
    }
}
