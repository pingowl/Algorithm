import java.util.*;
import java.io.*;
public class Main {
	
	static int t, n, min, max;
	static int a[] = {6,2,5,5,4,5,6,3,7,6};
	static String[] dp = new String[101]; // dp[cnt]=min
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        t = Integer.parseInt(br.readLine());
        dp[0]="";
        for(int i=1; i<=100; i++) {
        	dp[i]="111111111111111111111111111111111111111111111111119"; //MAX STR
        }
        for(int i=2; i<=100; i++) {
        	for(int j=0; j<=9; j++) {
        		if(i-a[j] <0) continue;
        		if(j==0 && dp[i-a[j]]=="") continue;
        		dp[i] = getSmaller(dp[i], dp[i-a[j]]+String.valueOf(j));
        	}
        }
        
        
        while(t-- >0) {
        	n = Integer.parseInt(br.readLine());
        	System.out.println(dp[n]+" "+findMax(n));
        }        
	}	
	static String findMax(int m) {
		//m=짝수:111..  m=홀수:7111..
		String ret = "";
		if(m %2==1) {
			ret += "7";
			m -=3;
		}
		while(m>0) {
			ret += "1";
			m -=2;
		}
		return ret;
	}
	static String getSmaller(String a, String b) {
		if(a.length() == b.length()) return (a.compareTo(b)<0) ? a : b;
		else if(a.length() < b.length()) return a;
		else return b;
	}
}