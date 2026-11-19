class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> isPresent = new HashSet<>();

        for (int i=0; i < nums.length; i++) {
            if (isPresent.contains(nums[i])) {
                return true;
            }
            isPresent.add(nums[i]);
        }

        return false;
    }
}