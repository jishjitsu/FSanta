/*
 You are given an array nums of size n+1, 
where each element is an integer between 1 and n (inclusive). 

The array contains exactly one duplicated number, which appears at least twice, while all other numbers appear exactly once.

Your task is to find and return the repeated number without modifying the array and using only constant extra space.

Input Format:
-------------
Line-1: An integer N, size of array
Line-2: N space separated integer

Output Format:
--------------
Line-1: An integer, duplicate value

Sample Input-1:
---------------
5
1 3 4 2 2

Sample Output-1:
----------------
2

Sample Input-2:
---------------
5
3 1 3 4 2

Sample Output-2:
----------------
3
 

Constraints:
-> 1 ≤ n ≤ 10⁵
-> nums.length = n + 1
-> 1 ≤ nums[i] ≤ n
-> All numbers appear exactly once except for one number which appears at least twice.
 */

 import java.util.*;
public class day10_4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i]=sc.nextInt();
        int ret = 0;
        int y = 0;
        for(int i=0;i<arr.length;i++){
            ret = ret^arr[i];
        }
        for(int i=1;i<n;i++){
            y = y^i;
        }
        int x = ret^y;
        if(x==0 ){
            System.out.println(-1);
            return;
        }
        System.out.println(x);
        }
}
