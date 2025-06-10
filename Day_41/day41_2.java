/*In a distant galaxy, an ancient civilization built a hierarchical communication network of interconnected relay stations. 
The structure of this network can be reconstructed using two ancient data logs:

Beacon Activation Order (analogous to in-order traversal)
Final Signal Sent Order (analogous to post-order traversal)
Using these logs, we can reconstruct the original relay network and process queries about signals reaching specific hierarchical levels.

Given the Beacon Activation Order and the Final Signal Sent Order of a galactic communication network, reconstruct the relay network. 
After reconstructing the hierarchy, and the output should list the relay stations in the order they appear in a level-wise transmission sequence.

Input Format:
-------------
An integer N representing the number of relay stations in the network.
A space-separated list of N integers representing the Beacon Activation Order (similar to in-order traversal).
A space-separated list of N integers representing the Final Signal Sent Order (similar to post-order traversal).

Output Format:
--------------
For each query, print the relay stations in order of their signal transmissions within the given depth range

Sample Input:
-------------
7
4 2 5 1 6 3 7
4 5 2 6 7 3 1
Sample Output:
---------------
[1, 2, 3, 4, 5, 6, 7]


Explanation:
The logs correspond to the following hierarchical relay network:
        1
       / \
      2   3
     / \  / \
    4   5 6  7
The level order is : 1 2 3 4 5 6 7  */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class day41_2 {
    static int postIndex;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
        }
        
        int[] postorder = new int[n];
        for (int i = 0; i < n; i++) {
            postorder[i] = sc.nextInt();
        }
        
        // Create map for quick inorder index lookup
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }
        
        postIndex = n - 1; // Start from the end for postorder
        TreeNode root = buildTree(postorder, inMap, 0, n - 1);
        
        // Level order traversal
        List<Integer> result = levelOrder(root);
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(result.get(i));
        }
        System.out.println("]");
    }
    
    static TreeNode buildTree(int[] postorder, Map<Integer, Integer> inMap, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        
        int inIndex = inMap.get(rootVal);
        
        // Build right subtree first, then left (opposite of preorder)
        root.right = buildTree(postorder, inMap, inIndex + 1, inEnd);
        root.left = buildTree(postorder, inMap, inStart, inIndex - 1);
        
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