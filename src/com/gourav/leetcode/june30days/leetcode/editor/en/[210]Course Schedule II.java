//There are a total of numCourses courses you have to take, labeled from 0 to nu
//mCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
// 
//
// 
// For example, the pair [0, 1], indicates that to take course 0 you have to fir
//st take course 1. 
// 
//
// Return the ordering of courses you should take to finish all courses. If ther
//e are many valid answers, return any of them. If it is impossible to finish all 
//courses, return an empty array. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you shou
//ld have finished course 0. So the correct course order is [0,1].
// 
//
// Example 2: 
//
// 
//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you shou
//ld have finished both courses 1 and 2. Both courses 1 and 2 should be taken afte
//r you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3
//].
// 
//
// Example 3: 
//
// 
//Input: numCourses = 1, prerequisites = []
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// All the pairs [ai, bi] are distinct. 
// 
// Related Topics Depth-First Search Breadth-First Search Graph Topological Sort
// 
// 👍 5745 👎 218

package com.gourav.leetcode.june30days.leetcode.editor.en;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,Node> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        if(prerequisites.length == 0){
            int arrr[]= new int[numCourses];
            while(numCourses>0) {
                arrr[numCourses-1] = numCourses-1;
                numCourses--;
            }
            return arrr;
        }
        for(int i =0; i< prerequisites.length; i++){
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1],new Node(0, new ArrayList<Integer>()));
                map.get(prerequisites[i][1]).outNodes.add(prerequisites[i][0]);

            }else{
                map.get(prerequisites[i][1]).outNodes.add(prerequisites[i][0]);
            }
            if(!map.containsKey(prerequisites[i][0]))
                map.put(prerequisites[i][0], new Node(1, new ArrayList<Integer>()));
            else
                map.get(prerequisites[i][0]).inDegreeCount+=1;
        }
        // for(Map.Entry<Integer, Node> entry : map.entrySet()){
        //     System.out.println(entry.getKey()+" "+entry.getValue().inDegreeCount+" "+entry.getValue().outNodes);
        // }
        int k=0;
        List<Integer> list  = new ArrayList<>(map.keySet());
        while(!list.isEmpty()){
            // if(k<list.size())
            //System.out.println(list.get(k)+" "+map.get(list.get(k)).inDegreeCount+" "+map.get(list.get(k)).outNodes);
            if(k==list.size()) return new int[0];
            if(map.get(list.get(k)).inDegreeCount==0){
                for(Integer index : map.get(list.get(k)).outNodes){
                    map.get(index).inDegreeCount--;
                }
                result.add(list.get(k));
                list.remove(k);
                k=0;
                continue;
            }
            k++;
        }
        for(int i =0; i< numCourses; i++) {
            if(!map.containsKey(i))
                result.add(i);
        }
        int resultFinal[] =  new int[numCourses];
        for(int i =0; i< result.size(); i++) resultFinal[i] = result.get(i);

        return resultFinal;
    }
}
class Node{
    int inDegreeCount;
    List<Integer> outNodes;
    public Node(int inDegreeCount,List<Integer> outNodes){
        this.inDegreeCount = inDegreeCount;
        this.outNodes = outNodes;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
