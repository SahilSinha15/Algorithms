/*
 * Title: hw5_1.java
 * Abstract: This program reads the user's input data and
 *           cleans the string and checks palindrome recursively.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 05/03/2021
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class hw5_1 {
    public static void main(String[] args) {


        Scanner scan =  new Scanner(System.in);
        String inpStr = scan.nextLine();
        inpStr = inpStr.toLowerCase();
        char[] chars = inpStr.toCharArray();
        Deque<Character> charDq = new ArrayDeque<>();
        ArrayList<Character> tempChars = new ArrayList<Character>();
        for(char c : chars){
            tempChars.add(c);
        }
        for(char c : chars) {
            if (Character.getType(c) == 9 || Character.getType(c) == 2) {

            } else {
                int tempInd = tempChars.indexOf(c);
                tempChars.remove(tempInd);
            }
        }
        for(char c :tempChars){
            charDq.add(c);
        }

       Deque<Character> output = isPalindrome(charDq);
        if (output.size() == 1 || output.size() == 0) {
            System.out.println("TRUE");
        }
        else{
            System.out.println("FALSE");
        }

    }

    private static Deque<Character> isPalindrome(Deque<Character> Dq) {

        if (Dq.size() == 1 || Dq.size() == 0) {
            return Dq;
        } else {
            if (Dq.getFirst() == Dq.getLast()) {
                Dq.removeFirst();
                Dq.removeLast();
                Dq = isPalindrome(Dq);

            } else {
                return Dq;
            }
        }
        return Dq;
    }

}
