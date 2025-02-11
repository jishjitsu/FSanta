/*Cob is working an Group of numbers.
His teacher gave him to print the Maximum product of the 'k' consiqutive numbers. 

The first line of input contains the group size followed by group numbers followed by k


sample input 1 :
----------------
5
1 5 3 2 10
3
sample output 1 :
-----------------
60

sample input 2 :
----------------
7
8 7 1 8 2 9 1
2
sample output 2:
----------------
56*/

import java.util.*;
public class day4_1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] arr = new int[a];
        for(int i=0;i<a;i++) arr[i] = sc.nextInt();
        int b = sc.nextInt();
        if(a<b){
            System.out.println(-1);
            return;
        }
        int prod = 1;
        for(int i=0;i<b;i++){
            prod = prod*arr[i];
        }
        int ret = prod;
        for(int i=b;i<a;i++){
            prod = (prod/arr[i-b])*arr[i];
            ret = Math.max(prod,ret);
        }
        System.out.println(ret);
    }
}

