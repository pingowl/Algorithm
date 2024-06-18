import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        List<Integer> list = new ArrayList<>();
        int[] days = new int[n];
        for(int i=0; i<n; i++){
            double calc = (100-progresses[i]) / (double)speeds[i];
            days[i] = (int)Math.ceil(calc);
        }
        
        for(int i=0; i<n; i++){
            int cnt=1;
            if(i != n-1){
                int tmp=i;
                for(int j = i+1; j<n; j++){
                    if(days[i] >= days[j]){
                        cnt++;
                        tmp = j;
                    } else {
                        break;
                    }
                }
                i = tmp;
            }
            list.add(cnt);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}