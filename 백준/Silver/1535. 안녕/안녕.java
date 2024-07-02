import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    	int n = Integer.parseInt(br.readLine());
    	int[] w = new int[n+1];
    	int[] v = new int[n+1];
    	int[][] dp = new int[n+1][100];
        
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringTokenizer st2 = new StringTokenizer(br.readLine());
    	for(int i=1; i<=n; i++) {        		
        	w[i] = Integer.parseInt(st.nextToken());
        	v[i] = Integer.parseInt(st2.nextToken());
    	}     
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=99; j++) {
        		if(w[i] <=j)
        			dp[i][j] = Math.max(dp[i-1][j-w[i]]+v[i], dp[i-1][j]);
        		else
        			dp[i][j] = dp[i-1][j];
        	}
        }
    	
        System.out.println(dp[n][99]);
	}	
}