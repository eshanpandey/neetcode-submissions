class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> x = new HashSet<Integer>();
        for( int i = 0; i< nums.length; i++){
            if (x.contains(nums[i]))return true;
            else x.add(nums[i]);
        }
        return false;
    }
}