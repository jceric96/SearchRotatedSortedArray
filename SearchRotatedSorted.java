public class SearchRotatedSorted {
    // O(logn)
    // nums[mid]==target, found.
    // nums[begin]>nums[mid](case1):
    // nums[mid]< target <nums[begin] =>[mid+1,end]
    // nums[begin]<nums[mid](case2):
    // nums[begin]<target<nums[mid] =>[begin,mid-1]
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[begin] <= nums[mid]) {
                if (nums[begin] <= target && target < nums[mid]) {
                    end = mid;
                } else {
                    begin = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    begin = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[begin] == target) {
            return begin;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        SearchRotatedSorted search = new SearchRotatedSorted();
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(search.search(nums, 5));
        System.out.println(search.search(nums, 8));
    }
}
