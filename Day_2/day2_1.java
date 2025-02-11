import java.util.*;
public class day2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int r = sc.nextInt();
        if(r==1 || r<s.length()){
            System.out.println(s);
            return;
        }
        List<List<Character>> li = new ArrayList<>();
        boolean up = false;
        for(int i=0;i<r;i++){
            li.add(new ArrayList<Character>());
        }
        int k=0;
        for(int i=0;i<s.length();i++){
                li.get(k).add(s.charAt(i));
                if(k==0) up=false;
                if(k==r-1) up=true;
                k+=up?-1:1;
        }
            

        StringBuilder sb = new StringBuilder();
        for(List<Character> l: li){
            for(char c: l){
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }
}
