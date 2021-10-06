package StackImplementation;/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int []A = new int[n];
            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<n;i++){
                A[i] = sc.nextInt();
                if(A[i] < 0)
                    q.add(i);
            }
            System.out.println(q);
            int k = sc.nextInt();
            for(int i=0;i<=n-k;i++){
                if(!q.isEmpty()){
                    if(q.peek() >=i && q.peek() <= i+k-1){
                        System.out.print(A[q.peek()] + " ");
                    }
                    else if(q.peek() < i){
                        q.remove();
                        if(!q.isEmpty() && q.peek() >=i && q.peek() <= i+k-1)
                            System.out.print(A[q.peek()] + " ");
                        else
                            System.out.print("0 ");
                    }
                    else{
                        System.out.print("0 ");
                    }
                }
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }
}