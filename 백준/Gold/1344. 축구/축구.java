import java.util.*;
import java.io.*;
public class Main {
	
	static double a,b;
	static int n=18;
	static double[][][] dp = new double[n+1][n+1][n+1];
	static boolean[] chk = {false,false,true,true,false,true, // 0~5
							false,true,false,false,false,true,//6~11
							false,true,false,false,false,true,false}; //12~18
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        a = Double.parseDouble(br.readLine())/100;
        b = Double.parseDouble(br.readLine())/100;
        for(int i=0; i<=n; i++) {
        	for(int j=0; j<=n; j++) {
        		for(int k=0; k<=n; k++) {
        			dp[i][j][k]=-1;
        		}
        	}
        }
        
        System.out.printf("%.7f",go(0,0,0));
	}	
	
	public static double go(int idx, int x, int y) {
		if(idx==n) return (chk[x] || chk[y])? 1.0 : 0.0; // 적어도 하나 소수
		if(dp[idx][x][y] >-0.5) return dp[idx][x][y];
		dp[idx][x][y] = 0.0;
		
		dp[idx][x][y] += go(idx+1,x+1,y)*a*(1-b);
		dp[idx][x][y] += go(idx+1,x,y+1)*(1-a)*b;
		dp[idx][x][y] += go(idx+1,x+1,y+1)*a*b;
		dp[idx][x][y] += go(idx+1,x,y)*(1-a)*(1-b);
		return dp[idx][x][y];
	}
}