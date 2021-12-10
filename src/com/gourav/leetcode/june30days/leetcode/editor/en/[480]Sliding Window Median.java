//The median is the middle value in an ordered integer list. If the size of the 
//list is even, there is no middle value. So the median is the mean of the two mid
//dle values. 
//
// 
// For examples, if arr = [2,3,4], the median is 3. 
// For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5. 
// 
//
// You are given an integer array nums and an integer k. There is a sliding wind
//ow of size k which is moving from the very left of the array to the very right. 
//You can only see the k numbers in the window. Each time the sliding window moves
// right by one position. 
//
// Return the median array for each window in the original array. Answers within
// 10-5 of the actual value will be accepted. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
//Explanation: 
//Window position                Median
//---------------                -----
//[1  3  -1] -3  5  3  6  7        1
// 1 [3  -1  -3] 5  3  6  7       -1
// 1  3 [-1  -3  5] 3  6  7       -1
// 1  3  -1 [-3  5  3] 6  7        3
// 1  3  -1  -3 [5  3  6] 7        5
// 1  3  -1  -3  5 [3  6  7]       6
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
//Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 105 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics Array Hash Table Sliding Window Heap (Priority Queue) 
// 👍 1856 👎 117

package com.gourav.leetcode.june30days.leetcode.editor.en;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        ArrayList<Double> arr=new ArrayList<>();
        int sizeChecker=0;
        int left=0; boolean windowsize=false; boolean isEven = k%2==0?true:false;
        maxHeap.add(nums[0]);
        if(k==1) {
            double restur[]=new double[nums.length];
            for (int i = 0; i <nums.length ; i++) {
                restur[i]= nums[i];
            }
            return restur;
        }
        for (int i = 1; i < nums.length; i++) {
            //System.out.println(minHeap+" "+maxHeap+" "+minHeap.peek()+" "+maxHeap.peek());

            if(i-left+1<k){
                    maxHeap.add(nums[i]);

            }else{
                if(maxHeap.peek()!=null&&nums[i]>=maxHeap.peek())
                minHeap.add(nums[i]);
                else if(maxHeap.peek()!=null&&nums[i]<=maxHeap.peek())
                    maxHeap.add(nums[i]);
                else
                    minHeap.add(nums[i]);
                if(isEven==true){
                    if(maxHeap.size()==minHeap.size()){
                        arr.add(Double.valueOf((maxHeap.peek()/2.0+minHeap.peek()/2.0)));
                    }else{
                        sizeChecker= minHeap.size()-maxHeap.size();
                        while (sizeChecker!=0){
                            if(sizeChecker<0)
                                    minHeap.add(maxHeap.poll());
                            else
                                    maxHeap.add(minHeap.poll());
                            sizeChecker=minHeap.size()-maxHeap.size();
                        }
                        arr.add((maxHeap.peek()/2.0+minHeap.peek()/2.0));
                    }
                    //System.out.println(minHeap+" "+maxHeap+" "+arr);
                }else{
                    sizeChecker= minHeap.size()-maxHeap.size();
                   // System.out.println(sizeChecker+"meee "+minHeap+" "+maxHeap+" "+minHeap.peek()+" "+maxHeap.peek());

                    if(sizeChecker==1 || sizeChecker==-1){
                        if(sizeChecker<0)
                            arr.add(Double.valueOf(maxHeap.peek()));
                        else
                            arr.add(Double.valueOf(minHeap.peek()));
                    }else{
                        while(Math.abs(sizeChecker)!=1){

                            if(sizeChecker<-1)
                                minHeap.add(maxHeap.poll());
                            else
                                maxHeap.add(minHeap.poll());
                            sizeChecker=minHeap.size()-maxHeap.size();
                        }

                        if(sizeChecker<0)
                            arr.add(Double.valueOf(maxHeap.peek()));
                        else
                            arr.add(Double.valueOf(minHeap.peek()));
                    }
                }

                windowsize= minHeap.remove(nums[left])==true?true:maxHeap.remove(nums[left]);
                left++;

            }
           // System.out.println(minHeap+" "+maxHeap+" "+minHeap.peek()+" "+maxHeap.peek());

        }
        double arrResult[]=new double[arr.size()];
        for (int i = 0; i <arr.size() ; i++) {
            arrResult[i]=arr.get(i).doubleValue();
        }

            return arrResult;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
