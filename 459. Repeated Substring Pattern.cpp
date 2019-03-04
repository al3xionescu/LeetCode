/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.

Example 2:

Input: "aba"
Output: False

Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/

class Solution {
public:
    bool repeatedSubstringPattern(string str) {
        if (str.size() <= 1) {
            return false;
        }
        for (int len = 1; len <= str.size()/2; len++) {
            if (check(str, len)) {
                return true;
            }
        }
        return false;
    }
    bool check(string str, int len) {
        if (str.size() % len != 0) {
            return false;
        }
        for (int i = 0; i < str.size(); i++) {
            if (str[i] != str[(i+len)%str.size()]) {
                return false;
            }
        }
        return true;
    }
};
