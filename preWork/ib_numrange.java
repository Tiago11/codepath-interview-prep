/*
Given an array of non negative integers A, and a range (B, C),
find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C

Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
where 0 <= i <= j < size(A)

Example :

A : [10, 5, 1, 0, 2]
(B, C) : (6, 8)
ans = 3
as [5, 1], [5, 1, 0], [5, 1, 0, 2] are the only 3 continuous subsequence with their sum in the range [6, 8]

 NOTE : The answer is guranteed to fit in a 32 bit signed integer.
*/

// Java 7.
public int numRange(int[] A, int B, int C) {

        // Check if A is null or empty.
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException("Array A is null or empty.");
        }

        // Check if B is greater than C.
        if (B > C) {
            throw new IllegalArgumentException("B cannot be greater than C.");
        }

        int counterSubSeq = 0;
        int currentValue = 0;

        int start = 0;
        int end = 0;

        // We keep track of where we start forming a valid sequence, we try to form
        // the longest valid sequence from there. After that we move the start and
        // start again.
        while (start < A.length) {

            currentValue += A[start];
            if (currentValue >= B && currentValue <= C) {
                counterSubSeq++;
            }
            end++;
            while (end < A.length && currentValue <= C) {
                currentValue += A[end];
                if (currentValue >= B && currentValue <= C) {
                    counterSubSeq++;
                }
                end++;
            }
            currentValue = 0;
            start++;
            end = start;

        }

        return counterSubSeq;
    }
