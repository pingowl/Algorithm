import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String s: operations){
            String[] sp = s.split(" ");
            
            if(sp[0].equals("I")){
                int i = Integer.parseInt(sp[1]);
                pqMin.offer(i);
                pqMax.offer(i);
                
            } else if (sp[1].equals("1") && !pqMax.isEmpty()){  
                pqMin.remove(pqMax.poll());
            } else if (!pqMin.isEmpty()){          
                pqMax.remove(pqMin.poll());
            }
        }
        
        if(!pqMax.isEmpty()){
            answer[0] = pqMax.poll();
            answer[1] = pqMin.poll();
        }
        
        return answer;
    }
}