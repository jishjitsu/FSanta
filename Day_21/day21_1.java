/*
In a world where encoded messages are sent secretly, your task is to decode them. 
The encoding follows a specific pattern:

You are given a string s that consists of lowercase English letters and encoded segments. 
The encoded segments follow this rule:

k[encodedString] where encodedString is a sequence of lowercase English letters enclosed in square brackets, 
and k is a positive integer indicating how many times the encodedString should be repeated.


You need to implement a function that takes this encoded string as input and returns the fully decoded version of it.

Input
A single string s, where s consists of digits, square brackets [ ], and lowercase English letters.

Output
Return a string that represents the decoded message.

Examples
Example 1:
Input = 1[b]
Output = b

Example 2:
Input = 3[b2[ca]]
Output = bcacabcacabcaca


Explanation:
Inner substring 2[ca] breakdown into caca.
it becomes 3[bcaca]
3[bcaca] becomes bcacabcacabcaca which is final result

Example 3:
Input = 2[abc]3[cd]ef
Output = abcabccdcdcdef */

import java.util.Scanner;
import java.util.Stack;

public class day21_1{
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0'); // Handling multi-digit numbers
            } else if (ch == '[') {
                countStack.push(count); // Store repeat count
                stringStack.push(currentString); // Store current string
                currentString = new StringBuilder(); // Reset current string
                count = 0; // Reset count
            } else if (ch == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(decodeString(s));
    }
}
