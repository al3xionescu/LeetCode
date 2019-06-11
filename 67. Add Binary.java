/*
Given two binary strings, return their sum (also a binary string).
The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
*/

class Solution {
    public String addBinary(String a, String b) {
        int la = a.length();
        int lb = b.length();
        int max = Math.max(la, lb);
        StringBuilder sum = new StringBuilder("");
        int carry = 0;
        for (int i = 0; i < max; i++) {
            int m = getBit(a, la - i - 1);
            int n = getBit(b, lb - i - 1);
            int add = m + n + carry;
            sum.append(add % 2);
            carry = add / 2;
        }
        if (carry == 1) {
            sum.append("1");
        }
        return sum.reverse().toString();
    }
    public int getBit(String s, int index) {
        if (index < 0 || index >= s.length()) {
            return 0;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        return 1;
    }
}
