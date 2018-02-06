/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackalgorithms;

import java.io.IOException;
import java.util.Scanner;
import java.util.*;


/**
 *
 * @author Aishwarya Rana
 */
public class KnapsackAlgorithms {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        boolean done = false;
    	
        Random rand = new Random(2);
    	long start_time, end_time;
    	try (Scanner sc = new Scanner(System.in)) {
    		System.out.println("Enter the number of items: ");
    		int n = sc.nextInt();
    		
    		System.out.println("Enter the maximum capacity: ");
    		int M = sc.nextInt();
    		
    		System.out.println("Generating Random Weight for Items");
    		/*int[] wt = new int[n];
    		for (int i = 0; i < n; i++) {
    			wt[i] = rand.nextInt(1000)+ 1;
    		}*/
    		//Generating weight whose sum is greater or equals to 2*M
    		ArrayList<Integer> load = new ArrayList<Integer>();
    		int[] wt = new int[n];
    		int WeightSum = 0;
    		for(int i = 0;i< n; i++) {
    			 if (!(i == n)) {
    		            wt[i] = rand.nextInt(((2*M))/(n-i)) +1;
    		            load.add(wt[i]);
    		            WeightSum += wt[i];

    		        } else {
    		            int last = (2*M - WeightSum);
    		            load.add(last);
    		            WeightSum += last;
    		        }
    		}
    		System.out.println("Total weight sum is " +WeightSum+ " which is greater than or equlas to twice the maximum capacity " +2*M);
    		System.out.println("Generating Radom Values for Items: ");
    		int[] val = new int[n];
    		for (int i = 0; i < n; i++) {
    			val[i] = rand.nextInt(100) + 1;
    		}

    		System.out.println("List of Generated weight and Values of "+n+" Items");
    		System.out.print("Weight: ");
    		for(int i = 0;i< n; i++)
    			System.out.print(wt[i]+ " ");
    		System.out.println();
    		
    		System.out.print("Value:  ");
    		for(int i = 0;i< n; i++)
    			System.out.print(val[i]+ " ");
    		System.out.println();
    		
    		
    		while(done != true)
    	    {
    			System.out.println("---------Hashing Algorithms-----------");
    			System.out.println("1.Dynamic Knapsack");
    			System.out.println("2.Greedy Knapsack");
    			System.out.println("3.BruteForce Knapsack");
            	System.out.println("------------------------------------------------");
            	System.out.print("Enter your choice:: ");
            	int choice1 = sc.nextInt();
            	switch (choice1) {
                	case 1:
                		//Dynamic Knapsack
                		System.out.println("---------------Dynamic Knapsack Approach-----------------");
                		start_time = System.currentTimeMillis();
                		System.out.println("Total Value in sack:: " + DynamicKnapsack.knapsack(val, wt, M));
                		end_time = System.currentTimeMillis();
                		System.out.println("Execution time for Dynamic Algorithm is:: " + (end_time - start_time));

                		break;
                	case 2:
                		//Greedy Approach
                		System.out.println("---------------Greedy Knapsack Approach-----------------");
                		start_time = System.currentTimeMillis();
                		System.out.println("Total Value in sack:: " + GreedyKnapsack.greedyKnapSack(M, wt, val, n));
                		end_time = System.currentTimeMillis();
                		System.out.println("Execution time for Greedy Algorithm is:: " + (end_time - start_time));
                		
                		break;
                	case 3:
                		//BruteForce Approach             		
                		System.out.println("---------------Bruteforce Knapsack Approach-----------------");
                		start_time = System.currentTimeMillis();
                		BruteForceKnapsack.bruteForceKnapsack(M, wt, val, n);
                		end_time = System.currentTimeMillis();
                		System.out.println("Execution time for  Algorithm is:: " + (end_time - start_time));

                		break;
                	default:
                		done = true;
                		System.out.println("Wrong Choice Exiting Program!!");
                	
            		}//Switch
            		System.out.println();	
    			}//While
        	}//Try
        }
    }
