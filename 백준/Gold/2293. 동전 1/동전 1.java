import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        int num;
        int[] dp = new int[10001];
        dp[0]=1;
        for(int i=1; i<=n; i++) {
        	st = new StringTokenizer(br.readLine());
        	num = Integer.valueOf(st.nextToken());
        	if(num > k) continue;
        	for(int j=num; j<=k; j++) {
        		dp[j] += dp[j-num];
        	}
        }
        
		System.out.println(dp[k]);
	}	
}