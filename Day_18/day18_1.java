/*
In the grand kingdom of  Numeria , musicians follow a unique pattern while composing their legendary beats. 
These beats are played using only  two sounds: 1 and 2 . However, what makes their rhythm truly magical is a
mysterious rule that dictates how the beats are arranged.  

The sequence begins as follows:  

1, 2, 2, 1, 1, 2, 1, 2, 2, 1, 2, 1, 1, 2, 2, ...

But the pattern behind this rhythm is hidden! Here’s how it works:  

1. The  first number  in the sequence tells us  how many times the first beat (1) should appear  →  "1" (one time)   
2. The  second number  tells us  how many times the next beat (2) should appear  →  "2 2" (two times)   
3. The  third number  tells us  how many times the next beat (1) should appear  →  "1 1" (two times)   
4. The  fourth number  tells us  how many times the next beat (2) should appear  →  "2" (one time)   
5. The  fifth number  tells us  how many times the next beat (1) should appear  →  "1" (one time)   

And so on... The  N-th number tells us how many times the next number should be repeated .

The  King of Numeria  is fascinated by this pattern and has summoned  you , the greatest coder in the land, 
to generate the first  N beats  of this musical sequence!  


Example 1   
Input = 10
Output = 1 2 2 1 1 2 1 2 2 1


Explanation: 
- The  first number (1)  means "write one `1`" → `1`
- The  second number (2)  means "write two `2s`" → `1, 2, 2`
- The  third number (2)  means "write two `1s`" → `1, 2, 2, 1, 1`
- The  fourth number (1)  means "write one `2`" → `1, 2, 2, 1, 1, 2`
- The  fifth number (1)  means "write one `1`" → `1, 2, 2, 1, 1, 2, 1`
- And so on...

---

Example 2   
Input:   
-------
15
Output:
----------
1 2 2 1 1 2 1 2 2 1 2 1 1 2 2 */

import java.util.*;
class sol
{
  public static void main(String args[])
 {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println(pattern(n));
 }
 public static String pattern(int n)
 {
    StringBuilder sb=new StringBuilder();
    String s="1 2 2 1";
    int i=0;
    String s1="1 2";
    String s2="2 1";
    boolean t=true;
    while(i<n)
    {
        String [] temp=s.split(" ");
        for(String num:temp)
    {
        if(i<n)
        {
            sb.append(num).append(" ");
            i++;
        }
        else
        {
            break;
        }
    }
    if(i<n)
    {
        String nums[]=t?s1.split(" "):s2.split(" ");
        for(String num:nums)
        {
            if(i<n)
            {
                sb.append(num).append(" ");
                i++;
            }
            else 
            {
                break;
            }
        }
    }
    t=!t;
}
return sb.toString();
}

}