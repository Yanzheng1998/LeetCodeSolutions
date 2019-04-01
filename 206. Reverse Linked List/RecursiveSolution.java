/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RecursiveSolution {
    ListNode reverse(ListNode node,ListNode prev) {
        if (node.next == null) {
            node.next = prev;
            return node;
        }
        ListNode temp_next = node.next;
        node.next = prev;
        return reverse(temp_next,node);
    }
    public ListNode reverseList(ListNode head) {
        if (head==null) return head;
        return reverse(head,null);
        
    }
}
