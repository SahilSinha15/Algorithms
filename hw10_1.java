/*
 * Title: hw9_2.java
 * Abstract: This program takes in user input and performs heap operations.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 4/26/2021
 */
import java.util.ArrayList;
import java.util.Scanner;

public class hw10_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int initN = scan.nextInt();
        scan.nextLine();
        String numsStr = scan.nextLine();
        String[] nums = numsStr.split(" ");
        ArrayList<Integer> heap = new ArrayList<>();
        for(String s: nums){
            heap.add(Integer.parseInt(s));
        }
        int levels = (int)(Math.log(heap.size())/Math.log(2));
        boolean isHeap = isHeap(heap);
        int numOps = scan.nextInt();
        scan.nextLine();

        if(isHeap){
            System.out.println("This is a heap.");
        }
        else{
            System.out.println("This is NOT a heap.");
            makeHeap(heap);
        }

        for(int i=0;i<numOps;i++){
            String temp = scan.nextLine();
            String[] temp2 = temp.split(" ");
            switch (temp2[0]){
                case "display":
                    display(heap);
                    break;
                case "displayMax":
                    dispMax(heap);
                    break;
                case "deleteMax":
                    deleteMax(heap);
                    break;
                case "delete":
                    int tempInt = Integer.parseInt(temp2[1]);
                    delete(heap,tempInt);
                    break;
                case "insert":
                    int tempInt2 = Integer.parseInt(temp2[1]);
                    insert(heap,tempInt2);
                    break;
                case "update":
                    int tempInt3=Integer.parseInt(temp2[1]);
                    int tempInt4=Integer.parseInt(temp2[2]);
                    update(heap,tempInt3,tempInt4);
                    break;

            }


        }




    }

    public static boolean isHeap(ArrayList<Integer> heap){
        int levels = (int)(Math.log(heap.size())/Math.log(2));
        boolean isHeap=true;
        for(int i=0;i<(int)Math.pow(2,levels)-1;i++){
            int node = heap.get(i);
            int lChildNum = (2*i)+1;
            int rChildNum = (2*i)+2;
            if(lChildNum<heap.size() && rChildNum<heap.size()) {
                int lChild=heap.get(lChildNum);
                int rChild=heap.get(rChildNum);
//                System.out.println(node);
//                System.out.println(lChild);
//                System.out.println(rChild);
//                System.out.println();

                if (node < lChild || node < rChild) {
                    isHeap = false;
                }
            }
            if(lChildNum<heap.size() && rChildNum>=heap.size()){
                int lChild=heap.get(lChildNum);
//                System.out.println(node);
//                System.out.println(lChild);
                if (node < lChild) {
                    isHeap = false;
                }
            }

        }


        return isHeap;

    }

    public static void heapify(ArrayList<Integer> heap, int nodeNum){
        int node = heap.get(nodeNum);
        int lChildNum = (2*nodeNum)+1;
        int rChildNum = (2*nodeNum)+2;
        int lChild = -9999999;
        int rChild = -9999999;
        if(lChildNum<heap.size() && rChildNum<heap.size()) {
            lChild=heap.get(lChildNum);
            rChild=heap.get(rChildNum);
        }
        if(lChildNum<heap.size() && rChildNum>=heap.size()){
            lChild=heap.get(lChildNum);
        }
//        System.out.println(node);
//        System.out.println(lChild);
//        System.out.println(rChild);
//        System.out.println();

        int levels = (int)(Math.log(heap.size())/Math.log(2));
        if(lChild != -9999999 && rChild != -9999999){
            int max = Integer.max(lChild,rChild);
            if(node<max){
                if(max==lChild){
//                    System.out.println("swapping "+node+" & "+lChild );
//                    System.out.println();
                    int temp=lChild;
                    heap.set(lChildNum,node);
                    heap.set(nodeNum, temp);
                    if(lChildNum<Math.pow(2,levels)-1){
                        heapify(heap,lChildNum);
                    }

                }
                else if(max==rChild){
//                    System.out.println("swapping "+node+" & "+rChild );
//                    System.out.println();
                    int temp=rChild;
                    heap.set(rChildNum,node);
                    heap.set(nodeNum, temp);
                    if(rChildNum<Math.pow(2,levels)-1){
                        heapify(heap,rChildNum);
                    }

                }
            }
        }
        if(lChild != -9999999 && rChild == -9999999){
            int max = lChild;
            if(node<max){
//                System.out.println("swapping "+node+" & "+rChild );
//                System.out.println();
                int temp=lChild;
                heap.set(lChildNum,node);
                heap.set(nodeNum, temp);
                if(lChildNum<Math.pow(2,levels)-1){
                    heapify(heap,lChildNum);
                }
            }
        }

    }

    public static void makeHeap(ArrayList<Integer> heap){
        int levels = (int)(Math.log(heap.size())/Math.log(2));
            for (int i = (int) Math.pow(2, levels) - 1; i >= 0; i--) {
                heapify(heap, i);
            }

    }
    public static void dispMax(ArrayList<Integer> heap){
        System.out.println(heap.get(0));
    }
    public static void display(ArrayList<Integer> heap){
        for(int i : heap){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void insert(ArrayList<Integer> heap, int num){
        heap.add(num);
        makeHeap(heap);
    }
    public static void deleteMax(ArrayList<Integer> heap){
        int temp = heap.get(heap.size()-1);
        heap.remove(heap.size()-1);
        heap.set(0,temp);
        makeHeap(heap);
    }
    public static void delete(ArrayList<Integer>heap, int num){
        int temp = heap.get(heap.size()-1);
        heap.remove(heap.size()-1);
        heap.set(heap.indexOf(num),temp);
        makeHeap(heap);
    }
    public static void update(ArrayList<Integer> heap, int index,int num){
        index-=1;
        heap.set(index,num);
        makeHeap(heap);
    }

}
