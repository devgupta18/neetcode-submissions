class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i=1, j=-1, ans=-1;
        for(int k=0; k<piles.length; k++) {
            j = piles[k] > j ? piles[k] : j;
        }

        while(i <= j) {
            int mid = i - (i - j)/2;
            int count = 0;
            for(int k=0; k<piles.length; k++) {
                count += (piles[k] + mid - 1) / mid;
            }
            if(count <= h) {
                ans = mid;
                j = mid - 1;
            } else{
                i = mid + 1;
            }
        }
        return ans;
    }
}
