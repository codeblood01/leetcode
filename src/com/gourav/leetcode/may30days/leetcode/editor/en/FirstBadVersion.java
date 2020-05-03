
package com.gourav.leetcode.may30days.leetcode.editor.en;

//You are a product manager and currently leading a team to develop a new produc
//t. Unfortunately, the latest version of your product fails the quality check. Si
//nce each version is developed based on the previous version, all the versions af
//ter a bad version are also bad.
//
// Suppose you have n versions [1, 2, ..., n] and you want to find out the first
// bad one, which causes all the following ones to be bad.
//
// You are given an API bool isBadVersion(version) which will return whether ver
//sion is bad. Implement a function to find the first bad version. You should mini
//mize the number of calls to the API.
//
// Example:
//
//
//Given n = 5, and version = 4 is the first bad version.
//
//call isBadVersion(3) -> false
//call isBadVersion(5) -> true
//call isBadVersion(4) -> true
//
//Then 4 is the first bad version. 
//
// Related Topics Binary Searchl

//package com.gourav.leetcode.may30days.leetcode.editor.en;

//leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        int mid=(1+n)/2 ;
        int start=1;
        int end=n;
        boolean ans=false;
        int result=isBadVersion(mid)?mid:-1; // which api was first faulty we were greedy to find the answer
        while(start<end){
            mid=start+(end-start)/2;// written like this as start+end may overflow,
            ans=isBadVersion(mid);
            if(ans){
                result=mid;
                end=mid;
            }
            else{
                start=mid+1;
            }
            result=isBadVersion(start)?start:result;

        }
        return result;
    }

}

// not using method :- when true is found checking its left is true/false to return answer quickly as it might
//                     increase api calls.
// example case :- 1 1 1 1 1 1 1 1 1 will make more api calls then not hurrying to find out the answer.
