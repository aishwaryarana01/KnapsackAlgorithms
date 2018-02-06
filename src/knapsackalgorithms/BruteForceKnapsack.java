/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackalgorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Aishwarya Rana
 */
public class BruteForceKnapsack {
    public static void bruteForceKnapsack(int M, int wt[], int val[], int n){
        //Set to store the array of data in form of integer sets of values and their corresponding weights
        Set<Integer[]> set = new HashSet<>();
        //Assigning the arrays to the set
        for(int i = 0; i<n; i++){
            Integer[] arr = new Integer[2];
            arr[0]=wt[i];
            arr[1]=val[i];
            set.add(arr);
        }
        int count = 0;
        //Getting the power set of the value & weight set to get all possible combinations
        Set<Set<Integer[]>> subsets = powerSet(set);
        //Integer array to store the sum of weights and values of all sub-arrays
        int arr[][] = new int[subsets.size()][2];
        for(Set<Integer[]> s : subsets){
            //Calculating the sum of weights and values of each sub-array
            int sum_wt = 0, sum_val =0;
            for(Integer[] i : s){
                sum_wt+=i[0];
                sum_val+=i[1];
            }
            int a[] = new int[2];
            a[0]=sum_wt;
            a[1]=sum_val;
            arr[count]=a;
            count++;
        }
        //Identifying the sub-array under the weight limit with the highest value
        int max = arr[0][0],    max_arr[] = new int[2];
        for(int[] temp : arr){
            if(temp[0]<=M && temp[0]>max){//Checking to see if the weight isn't exceeded and the value is greater than its predecessor
                max = temp[0];
                max_arr = temp;
            }
        }
        System.out.println("Maximum Weight -> "+max_arr[0]);
        System.out.println("Maximum Value -> "+max_arr[1]);
    }
    //Function to get the power set of the provided set
    public static Set<Set<Integer[]>> powerSet(Set<Integer[]> originalSet) {
        Set<Set<Integer[]>> sets = new HashSet<>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<>());
            return sets;
        }
        List<Integer[]> list = new ArrayList<>(originalSet);
        Integer[] head = list.get(0);
        Set<Integer[]> rest = new HashSet<>(list.subList(1, list.size()));
        powerSet(rest).forEach((Set<Integer[]> set) -> {
            Set<Integer[]> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        });
        return sets;
    }
}
