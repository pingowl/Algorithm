import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int w, v;
        int[] dp = new int[100001];
        for(int i=1; i<=n; i++) {
        	st = new StringTokenizer(br.readLine());
        	w = Integer.parseInt(st.nextToken());
        	v = Integer.parseInt(st.nextToken());
        	for(int j=k; j>=w; j--) {
        		dp[j] = Math.max(dp[j], dp[j-w]+v);
        	}
        }        
        System.out.println(dp[k]);  
	}	
}