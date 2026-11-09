class Solution {
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
  int[] A = nums1.length <= nums2.length ? nums1 : nums2;
                  int[] B = nums1.length <= nums2.length ? nums2 : nums1;
                  int n = A.length, m = B.length;
                  int total = n + m;
                  int left = 0, right = n;
                  int half = (total + 1) / 2;

                  while (left <= right) {
                                int i = (left + right) / 2; // elements in A left
                                int j = half - i;          // elements in B left

                                int Aleft  = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
                                int Aright = (i == n) ? Integer.MAX_VALUE : A[i];
                                int Bleft  = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
                                int Bright = (j == m) ? Integer.MAX_VALUE : B[j];

                                if (Aleft <= Bright && Bleft <= Aright) {
                                         if (total % 2 == 1) {
                                                  return (double)Math.max(Aleft, Bleft);
                                         } else {
                                                  return ((double)Math.max(Aleft, Bleft) + (double)Math.min(Aright, Bright)) / 2.0;
                                         }
                                } else if (Aleft > Bright) {
                                         right = i - 1;
                                } else {
                                         left = i + 1;
                                }
                  }

                  return 0.0; // guard
         }
}