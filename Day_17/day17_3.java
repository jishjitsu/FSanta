/*Calendar Dates 

Ramu is playing with the dates of the calender, for his surprise he found few dates to be similar in both from left to right
and right to left.
He is now intrested to know all such dates in the calender. Help ramu in this.
IF NO PALINDROMIC DATES PRINT -1.


input = 2020
output = 02-02-2020


input = 2010
output = 01-02-2010

 */
import java.util.*;

public class day17_3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder r = new StringBuilder();
        for(int i=0; i<s.length();i++){
            r.append(s.charAt(s.length()-1-i));
        }
        String a1 = r.toString()+s;
        StringBuilder a = new StringBuilder(a1);
        int day = Integer.parseInt(a.substring(0,2));
        int month = Integer.parseInt(a.substring(2,4));
        if(day>31 || month>12){
            System.out.print(-1);
        }
        else{
            System.out.print(a.substring(0,2)+"-"+a.substring(2,4)+"-"+s);
        }
    }
}