/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head){
        
        if(head==null ||head.next==null)
            return;
 ListNode prev = null, slow = head, fast = head, l1 = head;
      
      while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
      }
      
      prev.next = null;
      
      // step 2. reverse the 2nd half
      ListNode l2 = reverse(slow);
      
      // step 3. merge the two halves
      merge(l1, l2);
    }
    
  ListNode reverse(ListNode head) {
      ListNode prev = null, curr = head, next = null;
      
      while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }
      
      return prev;
    }
void merge(ListNode l1, ListNode l2) {
      while (l1 != null) {
        ListNode n1 = l1.next, n2 = l2.next;
        l1.next = l2;
        
        if (n1 == null)
          break;
            
        l2.next = n1;
        l1 = n1;
        l2 = n2;
      }
    }

    
}