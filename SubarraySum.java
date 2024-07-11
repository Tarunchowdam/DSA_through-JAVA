import java.util.HashSet;

public class SubarraySum {
    public static boolean hasZeroSumSubarray(int[] nums) {
        HashSet<Integer> sumSet = new HashSet<>();
        int cumulativeSum = 0;

        for (int num : nums) {
            cumulativeSum += num;

            if (cumulativeSum == 0 || sumSet.contains(cumulativeSum)) {
                return true;
            }

            sumSet.add(cumulativeSum);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, -3, 1, 6};
        System.out.println("Does the array have a subarray with sum zero? " + hasZeroSumSubarray(nums));
    }
}
