/*write a java program to find the greatest of 4 numbers using ternary operator 

input = 3 4 5 6
output = 6 */
import java.util.*;
public class day10_1{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();
    int max = (a>b)?(a>c?(a>d?a:d):(c>d?c:d)):(b>c?(b>d?b:d):(c>d?c:d));
    System.out.println(max);
    }
}