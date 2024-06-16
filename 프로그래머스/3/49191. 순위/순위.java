class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] floyd = new int[n+1][n+1];
        
        for(int[] edge: results){
            floyd[edge[0]][edge[1]] = 1;
            floyd[edge[1]][edge[0]] = -1;
        }
        
        for(int start=1; start<=n; start++){
            for(int dest=1; dest<=n; dest++){
                for(int tmp=1; tmp<=n; tmp++){
                    if(floyd[start][tmp]==1 && floyd[tmp][dest]==1){
                        floyd[start][dest] = 1;
                        floyd[dest][start] = -1;
                    }
                    else if(floyd[start][tmp]==-1 && floyd[tmp][dest]==-1){
                        floyd[start][dest] = -1;
                        floyd[dest][start] = 1;
                    }
                }
            }
        }
        
        // n명의 선수가 있을 때, 각 선수는 n-1번의 승패를 알 수 있어야 순위를 확정 지을 수 있다. 
        for(int i=1; i<=n; i++){
            int cnt= 0;
            for(int j: floyd[i]){
                if(j != 0) cnt++;
            }
            if(cnt == n-1) answer++;
        }
              
        return answer;
    }
}