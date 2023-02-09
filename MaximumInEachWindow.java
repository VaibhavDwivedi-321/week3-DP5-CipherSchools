import java.util.Deque;
import java.util.LinkedList;

public class MaximumInEachWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

public static void main(String[] args) {
    int[] nums = {1,3,-1,-3,5,3,6,7};
    int k = 3;

    int[] result = maxSlidingWindow(nums, k);
    for (int i : result) {
        System.out.print(i + " ");
    }
    System.out.println();
}
}