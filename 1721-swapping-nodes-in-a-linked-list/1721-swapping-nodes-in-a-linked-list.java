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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head, slow= head;
        ListNode first =head , sec=head;
        
        for(int i=0 ;i<k-1;i++)
        {
            fast=fast.next;
        }
        first=fast;
        
        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        sec=slow;
        
        int temp;
        
        temp=first.val;
        first.val=sec.val;
        sec.val=temp;
        
      return head;  
    }
}