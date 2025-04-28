/*import java.util.*;
public class day26_3{
    public static void main(String[] args){
        Map<String, Integer> m = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String[] s = sc.next().split(",");
        int n = sc.nextInt();
        
        for(String word: s){
            m.put(word, m.getOrDefault(word,0)+1);
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(m.entrySet());
        
        list.sort((a, b) -{
            if (b.getValue().equals(a.getValue())){
            return a.getKey().compareTo(b.getKey());
            } 
            else{
                return b.getValue() - a.getValue();
            }
        });
        
        for(int i=0; i<n ;i++){
            System.out.print(list.get(i).getKey()+" ");
        }
    }
} */
import java.util.*;
public class day26_3{
    public static void main(String[] args){
        Map<String, Integer> m = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String[] s = sc.next().split(",");
        int n = sc.nextInt();
        
        for(String word: s){
            m.put(word, m.getOrDefault(word,0)+1);
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(m.entrySet());
        
        list.sort((a, b) -> {
            if (b.getValue().equals(a.getValue())){
            return a.getKey().compareTo(b.getKey());
            } 
            else{
                return b.getValue() - a.getValue();
            }
        });
        
        for(int i=0; i<n ;i++){
            System.out.print(list.get(i).getKey()+" ");
        }
    }
}
 //with trie
 /*import java.util.*;

class Trie {
    Trie[] children = new Trie[26];
    boolean isWord;
}

class TrieHelper {
    Trie root = new Trie();
    Map<String, Integer> freqMap = new HashMap<>();

    public void addWord(String word) {
        Trie curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Trie();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public List<String> getTopWords(int p) {
        List<String> words = new ArrayList<>(freqMap.keySet());

        Collections.sort(words, (a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            if (freqA != freqB) {
                return freqB - freqA; 
            } else {
                return a.compareTo(b);
            }
        });

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < p && i < words.size(); i++) {
            ans.add(words.get(i));
        }
        return ans;
    }
}

public class day26_3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String arr[] = sc.nextLine().split(",");
        int p = sc.nextInt();

        TrieHelper helper = new TrieHelper();

        for (String word : arr) {
            helper.addWord(word);
            helper.freqMap.put(word, helper.freqMap.getOrDefault(word, 0) + 1);
        }

        List<String> topWords = helper.getTopWords(p);
        System.out.println(topWords);
    }
}
 */