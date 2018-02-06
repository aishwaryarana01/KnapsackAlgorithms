/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackalgorithms;

/**
 *
 * @author Aishwarya Rana
 */
public class DynamicKnapsack {
        public static int knapsack(int val[], int wt[], int M) {
        int N = wt.length;
        int[][] Table = new int[N + 1][M + 1];
        /*for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }*/
        for (int item=1;item<=N;item++){
            for (int weight=1;weight<=M;weight++){
                if (wt[item-1]<=weight){
                    Table[item][weight]=Math.max (val[item-1]+Table[item-1][weight-wt[item-1]], Table[item-1][weight]);
                }
                else {
                    Table[item][weight]=Table[item-1][weight];
                }
            }
        }
       /*for (int[] rows : V) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }*/
        return Table[N][M];
    }
}
