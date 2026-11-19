class Solution {
    public int getVolume(int[] heights, int i, int j) {
        return Math.min(heights[i], heights[j]) * (j - i);
    }

    // [1,7,2,5,12,3,500,500,7,8,4, 7, 3, 6]
    // 0 1 2 3  4 5   6   7 8 9 10 11 12 13

    public int maxArea(int[] heights) {
        int leftIndex = 0, rightIndex = heights.length - 1;
        int maxVol = getVolume(heights, leftIndex, rightIndex);

        while (leftIndex < rightIndex) {
            System.out.print("(" + leftIndex + ", " + rightIndex + ") | ");
            maxVol = Math.max(maxVol, getVolume(heights, leftIndex, rightIndex));
            if (heights[leftIndex] < heights[rightIndex])
                leftIndex++;
            else
                rightIndex--;
        }

        return maxVol;
    }
}
