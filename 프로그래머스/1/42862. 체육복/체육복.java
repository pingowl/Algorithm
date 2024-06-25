import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(reserve);
        
        int[] arr = new int[n+1];
        for(int i: lost){
            arr[i]++;
        }
        // 여분 체육복 있는 학생이 도난당했는지 먼저 확인한다
        for(int i=0; i<reserve.length; i++){
            if(arr[reserve[i]]==1){
                answer++;
                arr[reserve[i]]=0;
                reserve[i]=0;
            }
        }
        for(int i: reserve){
            if(i==0) {
                continue;
            } else if(arr[i-1]==1){
                answer++;
                arr[i-1]=0;
            } else if(i<n && arr[i+1]==1){
                answer++;
                arr[i+1]=0;
            }
        }
        
        
        return answer;
    }
}