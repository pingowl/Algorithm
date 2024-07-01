import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
            int m = (int) (Double.parseDouble(st.nextToken())*100+0.5);
            if(n==0 && m==0) break;
            
            int c, p;
            int[] dp = new int[100001];
            for(int i=1; i<=n; i++) {
            	st = new StringTokenizer(br.readLine());
            	c = Integer.parseInt(st.nextToken());
            	p = (int) (Double.parseDouble(st.nextToken())*100+0.5);
            	for(int j=p; j<=m; j++) {
            		dp[j] = Math.max(dp[j], dp[j-p]+c);
            	}
            }
            
            System.out.println(dp[m]);            
        }     
	}	
}