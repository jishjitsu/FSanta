/*Tubby a Third Class Student has given a Assignment on Time Chapter by his class teacher.
Tubby is supposed to change the time given in AM/PM Format to 24 Hours Format. 
Help Tubby Solve the Problem 
  
The Maths teacher gave him the time in the following Format - HH:MM:SS:AM/PM
   
Assume all HH,MM,SS are in the valid range only 
  
Note: Midnight is 12:00:00AM on a 12-hour clock,  and 00:00:00 on a 24-hour clock. 
Noon is 12:00:00PM on a 12-hour clock,  and 12:00:00 on a 24-hour clock. 
       
Assume all input times are valid
    

Example:
input = 06:10:20PM
output = 18:10:20
  

    
 */

 import java.util.*;
public class day12_3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(8)=='P' && sb.charAt(0)=='1' && sb.charAt(1)=='2'){
            System.out.println("12:00:00");
            return;
        }
        if(sb.charAt(8)=='A' && sb.charAt(0)=='1' && sb.charAt(1)=='2'){
            System.out.println("00:00:00");
            return;
        }
        if (sb.charAt(8)=='P'){
            sb.replace(0, 2,String.valueOf(Integer.parseInt(sb.substring(0,2))+12));
        }
        sb.delete(sb.length()-2, sb.length());
        System.out.println(sb);
    }
}