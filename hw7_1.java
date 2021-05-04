import java.util.ArrayList;
import java.util.Scanner;

public class hw7_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String inpStr = scan.nextLine();
        ArrayList<Integer> numArr = new ArrayList<>(n);
        String[] nums = inpStr.split(" ");
        for(String s : nums){
            numArr.add(Integer.parseInt(s));
        }
        System.out.println(findMax(0,n,numArr));


    }
    private static int findMax(int n1, int n2, ArrayList<Integer> numArr){
        int nTemp = n2-n1;
        if(nTemp==2){
            if(numArr.get(n1)>numArr.get(n2-1)) {
                System.out.println(numArr.get(n1));
                return numArr.get(n1);
            }
            else {
                System.out.println(numArr.get(n2-1));
                return numArr.get(n2-1);
            }
        }
        else {
            int nHalf = nTemp / 2;
            System.out.println(nHalf);
            int tempInt1 = findMax(n1, nHalf, numArr);
            int tempInt2 = findMax(nHalf, n2, numArr);
            if (tempInt1 > tempInt2) {
                System.out.println(tempInt1);
                return tempInt1;
            } else if (tempInt2 > tempInt1) {
                System.out.println(tempInt2);
                return tempInt2;
            }
        }
        System.out.println("0");
        return 0;
    }
}


