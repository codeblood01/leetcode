
//Given a non-negative integer num represented as a string, remove k digits from
// the number so that the new number is the smallest possible.
// 
//
// Note: 
// 
// The length of num is less than 10002 and will be ≥ k. 
// The given num does not contain any leading zero. 
// 
//
// 
//
// Example 1:
// 
//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 w
//hich is the smallest.
// 
// 
//
// Example 2:
// 
//Input: num = "10200", k = 1
//Output: "200"
//Explanation: Remove the leading 1 and the number is 200. Note that the output 
//must not contain leading zeroes.
// 
// 
//
// Example 3:
// 
//Input: num = "10", k = 2
//Output: "0"
//Explanation: Remove all the digits from the number and it is left with nothing
// which is 0.
// 
// Related Topics Stack Greedy
	
package com.gourav.leetcode.may30days.leetcode.editor.en;

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        HashMap<Integer,Integer > indexMap = new HashMap<>();
        int arr[]=new int[num.length()];
        char charArr[]= num.toCharArray();
        if(k==num.length())
            return "0";
        for(int i=0; i < num.length();i++){
            arr[i]=charArr[i]-'0';
            indexMap.
        }
    }
}
class SegmentTreeRMQ {
    int st[]; //array to store segment tree 

    // A utility function to get minimum of two numbers 
    int minVal(int x, int y) {
        return (x < y) ? x : y;
    }

    // A utility function to get the middle index from corner 
    // indexes. 
    int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    /*  A recursive function to get the minimum value in a given 
        range of array indexes. The following are parameters for 
        this function. 
  
        st    --> Pointer to segment tree 
        index --> Index of current node in the segment tree. Initially 
                   0 is passed as root is always at index 0 
        ss & se  --> Starting and ending indexes of the segment 
                     represented by current node, i.e., st[index] 
        qs & qe  --> Starting and ending indexes of query range */
    int RMQUtil(int ss, int se, int qs, int qe, int index) {
        // If segment of this node is a part of given range, then 
        // return the min of the segment 
        if (qs <= ss && qe >= se)
            return st[index];

        // If segment of this node is outside the given range 
        if (se < qs || ss > qe)
            return Integer.MAX_VALUE;

        // If a part of this segment overlaps with the given range 
        int mid = getMid(ss, se);
        return minVal(RMQUtil(ss, mid, qs, qe, 2 * index + 1),
                RMQUtil(mid + 1, se, qs, qe, 2 * index + 2));
    }

    // Return minimum of elements in range from index qs (query 
    // start) to qe (query end).  It mainly uses RMQUtil() 
    int RMQ(int n, int qs, int qe) {
        // Check for erroneous input values 
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }

        return RMQUtil(0, n - 1, qs, qe, 0);
    }

    // A recursive function that constructs Segment Tree for 
    // array[ss..se]. si is index of current node in segment tree st 
    int constructSTUtil(int arr[], int ss, int se, int si) {
        // If there is one element in array, store it in current 
        //  node of segment tree and return 
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }

        // If there are more than one elements, then recur for left and 
        // right subtrees and store the minimum of two values in this node 
        int mid = getMid(ss, se);
        st[si] = minVal(constructSTUtil(arr, ss, mid, si * 2 + 1),
                constructSTUtil(arr, mid + 1, se, si * 2 + 2));
        return st[si];
    }

    /* Function to construct segment tree from given array. This function 
       allocates memory for segment tree and calls constructSTUtil() to 
       fill the allocated memory */
    void constructST(int arr[], int n) {
        // Allocate memory for segment tree 

        //Height of segment tree 
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        //Maximum size of segment tree 
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_size]; // allocate memory 

        // Fill the allocated memory st 
        constructSTUtil(arr, 0, n - 1, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
	