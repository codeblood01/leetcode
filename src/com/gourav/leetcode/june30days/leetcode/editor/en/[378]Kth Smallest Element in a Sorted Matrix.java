//Given an n x n matrix where each of the rows and columns is sorted in ascendin
//g order, return the kth smallest element in the matrix. 
//
// Note that it is the kth smallest element in the sorted order, not the kth dis
//tinct element. 
//
// You must find a solution with a memory complexity better than O(n2). 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//Output: 13
//Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the
// 8th smallest number is 13
// 
//
// Example 2: 
//
// 
//Input: matrix = [[-5]], k = 1
//Output: -5
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 300 
// -109 <= matrix[i][j] <= 109 
// All the rows and columns of matrix are guaranteed to be sorted in non-decreas
//ing order. 
// 1 <= k <= n2 
// 
//
// 
// Follow up: 
//
// 
// Could you solve the problem with a constant memory (i.e., O(1) memory complex
//ity)? 
// Could you solve the problem in O(n) time complexity? The solution may be too 
//advanced for an interview but you may find reading this paper fun. 
// 
// Related Topics Array Binary Search Sorting Heap (Priority Queue) Matrix 
// 👍 5081 👎 217

package com.gourav.leetcode.june30days.leetcode.editor.en;

import java.util.ArrayList;
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
        result[0] = minHeap.peek().val;
        result[1] = currentMax;
        while(minHeap.size()>= nums.size()){
            IndexValue  temp = minHeap.poll();
            if(nums.get(temp.listIndex).size()> temp.indexInList+1)
                minHeap.add(new IndexValue(temp.listIndex, temp.indexInList+1, nums.get(temp.listIndex).get(temp.indexInList+1)));
            else
                return result;
            if(nums.get(temp.listIndex).size()> temp.indexInList+1 && currentMax< nums.get(temp.listIndex).get(temp.indexInList+1))
                currentMax =   nums.get(temp.listIndex).get(temp.indexInList+1);
            if(result[1]-result[0]>currentMax-minHeap.peek().val){
                result[0] = minHeap.peek().val;
                result[1] = currentMax;
            }
            //System.out.println(result[0]+"----"+result[1]);
        }
        return result;
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
