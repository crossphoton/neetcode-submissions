class Solution {
    private boolean check(long bitMap, int index) {
        return (bitMap & (1 << index)) > 0;
    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        double pow2n = Math.pow(2, n);

        for (long i=0; i<pow2n; i++) {
            List<Integer> current = new ArrayList<>();

            for (int j=0; j<n; j++) {
                if (check(i, j)) {
                    current.add(nums[j]);
                }
            }

            result.add(current);
        }

        return result;
    }
}
