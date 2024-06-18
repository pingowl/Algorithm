import java.util.*;
class Solution {
    boolean solution(String s) {
        if(s.charAt(0) == ')'){
            return false;
        }
        
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(char c: chars){
            if(!stack.empty() && stack.peek()=='(' && c==')'){
                stack.pop();
            } else{
                stack.push(c);
            }
        }
        
        boolean answer = (stack.empty()) ? true : false;
        return answer;
    }
}