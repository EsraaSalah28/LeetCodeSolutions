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
public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummy = new ListNode(0), cur = dummy;
    if (lists == null || lists.length < 1) {
        return null;
    }
    PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
        public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val;
        }    
    });
    for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null) {
            minHeap.offer(lists[i]);
        }
    }
    while (!minHeap.isEmpty()) {
        ListNode temp = minHeap.poll();
        cur.next = temp;
        if (temp.next != null) {
            minHeap.offer(temp.next);
        }
        cur = temp;
    }
    return dummy.next;
}
}