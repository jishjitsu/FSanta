import java.util.*;
public class day2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        StringBuilder s = new StringBuilder(a);
        for(int i=0;i<a.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1) && s.charAt(i)=='+'){
                s.setCharAt(i, '-');
                s.setCharAt(i+1, '-');
            }
        }
        System.out.println(s);
    }
}
