/*package Day_26;

public Barnaby loved finding hidden words in his big storybook. He had a special list of his favorite words.
For each favorite word he found in the story, he would write down where it began and where it ended.
Can you help Barnaby find all his favorite words and their starting and ending spots in the storybook?

Example 1:
----------
input= 
thestoryofleetcodeandme
story fleet leetcode

Output=
3 7
9 13 
10 17

Example 2:
----------
input= 
ababa
aba ab
output=
0 1 
0 2 
2 3
2 4

Explanation: 
Notice that matches can overlap, see "aba" is found in [0,2] and [2,4].

Note: Input formate is string and followed by substring ,
      Output print starting and ending index pairs.
 {
    
}*/

import java.util.*;

public class day26_1 {
    static final int NUM_CHARS = 26;
    
    // Trie node structure
    static class TrieNode {
        TrieNode[] children = new TrieNode[NUM_CHARS];
        boolean isEndOfWord;
        String word; // Store the complete word for easy retrieval
        
        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < NUM_CHARS; i++)
                children[i] = null;
            word = null;
        }
    }
    
    static TrieNode root;
    
    // Insert a word into the trie
    static void insert(String key) {
        int length = key.length();
        TrieNode currentNode = root;
        
        for (int i = 0; i < length; i++) {
            int index = key.charAt(i) - 'a';
            if (currentNode.children[index] == null)
                currentNode.children[index] = new TrieNode();
            
            currentNode = currentNode.children[index];
        }
        
        // Mark last node as leaf and store the word
        currentNode.isEndOfWord = true;
        currentNode.word = key;
    }
    
    // Find all occurrences of each word in the text
    static void findAllOccurrences(String text, List<int[]> results) {
        int n = text.length();
        
        // Start a search from each position in the text
        for (int i = 0; i < n; i++) {
            TrieNode node = root;
            
            // Try to match starting from position i
            for (int j = i; j < n; j++) {
                int index = text.charAt(j) - 'a';
                
                // If there's no matching path in the trie, break
                if (node.children[index] == null)
                    break;
                
                node = node.children[index];
                
                // If this is the end of a word, add to results
                if (node.isEndOfWord) {
                    int startIndex = i;
                    int endIndex = j;
                    results.add(new int[]{startIndex, endIndex});
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the text and words to find
        String text = sc.nextLine();
        String[] words = sc.nextLine().split(" ");
        
        // Initialize trie
        root = new TrieNode();
        
        // Construct trie from the words to find
        for (String word : words) {
            insert(word);
        }
        
        // Find all occurrences
        List<int[]> results = new ArrayList<>();
        findAllOccurrences(text, results);
        
        // Sort results by start index (and then by end index if needed)
        Collections.sort(results, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        // Print results
        for (int[] result : results) {
            System.out.println(result[0] + " " + result[1]);
        }
    }
}
