class Solution {
    public int trap(int[] h) {
        int water = 0, left=0, right=h.length-1, leftMax=0, rightMax=0;

        while(left <= right) {
            if(leftMax <= rightMax) {
                leftMax = Math.max(leftMax, h[left]);
                int temp = leftMax - h[left];
                water += temp > 0 ? temp : 0;
                left++;
            } else {
                rightMax = Math.max(rightMax, h[right]);
                int temp = rightMax - h[right];
                water += temp > 0 ? temp : 0;
                right--;
            }
        }

        return water;
    }
}
