import java.util.*;
import java.io.*;
public class Main {
	
	static int n, m, ret, sum=0, max=0;
	static int[] a;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        a = new int[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			sum += a[i];
			max = Math.max(max,  a[i]);
		}		
		
		int l=0, r=sum;
		while(l<=r) {
			int mid = (l+r)/2;
			if(check(mid)) {
				r = mid-1;
				ret = mid;
			}else {
				l = mid+1;
			}
		}
		
		System.out.println(ret);
	}
	
	public static boolean check(int val) {
		if(max > val) return false;
		int cnt=1, now=val;
		for(int i=0; i<n; i++) {
			if(now - a[i] <0) {
				cnt++;
				now = val;
			}
			now -= a[i];
		}
		return cnt <=m;
	}
}