class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            if (m.containsKey(nums[i])) {
                m.put(nums[i], m.get(nums[i]) + 1);
            } else {
                m.put(nums[i], 1);
            }
        }


        while (m.keySet().size() > k) {
            List<Integer> keys = new ArrayList<>(m.keySet());

            for (int i=0; i<keys.size(); i++) {
                m.put(keys.get(i), m.get(keys.get(i)) - 1);
                if (m.get(keys.get(i)) == 0) {
                    m.remove(keys.get(i));
                }
            }
        }
        
        return m.keySet().stream().mapToInt(Integer::intValue).toArray();
    }
}
