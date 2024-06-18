import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i: arr){
            if(stack.empty() || stack.peek() != i) 
                stack.push(i);
        }
        int[] answer = new int[stack.size()];
        int j=0;
        for(int a: stack){
            answer[j++]=a;
        }
        return answer;
    }
}