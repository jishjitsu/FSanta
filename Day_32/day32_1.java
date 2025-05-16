/*You are given two strings 'Org' and 'Sub' where Sub is a subsequence of Org. 
You aer given a list of R indices[] (Unique indices), and you need to delete 
P letters from the given string 'Org', with the following conditions:
    - You need to delete the first P letters from strin 'Org'in the given order
      of indices[] only.
    - After deleting P letters, the string 'Sub' should be subsequence of 'Org'.
      Where, 0 <= i < P and P < R.
     
Your task is to maximixe the value of P such that 'Sub' is still a subsequence 
of 'Org' after the deletion of letters, and return P.

Input Format:
-------------
Line-1: Two space seperated strings, Original and Sub
Line-2: An integer, R, number of indices.
Line-3: R space separated integers, indices[].

Output Format:
--------------
Print an integer, the maximum value of P.


Sample Input-1:
---------------
pqrprq pr
3
3 1 0

Sample Output-1:
----------------
2

Explanation:
------------
After deleting 2 letters at indices 3 and 1, "pqrprq" becomes "prrq".
"pq" is a subsequence of "prrq".
If you delete 3 letters at indices 3, 1, and 0, "pqrprq" becomes "rrq", 
and "pq" is not a subsequence of "rrq".
Hence, the maximum P is 2.

Sample Input-2:
---------------
pqrqssss pqrs
6
3 2 1 4 5 6

Sample Output-2:
----------------
1

Explanation: 
------------
After deleting 1 letter at index 3, "pqrqssss" becomes "pqrssss".
"pqrs" is a subsequence of "pqrssss".
 */
import java.util.*;

public class day32_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String Org = sc.next();
        String Sub = sc.next();
        int R = sc.nextInt();

        int[] indices = new int[R];
        for (int i = 0; i < R; i++) {
            indices[i] = sc.nextInt();
        }

        System.out.println(maxDeletions(Org, Sub, indices));
    }

    public static int maxDeletions(String Org, String Sub, int[] indices) {
        int left = 0, right = indices.length, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isSubsequenceAfterDeletion(Org, Sub, indices, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isSubsequenceAfterDeletion(String Org, String Sub, int[] indices, int P) {
        Set<Integer> deleteSet = new HashSet<>();
        for (int i = 0; i < P; i++) {
            deleteSet.add(indices[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Org.length(); i++) {
            if (!deleteSet.contains(i)) {
                sb.append(Org.charAt(i));
            }
        }

        return isSubsequence(sb.toString(), Sub);
    }

    private static boolean isSubsequence(String org, String sub) {
        int i = 0, j = 0;
        while (i < org.length() && j < sub.length()) {
            if (org.charAt(i) == sub.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == sub.length();
    }
}
