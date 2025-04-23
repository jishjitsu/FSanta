/*In the mystical lands of Eltheria, an ancient order of alchemists crafts powerful 
potions using rare Prime Essences. Each essence corresponds to a prime number, 
and the potency of a potion is determined by combining the powers of the first n Prime Essences.

The potion's base power is calculated by multiplying the first n prime numbers together.

However, Eltheria’s magical forces are unstable, and the final potion power is influenced by 
the alignment of the mystical elements. The alchemist must apply an Effect to the potion before 
completing it. Each effect alters the potion’s power in a unique way:

NORMAL — The potion retains its base power.

FULL — During the full moon, potion power doubles!

NEW — During the new moon, the power decreases slightly (reduce by 1).

LUCKY_DAY — Luck blesses the alchemist, and potion power increases by n.

CURSED — A curse weakens the potion, halving its power.

MAGIC_SURGE — Magic overflows, adding the sum of all Prime Essences used to the potion power.

Input
------
An integer n — the number of Prime Essences used in the potion.

A string effect — the effect to be applied to the potion 
(one of the following: NORMAL, FULL, NEW, LUCKY_DAY, CURSED, MAGIC_SURGE).

Output:
--------
The list of Prime Essences used (in ascending order).

The final potion power after applying the effect.

Constraints
------------
1 ≤ n ≤ 100

Effect string is always uppercase and valid.

Input 1
-------
3
NORMAL

Output 1
---------
[2, 3, 5]
30

Input 2
-------
4
FULL

Output 2
--------
[2, 3, 5, 7]
420 */