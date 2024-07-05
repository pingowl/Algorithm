import java.util.*;
import java.io.*;
public class Main {
	
	static char[] a;
	static int dp[][], dp2[]; // dp[from][size]
	static int n;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        a = br.readLine().toCharArray();
        n = a.length;
        dp = new int[n][n+1]; dp2 = new int[n];
        for(int i=0; i<n; i++) {
        	dp[i][1]=1;
        	if(i<n-1 && a[i]==a[i+1]) dp[i][2]=1;
        }
        for(int size=3; size<=n; size++) {
        	for(int i=0; i+size<=n; i++) {
        		if(a[i]==a[i+size-1] && dp[i+1][size-2]==1)
        			dp[i][size]=1;
        	}
        }
        for(int i=0; i<n; i++) {
        	dp2[i] = Integer.MAX_VALUE;
        }
        System.out.println(go(0));
	}	
	
	public static int go(int here) {
		if(here==n) return 0;
		if(dp2[here] != Integer.MAX_VALUE) return dp2[here];
		for(int i=1; i+here<=n; i++) {
			if(dp[here][i]==1) dp2[here] = Math.min(dp2[here], go(here+i)+1);
		}
		return dp2[here];
	}
}