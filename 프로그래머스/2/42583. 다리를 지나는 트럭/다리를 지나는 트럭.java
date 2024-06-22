import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int w = 0, idx = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<bridge_length; i++){
            q.add(0);
        }
        while(q.peek() != null){
            answer++;
            w -= q.poll();
            if(idx < truck_weights.length && w + truck_weights[idx] <= weight){
                w += truck_weights[idx];
                q.add(truck_weights[idx++]);
            } else if (idx < truck_weights.length){
                q.add(0);
            }
        }
        
        
        return answer;
    }
}