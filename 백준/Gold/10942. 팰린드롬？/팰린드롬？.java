import java.util.*;
import java.io.*;
public class Main {
	
	static int n,m;
	static int[] a;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[n+2];
        dp = new int[n+2][n+2];
        for(int i=1; i<=n; i++) {
        	a[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=n; i++) {
        	dp[i][i]=1;
        	if(a[i]==a[i+1]) dp[i][i+1]=1;
        }
        for(int size=2; size<n; size++) {
        	for(int i=1; i<=n-size; i++) {
        		if(a[i]==a[i+size] && dp[i+1][i+size-1]==1)
        			dp[i][i+size]=1;
        	}
        }
        
        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int from, to;
        while(m-->0) {
        	st = new StringTokenizer(br.readLine());
        	from = Integer.parseInt(st.nextToken());
        	to = Integer.parseInt(st.nextToken());
        	sb.append(dp[from][to]).append("\n");
        }
        System.out.println(sb);
	}	
}