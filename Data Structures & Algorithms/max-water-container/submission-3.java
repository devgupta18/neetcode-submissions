class Solution {
    public int maxArea(int[] h) {
        int maxArea = -1, i=0, j=h.length-1;

        while(i < j) {
            int smaller = h[i] < h[j] ? h[i] : h[j], gap = j - i;
            int area = smaller * gap;

            maxArea = Math.max(area, maxArea);

            if(h[i] == smaller) i++;
            else j--;
        }

        return maxArea;
    }
}
