class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> isPresent = new HashMap<Integer, Integer>();

        for (int i=0; i < nums.length; i++) {
            if (isPresent.containsKey(nums[i])) {
                return true;
            }
            isPresent.put(nums[i], 1);
        }

        return false;
    }
}