import java.util.*;
import java.io.*;
public class Main {
	
	static int n;
	static int[] d;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.valueOf(st.nextToken());
        d = new int[n+1];
        for(int i=1; i<=n; i++) {
        	d[i] = Integer.MAX_VALUE;
        }
        d[1]=0;
        
		System.out.println(go(n));
		trace(n);
		System.out.println(sb);
	}
	
	public static int go(int x) {
		if(d[x] != Integer.MAX_VALUE) return d[x];
		
		if(x %3 == 0) {
			d[x] = Math.min(d[x], go(x/3)+1);
		}
		if(x %2 == 0) {
			d[x] = Math.min(d[x], go(x/2)+1);
		}
		d[x] = Math.min(d[x], go(x-1)+1);
		
		return d[x];
	}
	
	public static void trace(int a) {
		if(a==0) return;
		sb.append(a+" ");
		if(a%3==0 && d[a]==d[a/3]+1) trace(a/3);
		else if(a%2==0 && d[a]==d[a/2]+1) trace(a/2);
		else if( d[a]==d[a-1]+1) trace(a-1);
		return;
	}
}
