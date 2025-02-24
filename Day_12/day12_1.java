/*Given an array, rotate the array to the right by k steps, where k is non-negative. For example, if 
our input array is [a, b, c, d, e] and k is 2, then the output should be [d, e, a, b, c].
We can solve this by having two loops again which will make the time complexity O(n^2) or by 
using an extra, temporary array, but that will make the space complexity O(n).

example
input=5
a b c d e
d e a b c
2 
output=d e a b c

 */

 import java.util.*;
public class day12_1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char[] arr = new char[a];
        for(int i=0;i<a;i++) arr[i]=sc.next().charAt(0);
        int k = sc.nextInt();
        k = k%a ;
        StringBuilder sb = new StringBuilder();
        for(int i=a-k;i<a;i++){
            sb.append(arr[i]+" ");
        }
        
        for(int i=0;i<a-k;i++){
            sb.append(arr[i]+" ");
        }
        
        System.out.println(sb.toString());
        }
}