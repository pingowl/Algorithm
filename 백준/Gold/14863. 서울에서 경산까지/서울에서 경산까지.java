import java.util.*;
import java.io.*;
public class Main {
	
	static int n, k, time[], time2[], cost[], cost2[], dp[][];// dp[idx][time]=cost
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        time = new int[n+1]; time2 = new int[n+1];
        cost = new int[n+1]; cost2 = new int[n+1];
        dp = new int[n+1][k+1];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	time[i] = Integer.parseInt(st.nextToken());
        	cost[i] = Integer.parseInt(st.nextToken());
        	time2[i] = Integer.parseInt(st.nextToken());
        	cost2[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(go(0,k));
	}	
	static int go(int idx,int t) {
		if(idx==n) return 0;
		if(dp[idx][t]>0) return dp[idx][t];
		dp[idx][t] = Integer.MIN_VALUE;
		if(t-time[idx]>=0) dp[idx][t] = Math.max(dp[idx][t], go(idx+1,t-time[idx])+cost[idx]);
		if(t-time2[idx]>=0) dp[idx][t] = Math.max(dp[idx][t], go(idx+1,t-time2[idx])+cost2[idx]);
		return dp[idx][t];
	}
}