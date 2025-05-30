/*
Write a Java Code using Suffix Trie to Count the Distinct Substrings for the given input string 

input = hello
output = 14

Distinct Substrings for the word hello

"h", "he", "hel", "hell", "hello",
"e", "el", "ell", "ello",
"l", "ll", "llo",
"lo", "o"

*/
import java.util.*;

class day28_1
{
	// A Suffix Trie (A Trie of all suffixes) Node
	static class SuffixTrieNode
	{
		static final int MAX_CHAR = 26;
		SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR];

		SuffixTrieNode() // Constructor
		{
			// Initialize all child pointers as NULL
			for (int i = 0; i < MAX_CHAR; i++)
				children[i] = null;
		}

		// A recursive function to insert a suffix of the s in
		// subtree rooted with this node
		void insertSuffix(String s)
		{
			System.out.println("string " +  s);
			// If string has more characters
			if (s.length() > 0)
			{
				// Find the first character and convert it into 0-25 range.
				char cIndex = (char) (s.charAt(0) - 'a');

				// If there is no edge for this character, add a new edge
				if (children[cIndex] == null)
				{
					children[cIndex] = new SuffixTrieNode();
				}

				// Recur for next suffix
				children[cIndex].insertSuffix(s.substring(1));
			}
		}
	}
	
	// A Trie of all suffixes
	static class Suffix_trie
	{
		static final int MAX_CHAR = 26;
		SuffixTrieNode root;

		// Constructor (Builds a trie of suffies of the given text)
		Suffix_trie(String s) 
		{
			root = new SuffixTrieNode();

			// Consider all suffixes of given string and insert them into the 
			// Suffix Trie using recursive function insertSuffix() in SuffixTrieNode class
			for (int i = 0; i < s.length(); i++)
				root.insertSuffix(s.substring(i));
		}

		// A recursive function to count nodes in trie
		int countNodesInTrie(SuffixTrieNode node)
		{
			// If all characters of pattern have been processed,
			if (node == null)
				return 0;

			int count = 0;
			for (int i = 0; i < MAX_CHAR; i++) {

				// if children is not NULL then find count of all nodes in this subtrie
				if (node.children[i] != null)
					count += countNodesInTrie(node.children[i]);
			}

			// return count of nodes of subtrie and plus
			// 1 because of node's own count
			System.out.println("count " + count);
			return (1 + count);
		}

		// method to count total nodes in suffix trie
		int countNodesInTrie()
		{
			return countNodesInTrie(root);
		}
	}

	// Returns count of distinct substrings of str
	static int countDistinctSubstring(String str)
	{
		// Construct a Trie of all suffixes
		Suffix_trie sTrie = new Suffix_trie(str);

		// Return count of nodes in Trie of Suffixes
		return sTrie.countNodesInTrie();
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any string to construct suffix tree");
		String str=sc.nextLine();		

		System.out.println("Count of distinct substrings is "
				+ (countDistinctSubstring(str) - 1));
		
	}
}
/*
Distinct Substrings for the word hello

"h", "he", "hel", "hell", "hello",
"e", "el", "ell", "ello",
"l", "ll", "llo",
"lo", "o"



hello
(root)
 └── h
     └── e
         └── l
             └── l
                 └── o
ello
(root)
 ├── h
 │   └── e
 │       └── l
 │           └── l
 │               └── o
 └── e
     └── l
         └── l
             └── o

llo


(root)
 ├── h
 │   └── e
 │       └── l
 │           └── l
 │               └── o
 ├── e
 │   └── l
 │       └── l
 │           └── o
 └── l
     └── l
         └── o

lo


o

(root)
 ├── h
 │   └── e
 │       └── l
 │           └── l
 │               └── o
 ├── e
 │   └── l
 │       └── l
 │           └── o
 ├── l
 │   └── l
 │       └── o
 └── o



*/


