/*
 * Title: hw8_2.java
 * Abstract: This program reads the user's input data and implements topological sorting.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 7/04/2021
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
@SuppressWarnings("unchecked")

public class hw8_2 {
    public static ArrayList<Integer> visited = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static ArrayList<Integer> markArr = new ArrayList<>();
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int nVertices = scan.nextInt();
        for (int i = 0; i < nVertices; i++) {
            graph.add(new ArrayList<Integer>());
        }
        int nEdges = scan.nextInt();
        scan.nextLine();
        for(int i=0;i<nEdges;i++){
            String tempStr = scan.nextLine();
            String[] nums = tempStr.split(" ");
            int num1=Integer.parseInt(nums[0]);
            int num2=Integer.parseInt(nums[1]);
            graph.get(num1).add(num2);
        }
        ArrayList<Integer> inOrder = new ArrayList<>();
        for(int i=0;i<nVertices;i++){
            int temp = 0;
            System.out.print("In-degree["+i+"]:");
            for(ArrayList<Integer> tempArr : graph ){
                for(int n : tempArr){
                    if(n==i){
                        temp++;
                    }
                }
            }
            inOrder.add(temp);
            System.out.print(temp);
            System.out.println();
        }
        int visited =0;
        Queue<Integer> queue = new ArrayDeque();
        for(int i=0;i<nVertices;i++){
            if(inOrder.get(i)==0){
                queue.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()){
            int temp = queue.remove();
            topo.add(temp);
            visited++;
            ArrayList<Integer> neighbors = graph.get(temp);
            for(int n:neighbors){
                inOrder.set(n,inOrder.get(n)-1);
                if(inOrder.get(n)==0){
                    queue.add(n);
                }
            }
        }
        if(visited!=nVertices){
            System.out.println("No Order:");
        }
        else{
            System.out.print("Order:");
            System.out.print(topo.get(0));
            for(int i=1;i<nVertices;i++){
                System.out.print("->"+topo.get(i));
            }
        }
    }
}
