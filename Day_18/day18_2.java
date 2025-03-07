/*In the quiet town of Eldoria, a famous treasure was said to be hidden somewhere, waiting to be discovered. 
Many adventurers had tried to find it, but none had succeeded. 
One day, two explorers, Arin and Mira, discovered an ancient scroll in the town library.

The scroll contained a long passage filled with cryptic words. 
The legend said that the treasure's location could only be revealed if they correctly determined 
the shortest distance between two special words in the passage.

They read the passage carefully:
"The old castle stood on the highest hill, where knights once trained with their mighty swords. 
A golden key was hidden under the ancient oak tree, and the villagers often spoke of its mysterious glow. 
Legends told of a secret passage deep beneath the ground, leading to the lost chest that contained priceless jewels and forgotten artifacts."

Mira pointed at the scroll excitedly. "We need to find the word 'key' and the word 'chest' and count the words between them!"
Arin quickly scanned the passage. 
The word "key" appeared at position 19, and the word "chest" was at position 50.
"The shortest distance between them is 30 words!" he exclaimed.

The moment he spoke the answer, the scroll shimmered, and a hidden compartment in the library wall slid open. 
Inside, they found an old map leading them to the treasure buried deep within the Whispering Woods.

Their journey had just begun, but thanks to their keen observation and ability to measure the shortest path between two words, 
they were one step closer to uncovering Eldoria’s greatest mystery!

Example 1:
Input =apple banana cherry goa apple watermelon juice date
apple date
Output = 2 */

import java.util.*;

public class day18_2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String a = sc.next();
        String b = sc.next();
        int start = -1;
        int end = -1;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(a)) {
                start = i;
            }
            if (s[i].equals(b)) {
                end = i;
            }
            if (start != -1 && end != -1) {
                min = Math.min(min, Math.abs(end - start)-1);
            }
        }
        System.out.println(min);
   }
}
