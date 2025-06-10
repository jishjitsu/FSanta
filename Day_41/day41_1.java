/*In a distant future, humanity has begun interstellar colonization, establishing zones of habitation and control on a new planet. 
Scientists have recorded two types of data regarding how these zones were structured:

1. Survey Order (analogous to pre-order traversal) – This record details how the colonization started, with the first zone established and
then expanding into new zones following a systematic approach.
2. Planetary Layout (analogous to in-order traversal) – This document shows how zones were positioned relative to each other on the map,
based on territorial boundaries.

Using this information, scientists need to reconstruct the colonization hierarchy (binary tree of zones) and display them level wise.

Input Format:
--------------
An integer N representing the number of zones colonized.
A space-separated list of N integers representing the Planetary Layout Order (in-order).
A space-separated list of N integers representing the Survey Order ( pre-order ).

Output Format:
---------------
Print all zone IDs in level order:

Sample Input:
-------------
7
4 2 5 1 6 3 7
1 2 4 5 3 6 7

Sample Output:
---------------
3 2 4 5 6 7

Explanation:
The given Planetary Layout (in-order) and Survey Order (pre-order) correspond to the following colonization hierarchy:
        1
       / \
      2   3
     / \  / \
    4   5 6  7

Level Order: [1, 2, 3, 4, 5, 6, 7]
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class day41_1 {
    static int preIndex = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
        }
        
        int[] preorder = new int[n];
        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }
        
        // Create map for quick inorder index lookup
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }
        
        TreeNode root = buildTree(preorder, inMap, 0, n - 1);
        
        // Level order traversal
        List<Integer> result = levelOrder(root);
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result.get(i));
        }
        System.out.println();
    }
    
    static TreeNode buildTree(int[] preorder, Map<Integer, Integer> inMap, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        
        int inIndex = inMap.get(rootVal);
        
        root.left = buildTree(preorder, inMap, inStart, inIndex - 1);
        root.right = buildTree(preorder, inMap, inIndex + 1, inEnd);
        
        return root;
    }
    
    static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        
        return result;
    }
}