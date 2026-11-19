class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> existsMap = new HashMap<>();

        int[] result = new int[2];

        for (int i=0; i<nums.length; i++) {
            if (existsMap.containsKey(nums[i])) {
                result[1] = i;
                result[0] = existsMap.get(nums[i]);
                break;
            }

            existsMap.put(target - nums[i], i);
        }

        return result;
    }
}
