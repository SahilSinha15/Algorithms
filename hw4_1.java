/*
 * Title: hw4_1.java
 * Abstract: This program reads the user's input data and solves the knapsack problem.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 02/25/2021
 */
import java.util.ArrayList;
import java.util.Scanner;

public class hw4_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nElems = scan.nextInt();
        int capacity = scan.nextInt();
        int n = (int) Math.pow(2,nElems);
        scan.nextLine();
        ArrayList<Integer> itemCap = new ArrayList<>();
        ArrayList<Integer> itemVal = new ArrayList<>();
        ArrayList<Integer> possVals = new ArrayList<>();
        ArrayList<Integer> possCaps = new ArrayList<>();
        ArrayList<String> possItems = new ArrayList<>();


        for(int i=0; i<nElems;i++){
            String tempStr = scan.nextLine();
            String[] nums = tempStr.split(" ");
            itemCap.add(Integer.parseInt(nums[0]));
            itemVal.add(Integer.parseInt(nums[1]));
        }


        for(int i=0;i<n;i++){
            String temp = Integer.toBinaryString(i);
            char[] tempArr = temp.toCharArray();
            int tempVal = 0;
            int tempCap = 0;
            if(temp.length()==nElems){

                String tempComb = "";
                for(int k=0;k<nElems;k++){
                    int tt = tempArr[k];
                    if(tt==49){
                        tempComb += (k+1) + " ";
                        tempVal += itemVal.get(k);
                        tempCap += itemCap.get(k);



                    }
                }


                possCaps.add(tempCap);
                possItems.add(tempComb);
                possVals.add(tempVal);



            }
            else {
                int zeros = nElems - temp.length();
                String binNum = "";
                for (int j = 0; j < zeros; j++) {
                    binNum += "0";
                }
                binNum += temp;

                char[] tempArr2 = binNum.toCharArray();

                if (temp.equals("0")) {

                    continue;
                }

                String tempComb = "";
                for (int k = 0; k < nElems; k++) {

                    int tt = tempArr2[k];
                    if (tt == 49) {
                        tempComb += (k+1) + " ";
                        tempVal += itemVal.get(k);
                        tempCap += itemCap.get(k);

                    }
                }

                possCaps.add(tempCap);
                possItems.add(tempComb);
                possVals.add(tempVal);


            }
        }
        int valSolution=0;
        int capSolution=0;
        String itemSolution="";
        int tempIndex=0;

        for(int i=0;i<n-1;i++){
            if(possVals.get(i)>valSolution && possCaps.get(i)<=capacity ){
                valSolution=possVals.get(i);
                capSolution=possCaps.get(i);
                itemSolution=possItems.get(i);
                tempIndex=i;

            }
        }

        possVals.remove(tempIndex);

        if(!possVals.contains(valSolution)) {
            System.out.println("Item:" + itemSolution);
            System.out.println("Capacity:" + capSolution);
            System.out.println("Value:" + valSolution);

        }
        else{
            System.out.println("Item:Multiple solutions");
            System.out.println("Capacity:" + capSolution);
            System.out.println("Value:" + valSolution);
        }
    }
}
