/*/*Mr.Sathya is playing with numbers he converts the decimal to binary and try to find number of positions at which the corresponding bits are different. Help sathya by giving solution to the problem to find sum of bits differences between all the pairs of the integers in given numbers.
Input
	Number of integers and List of integers
output
	Return the sum of bit differences between all the pairs of the integers.
 
Example 1:

Input:
3
4 14 2
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

Example 2:
Input: 
3
4 14 4
Output: 4*/

/*

Calculate the XOR of two numbers.
Count the number of set bits.
*/