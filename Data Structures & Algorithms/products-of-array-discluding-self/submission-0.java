class Solution {
    public int[] productExceptSelf(int[] nums) {
        long overall = 1;
        int zeroCount = 0;
        int zeroLastIndex = 0;
        for(int i=0; i<nums.length; i++) {
            overall *= nums[i];
            if (nums[i] == 0) {zeroCount++; zeroLastIndex = i;}
        }

        int[] result = new int[nums.length];

        if (zeroCount > 1) return result;
        if (zeroCount == 1) {
            overall = 1;
            for (int i=0; i<nums.length; i++) {
                if (i == zeroLastIndex) continue;
                overall *= nums[i];
            }
            result[zeroLastIndex] = (int) overall;

            return result;
        }

        for(int i=0; i<nums.length; i++) {
            result[i] = (int) (overall / nums[i]);
        }

        return result;
    }
}  
