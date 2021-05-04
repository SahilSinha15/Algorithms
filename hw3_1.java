/*
 * Title: hw3_1.java
 * Abstract: This program reads the user's input data and
 *           finds if there is an anagram or not and prints the letter counts.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 02/17/2021
 */
import java.util.*;
@SuppressWarnings("unchecked")
public class hw3_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputStr = scan.nextLine();
        HashMap<Character,Integer> anagramCheck = new HashMap<Character, Integer>();
        HashMap<Character,Integer> letterCounts = new HashMap<Character, Integer>();
        int temp2=0;
        String[] words = inputStr.split(" ");
        if(words[0].length() != words[1].length()){
            System.out.println("NO ANAGRAM");
            System.exit(1);
        }
        char[] word1 = words[0].toCharArray();
        char[] word2 = words[1].toCharArray();

        for(char c : word1){
            if(anagramCheck.containsKey(c)){
                int temp = anagramCheck.get(c);
                anagramCheck.replace(c,temp+1);
                letterCounts.replace(c,temp+1);
            }
            else {
                anagramCheck.put(c,1);
                letterCounts.put(c,1);
            }
        }

        for(char c : word2){
            if(letterCounts.containsKey(c)){
                int temp = letterCounts.get(c);
                letterCounts.replace(c,temp+1);
            }
            else {
                letterCounts.put(c,1);
            }
        }

        for(char c : word2){
            if(anagramCheck.containsKey(c)){
                int temp = anagramCheck.get(c);
                anagramCheck.replace(c,temp-1);
            }
            else {
                anagramCheck.put(c,1);
            }
        }

        for(int i :anagramCheck.values()){
            temp2+=i;
        }

        if(temp2==0){
            System.out.println("ANAGRAM");
            List<Character> sorted = new ArrayList(letterCounts.keySet());
            Collections.sort(sorted);

            for (Object c: sorted){
                System.out.println(c+":"+(letterCounts.get(c))/2);
            }


        }
        else{
            System.out.println("NO ANAGRAM");
        }
    }
}
