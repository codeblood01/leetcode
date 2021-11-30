//Given an array of intervals where intervals[i] = [starti, endi], merge all ove
//rlapping intervals, and return an array of the non-overlapping intervals that co
//ver all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics Array Sorting 
// 👍 10485 👎 450

package com.gourav.leetcode.june30days.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Stack<Pair> result = new Stack<Pair>();
        sortArrayOnStart(intervals);
        result.push(new Pair(intervals[0][0],intervals[0][1]));
        for (int i = 0; i < intervals.length-1;i++) {
                if(result.peek().value<intervals[i+1][0]){
                    result.push(new Pair(intervals[i+1][0],intervals[i+1][1]));

                }else{
                    Pair temp = result.pop();
                    if (temp.value<intervals[i+1][1])
                            result.push(new Pair(temp.key,intervals[i+1][1]));
                    else
                        result.push(new Pair(temp.key,temp.value));
                }
        }
        int [][] finalResult= new int[result.size()][2];
        int i =0;
        Pair tempo;
        while (!result.isEmpty()){
            tempo=result.pop();
            finalResult[i][0]=tempo.key;
            finalResult[i][1]=tempo.value;
            i++;
        }
        return finalResult;
    }

    public int[][] sortArrayOnStart(int[][] intervals){
        Arrays.sort(intervals, (a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        return intervals;
    }

}
class Pair {
    int key;
    int value;

    public Pair(int key, int value) //Constructor of the class
    {
        this.key = key;
        this.value = value;
    }

}


//leetcode submit region end(Prohibit modification and deletion)
