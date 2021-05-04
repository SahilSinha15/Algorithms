/*
 * Title: hw4_2.java
 * Abstract: This program reads the user's input and displays concurrent events.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 02/25/2021
 */
import java.util.*;

public class hw4_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nLines = scan.nextInt();
        Map<Integer,Integer> hourCounts = new HashMap<Integer,Integer>();
        scan.nextLine();
        for(int i=0;i<nLines;i++){
            String line = scan.nextLine();
            String[] nums = line.split(" ");
            int num1 = Integer.parseInt(nums[0]);
            int num2 = Integer.parseInt(nums[1]);
            for(int x=num1;x<num2;x++){
                hourCounts.putIfAbsent(x,0);
                int temp = hourCounts.get(x);
                hourCounts.put(x,temp+1);
            }
        }
        Collection<Integer> counts = hourCounts.values();
        int count= Collections.max(counts);
        System.out.print("Max events: "+count);
    }
}
