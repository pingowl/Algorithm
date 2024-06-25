import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2)-> o1[1]-o2[1]);
        int cam = -30001;
        for(int[] route: routes){
            if(cam < route[0]){
                cam = route[1];
                answer++;
            }
        }        
        return answer;
    }
}