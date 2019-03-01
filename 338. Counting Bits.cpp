/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]

Example 2:

Input: 5
Output: [0,1,1,2,1,2]
*/

class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> res = {0};
        for (int i = 1; i <= num; i++) {
            int n = i;
            int count = 0;
            while(n) {
                count += n & 1;
                n >>= 1; 
            }
            res.emplace_back(count);
        }
        return res;
    }
};
