/*
 * Time Complexity: O(N log K) where N is the total number of elements in all the lists
 * Space Complexity: O(K)
 */
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // create a PriorityQueue for ListNodes
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, Comparator.comparingInt(n -> n.val));

        // result head
        ListNode head = new ListNode(0);
        ListNode ptr = head;


        // add the starting nodes of each of the lists to the PriorityQueue
        for (ListNode start : lists) {
            if (start != null) heap.add(start);
        }


        while (!heap.isEmpty()) {
            // set the next pointer of the result list to
            // the top of the PriorityQueue
            ptr.next = heap.poll();
            // move the pointer ahead
            ptr = ptr.next;

            // put the next element of the element just polled
            // into the PriorityQueue
            if (ptr.next != null) {
                heap.add(ptr.next);
            }
        }

        return head.next;
    }
}
