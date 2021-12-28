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
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<CoordinateValue> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a.val,b.val));

        List<Integer> result = new ArrayList<Integer>();
        for(int i =0 ; i<matrix.length; i++){
            minHeap.add(new CoordinateValue(i,0,matrix[i][0]));
        }
        while(result.size()<k){
            CoordinateValue temp = minHeap.poll();
            result.add(temp.val);
            if(temp.y+1<matrix.length)
                minHeap.add(new CoordinateValue(temp.x,temp.y+1,matrix[temp.x][temp.y+1]));
        }
        System.out.println(result);

        return result.get(k-1);
    }
}

class CoordinateValue{
    int x;
    int y;
    int val;

    public CoordinateValue(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
