import java.util.*;
import java.io.*;
public class Main {
	
	static int move[], n, dp[][][]; // dp[idx][left][right]
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = line.length-1;
        move = new int[n]; 
        for(int i=0; i<n; i++) {
        	move[i] = Integer.parseInt(line[i]);
        }
        dp = new int[n+1][5][5];
        for(int i=0; i<=n; i++) {
        	for(int a=0; a<5; a++) {
        		for(int b=0;  b<5; b++) {
        			dp[i][a][b]=-1;
        		}
        	}
        }
        System.out.println(go(0,0,0));
	}	
	
	static int go(int idx, int a, int b) {
		if(idx==n) return 0;
		if(dp[idx][a][b]!=-1) return dp[idx][a][b];
		int left = go(idx+1, move[idx], b) + calc(a, move[idx]);
		int right = go(idx+1, a, move[idx]) + calc(b, move[idx]);
		dp[idx][a][b] = Math.min(left, right);
		return dp[idx][a][b];
	}
	static int calc(int from, int to) {
		if(from==to) return 1;
		else if(from==0) return 2;
		else if(Math.abs(from-to)==2) return 4;
		else return 3;
	}
}