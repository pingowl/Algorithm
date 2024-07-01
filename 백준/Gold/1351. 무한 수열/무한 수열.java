import java.util.*;
import java.io.*;
public class Main {
	
	static Map<Long,Long> dp = new HashMap<>();
	static long n;
	static int p, q;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        
        dp.put(0L, 1L);
        System.out.println(go(n));  
	}	
	
	public static long go(long i) {
		if(dp.containsKey(i)) 
			return dp.get(i);
		long a1 = go((long) Math.floor(i/p));
		long a2 = go((long) Math.floor(i/q));
		dp.put(i, a1+a2);
		return dp.get(i);
	}
}