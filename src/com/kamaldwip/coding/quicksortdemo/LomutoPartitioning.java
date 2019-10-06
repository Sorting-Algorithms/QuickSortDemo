package com.kamaldwip.coding.quicksortdemo;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class LomutoPartitioning {

    public static void main(String[] args) {

	// write your code here
     int inputArr[]={4,2,8,7,1,3,5,6};
     doQuickSort(inputArr);

    }

    private static void doQuickSort(int input[]){
        System.out.println("Input Array is "+Arrays.toString(input));
        input = useQuickSortHelper(input,0,(input.length)-1);
        System.out.println("Sorted Array is ");
        System.out.println(Arrays.toString(input));

    }

    private static int[] useQuickSortHelper(int[] input, int start, int end) {

        if(start >= end){
            System.out.println("Array trivially sorted.");
            return input;
        }

        int randomIndex = ThreadLocalRandom.current().nextInt(start,(end+1));
        System.out.println("Random index is "+randomIndex);

        input = swap(input,start,randomIndex);
        System.out.println("After swapping ----> 1"+Arrays.toString(input));

        int pivot = input[start];
        int bigger = start;
        int smaller = start;

        for(bigger = start+1; bigger <= end; bigger++){
            if(input[bigger]< pivot){
                smaller++;
                input = swap(input,smaller,bigger);
                System.out.println("After swapping ----> 2"+Arrays.toString(input));
            }
            System.out.println("Bigger--->1: "+bigger);
            System.out.println("Smaller--->1: "+smaller);
        }
        input = swap(input,start,smaller);
        System.out.println("After swapping ----> 3"+Arrays.toString(input));

        System.out.println("Bigger--->2: "+bigger);
        System.out.println("Smaller--->2: "+smaller);

        useQuickSortHelper(input,start,smaller-1);
        useQuickSortHelper(input,smaller+1, bigger-1);

        return input;
    }

    private static int[] swap(int[] input, int positionA, int positionB) {
        System.out.println("Input numbers are "+input[positionA]+" and "+input[positionB]);
        if(positionA != positionB){
            input[positionA] = input[positionA] + input[positionB];
            input[positionB] = input[positionA] - input[positionB];
            input[positionA] = input[positionA] - input[positionB];
        }
        System.out.println("After Swapping numbers are "+input[positionA]+" and "+input[positionB]);
        return input;
    }

}
