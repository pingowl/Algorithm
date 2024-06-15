import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] dist = new int[n+1];
        
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());
        for(int i=0; i<edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(q.size() != 0){
            int now = q.poll();
            ArrayList<Integer> nodes = graph.get(now);
            for(int i : nodes){
                if(visited[i] == false){
                    visited[i] = true;
                    q.add(i);
                    dist[i] = dist[now]+1;
                }
            }
        }
        Arrays.sort(dist);
        int MAX = dist[n];
        for(int i=n; dist[i] == MAX; i--){
            answer++;
        }
        
        return answer;
    }
}