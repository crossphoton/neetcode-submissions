class KthLargest {

    private PriorityQueue<Integer> q = new PriorityQueue<>();
    Integer k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i=0; i<nums.length; i++) {
            q.add(nums[i]);
        }

        while (q.size() > k) {
            q.poll();
        }
    }
    
    public int add(int val) {
        q.add(val);

        while(q.size() > this.k)
            q.poll();

        return q.peek();
    }
}
