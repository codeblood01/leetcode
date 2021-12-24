//Given a characters array tasks, representing the tasks a CPU needs to do, wher
//e each letter represents a different task. Tasks could be done in any order. Eac
//h task is done in one unit of time. For each unit of time, the CPU could complet
//e either one task or just be idle. 
//
// However, there is a non-negative integer n that represents the cooldown perio
//d between two same tasks (the same letter in the array), that is that there must
// be at least n units of time between any two same tasks. 
//
// Return the least number of units of times that the CPU will take to finish al
//l the given tasks. 
//
// 
// Example 1: 
//
// 
//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation: 
//A -> B -> idle -> A -> B -> idle -> A -> B
//There is at least 2 units of time between any two same tasks.
// 
//
// Example 2: 
//
// 
//Input: tasks = ["A","A","A","B","B","B"], n = 0
//Output: 6
//Explanation: On this case any permutation of size 6 would work since n = 0.
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//And so on.
// 
//
// Example 3: 
//
// 
//Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//Output: 16
//Explanation: 
//One possible solution is
//A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle ->
// idle -> A
// 
//
// 
// Constraints: 
//
// 
// 1 <= task.length <= 104 
// tasks[i] is upper-case English letter. 
// The integer n is in the range [0, 100]. 
// 
// Related Topics Array Hash Table Greedy Sorting Heap (Priority Queue) Counting
// 
// 👍 5866 👎 1104

package com.gourav.leetcode.june30days.leetcode.editor.en;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0) return tasks.length;
        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)->Integer.compare(b.getValue(),a.getValue()));
        Queue<Map.Entry<Character,Integer>> queue = new LinkedList<>();
        int result =0; int k = n+1;
        for (int i = 0; i < tasks.length; i++) {
            if(!map.containsKey(tasks[i])) map.put(tasks[i],1);
            else map.put(tasks[i],map.get(tasks[i])+1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        while (!pq.isEmpty()){
            k=n+1;
                queue = new LinkedList<>();
                for (;k>0&&!pq.isEmpty();k--){
                    result++;
                    Map.Entry<Character,Integer> entry = pq.poll();
                    if (entry.getValue()>1){
                        entry.setValue(entry.getValue()-1);
                        queue.add(entry);
                    }
                }
                pq.addAll(queue);
                if (!pq.isEmpty())  result+=k;
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
