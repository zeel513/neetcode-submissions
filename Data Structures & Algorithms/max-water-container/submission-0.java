class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int result = -1;
        while(left < right) {
            int area = Math.min(heights[left], heights[right]) * (right-left);
            if(area > result) {
                result = area;
            }

            if(heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
