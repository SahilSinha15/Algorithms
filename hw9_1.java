/*
 * Title: hw9_1.java
 * Abstract: This program reads the user's input data and
 *           implements Depth First Search and connect the disconnected graphs.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 4/14/2021
 */
import java.util.ArrayList;
import java.util.Scanner;

public class hw9_1 {
    public static ArrayList<Integer> visited = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static ArrayList<Integer> markArr = new ArrayList<>();
    public static int count=0;
    public static ArrayList<Integer> startNode = new ArrayList<>();
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
                startNode.add(i);
                dfs(i);
            }
        }
        if(startNode.size()==1){
            System.out.println("No new edge:");
        }
        else{
            for(int i=0;i<startNode.size()-1;i++){
                System.out.print("Edge: "+startNode.get(i)+"-"+startNode.get(i+1)+"\n");
            }
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
