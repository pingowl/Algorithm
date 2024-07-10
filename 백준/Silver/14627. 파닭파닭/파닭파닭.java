import java.util.*;
import java.io.*;
public class Main {
	
	static int s, c;
	static long a[], ans, sum=0;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        s = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        long max=1;
        a = new long[s];
        for(int i=0; i<s;i++) {
        	st = new StringTokenizer(br.readLine());
        	a[i] = Integer.parseInt(st.nextToken());
        	max = Math.max(a[i], max);
        	sum += a[i];
        }
        long l=1, r=max, mid;
        while(l<=r) {
        	mid = (l+r)/2L;
        	if(check(mid)) {
        		l=mid+1;
        		ans = mid;
        	}else {
        		r=mid-1;
        	}
        }
        System.out.println(sum-ans*c);
	}
	static boolean check(long mid) {
		int cnt=0;
		for(int i=0; i<a.length; i++) {
			cnt += a[i]/mid;
		}
		return cnt >= c;
	}
}