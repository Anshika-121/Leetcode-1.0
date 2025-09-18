class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       List<List<Integer>> graph = new ArrayList<>();
       int [] indegree = new int[numCourses];

       for(int i=0 ; i< numCourses;i++ ){
        graph.add(new ArrayList<>());
       } 

       for(int[] pre: prerequisites){
        int course = pre[0];
        int prereq =  pre[1];
        graph.get(prereq).add(course);
        indegree[course]++;
       }

       Queue<Integer> queue = new LinkedList<>();
       for(int i = 0 ;i < numCourses;i++){
        if(indegree[i] == 0){
            queue.offer(i);
        }
       }
       int[] result = new int[numCourses];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;
            
            for (int neighbor : graph.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        // Step 4: Check if all courses processed
        if (index == numCourses) {
            return result;
        } else {
            return new int[0]; // Cycle detected
        }
            
    }
}