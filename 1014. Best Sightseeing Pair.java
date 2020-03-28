/*
Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot, and two sightseeing spots i and j 
have distance j - i between them.

The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) : the sum of the values of the sightseeing spots, minus
the distance between them.

Return the maximum score of a pair of sightseeing spots.

Example:

Input: [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
*/

class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int store[] = new int[A.length];
        int max = 0;
        for (int i = 0; i < A.length - 1; i++) {
            max = Math.max(max, A[i] + i);
            store[i] = max;
        }
        int res = Integer.MIN_VALUE;
        for (int i = A.length - 1; i >= 1; i--) {
            res = Math.max(res, A[i] - i + store[i - 1]);
        }
        return res;
    }
}
