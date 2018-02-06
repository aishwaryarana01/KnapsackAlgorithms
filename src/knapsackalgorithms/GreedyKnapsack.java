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
public class GreedyKnapsack {
    static float greedyKnapSack(int M, int wt[], int val[], int n){
        int i,j=0,m=M; 
        float sum=0,max;
        while(m>=0)  
        {  
            max=0;  
            for(i=0;i<n;i++)  
            {  
                if(((float)val[i])/((float)wt[i])>max)  
                {  
                    max=((float)val[i])/((float)wt[i]);  
                    j=i;  
                }  
            }  
            if(wt[j]>m)  
            {  
                sum+=m*max;  
                m=-1;  
            }  
            else  
            {  
                m-=wt[j];  
                sum+=(float)val[j];  
                val[j]=0;  
            }  
        }  
        return sum;
    }
}
