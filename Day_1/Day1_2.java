package Day_1;
import java.util.*;
public class Day1_2 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a = sc.nextLine();
    StringBuilder sb = new StringBuilder();
    List<Character> l = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
    for(char c: a.toCharArray()){
        if(l.contains(c)){
            sb.append(c);
        }
        else{
            sb.append(c);
            sb.append('#');
            sb.append(c);
        }
        }
        System.out.print(sb.toString());
    }
}
