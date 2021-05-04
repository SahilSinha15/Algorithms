/*
 * Title: hw9_2.java
 * Abstract: This program takes in a size and performs and calculates time for quicksort and merge sort.
 * Author: Sahil Sinha
 * ID: 0183
 * Date: 4/14/2021
 */
//here are the links that i used and modified for my assignment.
//merge- https://www.javatpoint.com/merge-sort
//quick- https://www.baeldung.com/java-quicksort




import java.util.Random;
import java.util.Scanner;

public class hw9_2 {
    public static void main(String[] args) {
        System.out.print("Enter input size: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        System.out.println();
        int[] inpArr = new int[size];
        int[] inpArr2 = new int[size];
        Random random = new Random();
        for(int i=0;i<size;i++){
            int tempInt=random.nextInt();
            inpArr[i]=tempInt;
            inpArr2[i]=tempInt;
        }

        System.out.println("===================== Execution Time ====================");

        long start_time = System.nanoTime();
        mergeSort(inpArr,0,size-1);
        long end_time = System.nanoTime();
        double difference = (end_time - start_time) / 1e6;
        System.out.printf("Merge sort:   %.6f milliseconds\n",difference);

        long start_time2 = System.nanoTime();
        quickSort(inpArr2,0,size-1);
        long end_time2 = System.nanoTime();
        double difference2 = (end_time2 - start_time2) / 1e6;
        System.out.printf("Quick sort:   %.6f milliseconds\n",difference2);



        System.out.println("=========================================================");



    }

    public static void mergeSort(int[] arr,int beg,int end){
        if (beg<end)
        {
            int mid = (beg+end)/2;
            mergeSort(arr, beg, mid);
            mergeSort(arr , mid+1, end);
            merge(arr, beg, mid, end);
        }
    }
    public static void merge(int arr[], int beg, int mid, int end)
    {
        int l = mid - beg + 1;
        int r = end - mid;
        int LeftArray[] = new int [l];
        int RightArray[] = new int [r];
        for (int i=0; i<l; ++i)
            LeftArray[i] = arr[beg + i];
        for (int j=0; j<r; ++j)
            RightArray[j] = arr[mid + 1+ j];
        int i = 0, j = 0;
        int k = beg;
        while (i<l&&j<r)
        {
            if (LeftArray[i] <= RightArray[j])
            {
                arr[k] = LeftArray[i];
                i++;
            }
            else
            {
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i<l)
        { arr[k] = LeftArray[i];
            i++;
            k++;
        }
        while (j<r)
        { arr[k] = RightArray[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    private static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


}
