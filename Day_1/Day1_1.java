package Day_1;
import java.util.*;
public class Day1_1 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    for(int i=0;i<a;i++){
        if(unique(i)) System.out.println(i);
        }
    }

    static boolean unique(int a){
        Set<Character> set = new HashSet<>();
        String s = Integer.toString(a);
        char[] c  = s.toCharArray();
        for(char ch: c){
            if(set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}


