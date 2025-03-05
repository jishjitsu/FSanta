/*Shankuntala  a maths student a given a set of N numbers, and was asked to to perform the operations listed below:

1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.

Your task is to solve this problem using Fenwick Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input-1:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		//sumRange
1 0 7		//sumRange
2 2 18	//update
2 4 17	//update
1 2 7		//sumRange

Sample Output-1:
----------------
75
86
80



Sample Input-2:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		
1 0 7		
2 2 18	
2 4 17	
1 0 7

Sample Output-2:
----------------
75
86
83

 */

 import java.util.*;

class FenwickTree {
    private int[] bit, arr;
    private int n;

    public FenwickTree(int[] input) {
        this.n = input.length;
        this.bit = new int[n + 1];
        this.arr = Arrays.copyOf(input, n);
        for (int i = 0; i < n; i++) add(i + 1, input[i]);
    }

    private void add(int index, int value) {
        for (; index <= n; index += index & -index) bit[index] += value;
    }

    public void update(int index, int value) {
        add(index + 1, value - arr[index]);
        arr[index] = value;
    }

    private int sum(int index) {
        int res = 0;
        for (; index > 0; index -= index & -index) res += bit[index];
        return res;
    }

    public int sumRange(int start, int end) {
        return sum(end + 1) - sum(start);
    }
}

public class day17_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        FenwickTree fenwick = new FenwickTree(arr);
        while (q-- > 0) {
            int op = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
            if (op == 1) System.out.println(fenwick.sumRange(x, y));
            else fenwick.update(x, y);
        }
    }
}
