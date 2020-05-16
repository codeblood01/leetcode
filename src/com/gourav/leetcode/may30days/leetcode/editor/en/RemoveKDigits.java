
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
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<Character>();
        char arr[]=num.toCharArray();
        stack.add(arr[0]);
        String str="";
        boolean flag=false;
        for (int i = 1; i < arr.length; i++) {
            flag=true;
            while (k>0&&!stack.isEmpty()&&stack.peek()>arr[i]){
                stack.pop();
                k--;
            }
            stack.add(arr[i]);
        }
      while (k>0&&!stack.isEmpty()){
          stack.pop();
          k--;
      }
        while (!stack.isEmpty()){
            str=stack.pop()+str;
            k--;
        }
        String result=removeZero(str);
        return result.length()>0?result:"0";
    }
    public  String removeZero(String str)
        {
        // Count leading zeros
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0')
        i++;

        // Convert str into StringBuffer as Strings
        // are immutable.
        StringBuffer sb = new StringBuffer(str);

        // The  StringBuffer replace function removes
        // i characters from given index (0 here)
        sb.replace(0, i, "");

        return sb.toString();  // return in String
        }
}

//leetcode submit region end(Prohibit modification and deletion)
// below solution is not efficient as it takes O(n^2) time to build the matrix,though the approach encountered is very beautiful; we could have used segment tree in it too for get min for a range
//using segment tree complexity would be (log(n)*k)(FOR FINDING ANS)+ n*O(n)(FOR CREATION st)
//WE CAN USE  THE APPROACH KIND OF SIMILAR WE USED IN MAX RECTANGLE IN BAR GRAPH
//
//
//    int arr[]=new int[num.length()];
//    char charArr[]= num.toCharArray();
//          if(k==num.length())
//                  return "0";
//                  if(k==0)
//                  return num;
//                  for(int i=0; i < num.length();i++){
//        arr[i]=charArr[i]-'0';
//        }
//
//
//        String result="";
//        int start=0;
//        int i=(k);
//        while(arr.length-i>0){
//
//        //   System.out.println(i+" "+start+" "+" "+matrix[start][i]+" "+arr[matrix[start][i]]);
//        result+=arr[minIndex(arr,start,i)];
//        start=minIndex(arr,start,i)+1;
//        i++;
//        }
//        return removeZero(result).length()==0?"0":removeZero(result);
//
//        }
//public int minIndex(int[] arr,int left,int right){
//        int min= left;
//        for(int i=left;i<=right;i++){
//        if (arr[i]<arr[min]){
//        min=i;
//        }
//
//        }
//        return min;
//        }

//        }
//
	