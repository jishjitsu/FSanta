/* write a program to count the GrandChild/Child for given name 

Assume the relations here limit only to child and grandChild only 

All the inputs will be given in lower case characters(a-z) and are valid relations 

The first line of input consists of number of relations followed by child name and fathers name 
seperated by ',' 
followed by a name. 

Where the first string is "Child", second string is "Father".
If the given name is Father print the count of his childrean
If the given name is GrandFather print the count of his GrandChild

Print -1 for any other boundary conditions 

for given input like this

input =
5
kishore,ramesh
dev,gopal
gopal,ramu
srinu,gopal
praveen,ranjit
ramu
output = 2

And given input "ramu" we have to find his no of grandchildren/child
Here "ramu" has one direct child gopal and gopal has 2 children(dev,srinu).
So ramu has 2 grand children dev,srinu. so output is 2

example:2 

input =
5
ranjit,knr
ramesh,pradeep
kittu,ranjit
yogesh,ranjit
praveen,ranjit
knr
output=
3

//given data for knr we need print the count of grand childern. 
here knr direct child ranjit and ranjit has three children   ---- kittu,yogesh,praveen so print 3


input = 
8
a,b
c,b
d,b
f,a
g,a
e,a
m,c
z,d
b
output =
5 */

import java.util.*;

public class day23_2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int relations = sc.nextInt();
        sc.nextLine();
        Map<String, List<String>> parentToChild = new HashMap<>();
        Set<String> allChildren = new HashSet<>();
        
        for (int i = 0; i < relations; i++) {
            String[] relation = sc.nextLine().split(",");
            String child = relation[0];
            String parent = relation[1];
            
            parentToChild.putIfAbsent(parent, new ArrayList<>());
            parentToChild.get(parent).add(child);
            allChildren.add(child);
        }
        
        String target = sc.nextLine();
        
        if (!parentToChild.containsKey(target)) {
            System.out.println(-1);
            return;
        }
        
        List<String> children = parentToChild.get(target);
        if (children == null || children.isEmpty()) {
            System.out.println(0);
            return;
        }

        int grandChildCount = 0;
        for (String child : children) {
            if (parentToChild.containsKey(child)) {
                grandChildCount += parentToChild.get(child).size();
            }
        }
        
        if(grandChildCount==0){System.out.println(-1); return;}
        System.out.println(grandChildCount);
        sc.close();
    }
}
