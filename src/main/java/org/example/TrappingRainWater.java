package org.example;

/*
    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

    Example :

    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array
    [0,1,0,2,1,0,1,3,2,1,2,1].
    In this case, 6 units of rain water (blue section) are being trapped.
*/


public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] arr2 = {4, 2, 0, 3, 2, 3};
        int rainWaterTrapped = trap(arr2);
        System.out.println("Rain Water Trapped = " + rainWaterTrapped);
    }

    private static int trap(int[] arr) {
        int leftMax = 0, rightMax = 0;
        int left = 0, right = arr.length - 1;
        int trappedWater = 0;
        while (left <= right) {
            if (arr[left] < arr[right]) {
                if (arr[left] > leftMax) {
                    leftMax = arr[left];
                } else {
                    trappedWater += (leftMax - arr[left]);
                }
                left++;
            } else {
                if (arr[right] > rightMax) {
                    rightMax = arr[right];
                } else {
                    trappedWater += (rightMax - arr[right]);
                }
                right--;
            }
        }

        return trappedWater;
    }
}


/*
    1. This approach uses left and right pointers to avoid redundant calculations.

    2. Initialize trapped_water, leftMax, and rightMax to 0 .

    3. Initialize left pointer to 0 and right pointer to the last index: of the height array.

    4. While left is less than right:
        Update leftMax and rightMax: leftMax = max(leftMax, height[left]) and rightMax = max(rightMax, height[right]).
        Compare leftMax and rightMax:
            If leftMax < rightMax:
                Water trapped at the left pointer is determined by leftMax.
                Add leftMax - height[left] to trapped_water and move the left pointer one step to the right.
            Else (rightMax <= leftMax):
                Water trapped at the right pointer is determined by rightMax.
                Add rightMax - height[right] to trapped_water and move the right pointer one step to the left.
    5. Return trapped_water .
 */
