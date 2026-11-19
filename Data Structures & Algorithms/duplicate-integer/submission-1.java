class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> isPresent = new HashMap<>();

        for (int i=0; i < nums.length; i++) {
            if (isPresent.containsKey(nums[i])) {
                return true;
            }
            isPresent.put(nums[i], true);
        }

        return false;
    }
}