import java.util.*;
import java.io.*;
public class Main {
	
	static long dp[][]; // dp[idx][sum]
	static int n, target, a[];
	static long cnt;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[n]; dp = new long[n][21];
        for(int i=0; i<n; i++) {
        	a[i] = Integer.parseInt(st.nextToken());
        }
        target = a[n-1];
        System.out.println(go(0,a[0]));
	}	
	
	public static long go(int idx, int sum) {
		if(sum<0 || sum>20) return 0;
		if(dp[idx][sum]>0)return dp[idx][sum];
		if(idx==n-2) {
			if(sum==target) return 1;
			return 0;
		}			
		dp[idx][sum] += go(idx+1, sum+a[idx+1]); 
		dp[idx][sum] += go(idx+1, sum-a[idx+1]); 
		return dp[idx][sum];
	}
}