class Solution {
    public int maxProfit(int[] prices) {
        int miniEle = prices[0], ans = -1;
        if(prices.length == 1) return 0;

        for(int i=0; i<prices.length; i++) {
            if(prices[i] < miniEle) miniEle = prices[i];
            else ans = Math.max(ans, prices[i] - miniEle);
        }

        return ans;
    }
}
