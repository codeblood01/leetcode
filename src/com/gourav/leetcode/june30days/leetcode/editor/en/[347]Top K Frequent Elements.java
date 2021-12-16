//Given an integer array nums and an integer k, return the k most frequent eleme
//nts. You may return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// Example 2: 
// Input: nums = [1], k = 1
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// k is in the range [1, the number of unique elements in the array]. 
// It is guaranteed that the answer is unique. 
// 
//
// 
// Follow up: Your algorithm's time complexity must be better than O(n log n), w
//here n is the array's size. 
// Related Topics Array Hash Table Divide and Conquer Sorting Heap (Priority Que
//ue) Bucket Sort Counting Quickselect 
// 👍 6739 👎 315

package com.gourav.leetcode.june30days.leetcode.editor.en;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.SortedMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int result[]=new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> topK = new PriorityQueue<>((a,b)->Integer.compare(a.frequency,b.frequency));
        for (int i = 0; i < nums.length ; i++) {
            if(map.containsKey(nums[i]))   map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        for (int key:
             map.keySet()) {
            if (topK.size()<k) {
                topK.add(new Pair(key, map.get(key)));
            }
            else {

                if (topK.peek().frequency<map.get(key)){
                    topK.poll();
                    topK.add(new Pair(key,map.get(key)));
                }
            }
          //  System.out.println(key+"-----"+map.get(key));
           // System.out.println(topK.peek().frequency+"====="+topK.peek().value);

        }
        for (int i = 0; i < k; i++) {
            result[i]=topK.poll().value;
        }
        return result;
    }
}
 class Pair{
     int value;
     int frequency;
    public Pair(int value,int frequency){
        this.value=value;
        this.frequency=frequency;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
