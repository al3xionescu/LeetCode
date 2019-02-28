/*
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.

Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
*/

class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        std::vector<string> res;
        int start = 0, end = 0;
        size_t i = 0;
        while(i < nums.size()) {
            start = nums[i];
            do {
                i++;
            } while(i < nums.size() && nums[i] == nums[i - 1] + 1);
            end = nums[i - 1];
            if (start == end) {
                res.emplace_back(std::to_string(start));
            }
            else {
                res.emplace_back(std::to_string(start) + "->" + std::to_string(end));
            }
        }
        return res;
    }
};
