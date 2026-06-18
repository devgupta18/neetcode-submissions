class Solution {
    public int[] twoSum(int[] n, int target) {
        int[] ans = new int[2];
        int i=0, j=n.length-1;
        while(i < j) {
            int sum = n[i] + n[j];
            if(target == sum) {
                ans[0] = i+1;
                ans[1] = j+1;
                break;
            }
            else if(target < sum) j--;
            else i++;
        }

        return ans;
    }
}
