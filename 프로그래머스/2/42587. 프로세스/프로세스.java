import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: priorities){
            pq.offer(i);
        }
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(pq.peek() == priorities[i]){
                    answer++;
                    pq.poll();
                    if(i == location)
                        return answer;
                }
            }
        }
        return answer;
    }
}