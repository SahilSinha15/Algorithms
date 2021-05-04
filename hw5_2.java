/*
 * Title: hw5_2.java
 * Abstract: This program reads the user's input data and
 *           solves the travelling salesman problem.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 05/03/2021
 */
import java.util.*;

public class hw5_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nVertices = scan.nextInt();
        ArrayList<String> vertices = new ArrayList<>();
        int[][] adjMatrix = new int[20][20];
        int[] fromRoot = new int[4];
        int[] toRoot = new int[4];
        HashMap<String ,Integer> possibleSolutions = new HashMap<>();
        scan.nextLine();
        String root = scan.nextLine();
        for(int i=0;i<nVertices-1;i++){
            String temp = scan.nextLine();
            vertices.add(temp);
        }
        int nEdges = scan.nextInt();
        scan.nextLine();
        for(int i=0;i<nEdges;i++){
            String temp = scan.nextLine();
            String[] tempArr = temp.split(" ");

            int from = vertices.indexOf(tempArr[0]);
            int to = vertices.indexOf(tempArr[1]);

            if(from==-1){
                fromRoot[to] = Integer.parseInt(tempArr[2]);
            }
            else if(to==-1){
                toRoot[from] = Integer.parseInt(tempArr[2]);
            }
            else{
                adjMatrix[from][to] = Integer.parseInt(tempArr[2]);
            }
        }

        String permStr = "";
        for(int i=0;i<nVertices-1;i++){
            permStr+=i;
        }

        ArrayList<String> perms = performPermutations(permStr);


        for(String s: perms){
            char[] tempChars = s.toCharArray();
            int size = s.length();
            int firstNode = Character.getNumericValue(tempChars[0]);
            int lastNode = Character.getNumericValue(tempChars[size-1]);

            if(fromRoot[firstNode]==0 || toRoot[lastNode]==0){
                continue;
            }
            else {
                int checkFlag = 0;
                int cost=0;
                for(int i=0;i<size-1;i++){
                    if(adjMatrix[Character.getNumericValue(tempChars[i])][Character.getNumericValue(tempChars[i+1])]==0){
                        checkFlag = 1;
                    }
                    else{
                        cost+=adjMatrix[Character.getNumericValue(tempChars[i])][Character.getNumericValue(tempChars[i+1])];
                    }
                }
                if(checkFlag==0){
                    cost+=fromRoot[firstNode];
                    cost+=toRoot[lastNode];
                    possibleSolutions.put(s,cost);
                }
                else{
                    continue;
                }
            }
        }
        int min=Integer.MAX_VALUE;
        String ans = "";

        if(!possibleSolutions.isEmpty()) {
            for (Map.Entry<String, Integer> tempSet : possibleSolutions.entrySet()) {
                if (min > tempSet.getValue()) {
                    min = tempSet.getValue();
                    ans = tempSet.getKey();
                }
            }
            System.out.print("Path:");
            System.out.print(root+"->");
            char[] tempChar = ans.toCharArray();
            for(char c: tempChar){
                int temp = Character.getNumericValue(c);
                System.out.print(vertices.get(temp));
                System.out.print("->");
            }
            System.out.print(root);
            System.out.println("\nCost:"+min);
        }
        else{
            System.out.println("Path:");
            System.out.println("Cost:-1");
        }


    }

//***********************************************************************************************************************************
    //this part is not coded my be but taken from https://stackoverflow.com/questions/28017689/permutation-of-an-arraylist
    public static ArrayList<String> performPermutations(String s){
        ArrayList<String> arrayList = new ArrayList<String>();
        if (s == null) {
            return null;
        }

        else if (s.length() == 0) {
            arrayList.add("");
            return arrayList;
        }

        else {
            for (int i = 0; i < s.length(); i++) {
                ArrayList<String> remaining = performPermutations(s.substring(0, i) + s.substring(i + 1));
                for (int j = 0; j < remaining.size(); j++) {
                    arrayList.add(s.charAt(i) + remaining.get(j));
                }
            }
            return arrayList;
        }
    }
//***********************************************************************************************************************************
}

