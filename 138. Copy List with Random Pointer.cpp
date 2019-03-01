/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.

Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.

Note:
    You must return the copy of the given head as a reference to the cloned list.
*/

class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        unordered_map <RandomListNode*, RandomListNode*> map;
        RandomListNode* current = head;
        while(current) {
            map[current] = new RandomListNode(current -> label);
            current = current -> next;
        }
        current = head;
        while(current) {
            map[current] -> next = map[current -> next];
            map[current] -> random = map[current -> random];
            current = current -> next;
        }
        return map[head];
        
    }
};
