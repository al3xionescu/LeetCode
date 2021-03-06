/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3

Example 2:

Input: [3,4,-1,1]
Output: 2

Example 3:

Input: [7,8,9,11,12]
Output: 1
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }
        int res = 1;
        while (res <= Integer.MAX_VALUE) {
            if (map.containsKey(res)) {
                res++;
            }
            else {
                return res;
            }
        }
        return res;
    }
}
