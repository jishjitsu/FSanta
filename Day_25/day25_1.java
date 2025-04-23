/*In the heart of a dense and ancient forest, a group of explorers stumbles upon a mysterious stone tablet. 
Inscribed on it is a puzzle that must be solved to reveal the path to a hidden treasure.
The tablet contains a list of n magical numbers — some positive, some negative, and some neutral — scattered across its surface. 
These numbers are known to react to a mystical energy frequency called the Target.
To activate the treasure map, the explorers must find exactly three numbers from the tablet such that their combined energy is as close as
possible to the Target frequency.
> "Only one combination of three numbers exists," reads a line on the stone, "whose total will come closest to the energy I seek."

Can you help the explorers find the closest sum of three numbers that awakens the ancient path?

---

 Input
 ------

 A list of integers carved into the stone: nums, where 3 <= nums.length <= 500.
An integer target representing the mystical frequency.

 Goal
 -----
Find three numbers from nums whose sum is closest to target. Return that sum.
.
Example 1:
----------

Stone Numbers: [-1, 2, 1, -4]  
Target Frequency: 1  
Output: 2  
> The sum closest to the target is 2 (from -1 + 2 + 1).

---
Example 2:
----------

Stone Numbers: [0, 0, 0]  
Target Frequency: 1  
Output: 0  
> Even though the target is 1, the only possible sum is 0, which is the closest.

---
Constraints
------------

 -1000 <= nums[i] <= 1000  
 -10⁴ <= target <= 10⁴ */

 