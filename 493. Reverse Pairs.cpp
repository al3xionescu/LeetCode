/*
Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

You need to return the number of important reverse pairs in the given array.

Example1:

Input: [1,3,2,3,1]
Output: 2

Example2:

Input: [2,4,3,5,1]
Output: 3

Note:

    The length of the given array will not exceed 50,000.
    All the numbers in the input array are in the range of 32-bit integer.
*/

class Solution {
public:
    int count = 0;
    void checkCount(vector<int>& nums, int start, int mid, int end) {
        int l = start, r = mid + 1;
        while(l <= mid && r <= end) {
            if((long)nums[l] > (long) 2*nums[r]) {
                count += (mid - l + 1);
                r++;
            }
            else {
                l++;
            }
        }
        sort(nums.begin() + start, nums.begin() + end + 1);
        return;
    }
    void mergeSort(vector<int>& nums, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        checkCount(nums, start, mid, end);
        return;
    }
    int reversePairs(vector<int>& nums) {
        if(!nums.size()) 
            return 0;
        count = 0;
        mergeSort(nums, 0, nums.size() - 1);
        return count;
    }
};
