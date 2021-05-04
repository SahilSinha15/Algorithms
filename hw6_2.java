/*
 * Title: hw6_2.java
 * Abstract: This program reads the user's input data and
 *           implements Depth First Search on the graph and outputs the mark array.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 12/03/2021
 */
import java.util.ArrayList;
import java.util.Scanner;

public class hw6_2 {
    public static ArrayList<Integer> visited = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static ArrayList<Integer> markArr = new ArrayList<>();
    public static int count=0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int nVertices = scan.nextInt();
        for(int i=0;i<nVertices;i++){
            graph.add(new ArrayList<Integer>());
        }
        int nEdges = scan.nextInt();

        for(int i=0;i<nVertices;i++){
            markArr.add(0);
            visited.add(0);
        }
        scan.nextLine();
        for(int i=0;i<nEdges;i++){
            String tempStr = scan.nextLine();
            String[] nums = tempStr.split(" ");
            int num1=Integer.parseInt(nums[0]);
            int num2=Integer.parseInt(nums[1]);
            graph.get(num1).add(num2);
        }
        for(int i=0;i<nVertices;i++){
            if(visited.get(i)==0){
                dfs(i);
            }
        }
        for(int i=0;i<nVertices;i++){
            System.out.println("Mark["+(i)+"]:"+(markArr.get(i)+1));
        }
    }
    private static void dfs(int node){
        visited.set(node,1);
        markArr.set(node,count);
        count+=1;
        for(int i: graph.get(node)){
            if(visited.get(i)==0){
                dfs(i);
            }
        }
    }
}
