/*
 * Time complexity: O(n log k)
 * Space complexity: O(k)
 */
import java.util.PriorityQueue;

public class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        // min heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int n: nums) {
            heap.add(n);
            // we maintain size k
            if(heap.size() > k) heap.remove();
        }
        // after all elements have been processed,
        // the element on top of the heap will be kth largest
        return heap.peek();
    }
}
