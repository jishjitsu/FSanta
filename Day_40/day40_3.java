/*Implement strStr() not using the standard strStr function. Return the index of the
first occurrence of str1 and str2, or -1 if str1 is not part of str2. (Eg: if s1 = "one", */

import java.util.*;

public class day40_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        int idx = 0, start = -1;
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == s1.charAt(idx)) {
                if (idx == 0) start = i;
                idx++;
                if (idx == s1.length()) {
                    System.out.println(start);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}