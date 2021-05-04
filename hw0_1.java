
import java.util.Scanner;

public class hw0_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputLines = new String[10];
        int lineCount = 0;
        int outputCount = 0;
        int[] digitOne = new int[30];
        int[] digitTwo = new int[30];
        int[] digitThree= new int[30];
        int[] output = new int[10];

        lineCount=0;
        digitThree[lineCount]=0;

        while(digitThree[lineCount] != 3 ) {
            inputLines[lineCount] = sc.nextLine();
            String[] temp = inputLines[lineCount].split(" ");

            if(Integer.parseInt(temp[0])!=9){
                if(Integer.parseInt(temp[0])==1){
                    int tempOp = Integer.parseInt(temp[1])+Integer.parseInt(temp[2]);
                    output[outputCount]=tempOp;
                    outputCount+=1;
                }
                else if(Integer.parseInt(temp[0])==2){
                    int tempOp = Integer.parseInt(temp[1])-Integer.parseInt(temp[2]);
                    output[outputCount]=tempOp;
                    outputCount+=1;
                }
            }
            else{
                break;
            }
            lineCount+=1;
        }
        for(int i=0;i<outputCount;i++){
            System.out.println(output[i]);
        }

    }
}
