class Solution {
    public int[] topKFrequent(int[] nums, int k) {
            int [] res = new int [k];
            HashMap<Integer,Integer> mp = new HashMap<>();
            for (int i : nums) {
                if (mp.containsKey(i)) {
                    mp.put(i, mp.get(i) + 1);
                } else {
                    mp.put(i, 1);
                }
            }

            PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> mp.get(a) - mp.get(b));

             for (int key : mp.keySet()) {
                 minHeap.add(key);
                  if (minHeap.size() > k) {
                minHeap.poll();
            
            }
    }
            for (int i = k - 1; i >= 0; i--) {
            res[i] = minHeap.poll(); 
        }

        return res;

}
}