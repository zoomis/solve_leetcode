/* My idea
 * To use a hashtable to remember the index of the second number to make a target.
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (table.get(nums[i]) != null) {
                return new int[] {table.get(nums[i]), i};
            } else {
                table.put(target-nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}