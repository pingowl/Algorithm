import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int max=0, cnt=0, h=0;
        int[] arr = new int[10001];
        
        for(int i=0; i<citations.length; i++){
            arr[citations[i]]++;
            if(citations[i] > max) max = citations[i];
        }
        for(int i=max; i>=0; i--){
            cnt += arr[i];
            if(i >= cnt && h < cnt)
                h = cnt;
            else if(i < cnt && h < i)
                h = i;
        }
        
        
        return h;
    }
}