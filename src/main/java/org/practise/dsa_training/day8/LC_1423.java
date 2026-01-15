package org.practise.dsa_training.day8;

public class LC_1423 {

    // 1423. Maximum Points You Can Obtain from Cards
    public int maxScore(int[] cardPoints, int k) {
        int maxSum = 0, leftSum = 0, rightSum = 0;
        // sum of first k-elements
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        maxSum = leftSum;

        // we are removing the element from left (k-1) and adding the right element (n-1)
        // then, we are updating maxSum;
        int right = cardPoints.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[right];
            right = right - 1;
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }

}
