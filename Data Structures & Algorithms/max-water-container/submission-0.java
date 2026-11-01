class Solution {
    public int maxArea(int[] heights) {
        int maxAr=0;
        int i=0;
        int j=heights.length-1;
       while(j>0){
            int area = Math.min(heights[i],heights[j])* (j-i);
            if(area>maxAr)maxAr=area;
            if(heights[i]<heights[j]){
                i++;
            }
            else {
                j--;
            }
        }
        return maxAr;
    }
}
