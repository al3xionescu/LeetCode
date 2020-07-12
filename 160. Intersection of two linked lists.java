/* Write a program to find the node at which the intersection of two singly linked lists begins. */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        map<ListNode*, int> m;
        ListNode* pa = headA;
        while(pa) {
            m[pa]++;
            pa = pa -> next;
        }
        ListNode* pb = headB;
        while(pb) {
            if (m.find(pb) != m.end()) {
                return pb;
            }
            pb = pb -> next;
        }
        return nullptr;
    }
};
