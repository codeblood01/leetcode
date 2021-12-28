//You have k lists of sorted integers in non-decreasing order. Find the smallest
// range that includes at least one number from each of the k lists. 
//
// We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a
// < c if b - a == d - c. 
//
// 
// Example 1: 
//
// 
//Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
//Output: [20,24]
//Explanation: 
//List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
//List 2: [0, 9, 12, 20], 20 is in range [20,24].
//List 3: [5, 18, 22, 30], 22 is in range [20,24].
// 
//
// Example 2: 
//
// 
//Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
//Output: [1,1]
// 
//
// 
// Constraints: 
//
// 
// nums.length == k 
// 1 <= k <= 3500 
// 1 <= nums[i].length <= 50 
// -105 <= nums[i][j] <= 105 
// nums[i] is sorted in non-decreasing order. 
// 
// Related Topics Array Hash Table Greedy Sliding Window Sorting Heap (Priority 
//Queue) 
// 👍 1855 👎 31

package com.gourav.leetcode.june30days.leetcode.editor.en;

import java.util.List;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<IndexValue> minHeap = new PriorityQueue<>((a, b)-> Integer.compare(a.val,b.val));
        int currentMax =Integer.MIN_VALUE;
        int[] result = new int[2];
        result[0] = 1; result[1]= currentMax;
        for(int i =0; i<nums.size(); i++){
            minHeap.add(new IndexValue(i, 0 , nums.get(i).get(0)));
            if(currentMax<nums.get(i).get(0)) currentMax =  nums.get(i).get(0);
        }
        while(minHeap.size()>= nums.size()){
            IndexValue  temp = minHeap.poll();
            if(nums.get(temp.listIndex).size()>= temp.indexInList+1)
                minHeap.add(new IndexValue(temp.listIndex, temp.indexInList+1, nums.get(temp.listIndex).get(temp.indexInList+1)));
            if(currentMax<  nums.get(temp.listIndex).get(temp.indexInList+1))
            currentMax =   nums.get(temp.listIndex).get(temp.indexInList+1);
            if(result[1]-result[0]>currentMax-minHeap.peek().val){
                result[0] = minHeap.peek().val;
                result[1] = currentMax;
            }
        }
    }
}
class IndexValue{
    int listIndex;
    int indexInList;
    int val;
    public IndexValue(int listIndex,int indexInList, int val){
        this.listIndex = listIndex;
        this.indexInList = indexInList;
        this.val = val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
