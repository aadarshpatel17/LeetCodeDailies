package org.practise.dsa_training.day1;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while(left < right) {
            int h = Math.min(height[left], height[right]);
            int l = right - left;
            int crtMax = h * l;
            max = Math.max(max, crtMax);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
