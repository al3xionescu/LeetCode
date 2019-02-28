/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/

class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        std::vector<int> solution(nums.size(), 0);
        for (const auto& elem : nums) {
            solution[elem - 1]++;
        }
        int k = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (solution[i] == 2) {
                solution[k++] = i + 1;
            }
        }
        solution.resize(k);
        return solution;
    }
};
