import java.util.*;
import java.io.*;
public class Main {
	static int v, e, k;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        
        while(true) {
        	String st = br.readLine();
        	if(st.equals(".")) break;
        	
        	Stack<Integer> stack = new Stack<>();
        	boolean ans = true;
        	for(char c: st.toCharArray()) {
        		if(c=='(') {
        			stack.add(1);
        		}else if(c==')') {
        			if(!stack.empty() && stack.peek()==1) {
        				stack.pop();
        			}else {
        				ans = false;
        				break;
        			}
        		}else if(c=='[') {
        			stack.add(3);
        		}else if(c==']') {
        			if(!stack.empty() && stack.peek()==3) {
        				stack.pop();
        			}else {
        				ans = false;
        				break;
        			}
        		}
        	}
        	if(stack.empty() && ans) System.out.println("yes");
        	else System.out.println("no");
        }
	}
}