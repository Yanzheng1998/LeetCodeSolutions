/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addHelper(l1 , l2 , 0);
    }
    
    private ListNode addHelper(ListNode l1 , ListNode l2, int carry) {
        ListNode l3;
        int nextCarry;
        
        // Basic step
        if (l1 == null && l2 == null) {
            if (carry == 0) {
                l3 = null;
                return l3;
            }
            else {
                l3 = new ListNode(1);
                return l3;
            }
        }
        
        // recursive steps
        else if (l1 == null) {
            l3 = new ListNode((l2.val + carry)%10);
          
            if (l2.val + carry > 9) 
                nextCarry = 1;
            else nextCarry = 0;
        
            l3.next = addHelper(null,l2.next, nextCarry);        
        
            return l3;
        }
        
        else if (l2 == null) {
            l3 = new ListNode((l1.val + carry)%10);
            
            if (l1.val + carry > 9) 
                nextCarry = 1;
            else nextCarry = 0;
            
            l3.next = addHelper(l1.next,null,nextCarry);
            
            return l3;
        }
            
        else {
            l3 = new ListNode((l1.val + l2.val + carry)%10);
            
            if (l1.val + l2.val + carry > 9) 
                nextCarry = 1;
            else nextCarry = 0;
            
            l3.next = addHelper(l1.next,l2.next,nextCarry);
            
            return l3;
        }
    }
}
