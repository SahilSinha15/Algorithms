/*
 * Title: hw3_2.java
 * Abstract: This program reads the user's input data and
 *           converts a directed graph data from a user into a corresponding adjacency list format.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 02/17/2021
 */
import java.util.*;

public class hw3_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nVerts = scan.nextInt();
        int nEdges = scan.nextInt();
        scan.nextLine();
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();

        for(int i=0;i<nEdges;i++){
            String s1 = scan.nextLine();
            String[] s2 = s1.split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);

            if(map.containsKey(a)){
                ArrayList<Integer> temp = map.get(a);
                temp.add(b);
                Collections.sort(temp);
                map.replace(a,temp);
            }
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(b);
                map.put(a,temp);
            }
        }


        for(int i=0;i<nVerts;i++){

            ArrayList<Integer> temp = map.get(i);
            if(temp == null){
                System.out.println(i);
                continue;
            }
            else {
                System.out.print(i);
                for (int j = 0; j < (temp.size()); j++) {
                    System.out.print("->" + temp.get(j));
                }
                System.out.println();
            }
        }




    }
}
