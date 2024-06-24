import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[][] sol = {{1, 2, 3, 4, 5},
                      {2, 1, 2, 3, 2, 4, 2, 5},
                      {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] cnt = {0,0,0};
        
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<3; j++){
                if(sol[j][i % (sol[j].length)] == answers[i])
                    cnt[j]++;
            }
        }
        int max = Math.max(Math.max(cnt[0], cnt[1]), cnt[2]);
        for(int i=0; i<3; i++){
            if(cnt[i] == max)
                answer.add(i+1);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}