/* 92. Reverse Linked List II

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
*/ 



class Solution {
public:
    ListNode* th = NULL , *tt = NULL; // th -> temp head , tt-> temp tail 
    
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode* dum = new ListNode(-1); 
        dum->next = head; 
        ListNode* p = dum; 
        ListNode* curr = dum->next ; 
        int i = 1 ; 
        //ListNode th = NULL , *tt = NULL; // th -> temp head , tt-> temp tail 
        
        while(true){
            // reverse zone 
            while(i >= left and i <= right){
                ListNode* f = curr->next; 
                curr->next = NULL; 
                addFirst(curr); 
                curr= f ; 
                i++; 
            }
            // after reverse zone 
            if(i>right){
            p->next = th; 
            tt->next = curr; 
            break; 
            }
            // left part before entering reverse zone 
            p = curr; 
            curr = curr->next; 
            i++; 
        }
        return dum->next; 
    }
    void addFirst(ListNode* curr){
        if(th ==NULL){
            th = tt = curr; 
        }else{
            curr->next= th; 
            th = curr; 
        }
    }
};