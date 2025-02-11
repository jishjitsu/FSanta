import java.util.*;
public class day2_3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder a = new StringBuilder(s);
        List<Character> l = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        for(int i=0; i<s.length();i++){
            if(l.contains(s.charAt(i))){
                a.setCharAt(i, 'V');
            }
            else{
                a.setCharAt(i, 'C');
            }
        }
        for(int i=0;i<a.length()-1;i++){
            if(a.charAt(i)==a.charAt(i+1)){
                a.deleteCharAt(i);
                i--;
            }
        }
        System.out.println(a);
    }
}