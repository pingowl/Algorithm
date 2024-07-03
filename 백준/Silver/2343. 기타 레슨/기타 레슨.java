import java.util.*;
import java.io.*;
public class Main {
	
	static int n,m,mx,sum=0,l,r,ret;
	static int[] a;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			sum += a[i];
			mx = Math.max(mx, a[i]);
		}
		l=0; r=sum;
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
	
	public static boolean check(int mid) {
		if(mx>mid) return false;
		int tmp=mid, cnt=0;
		for(int i=0; i<n; i++) {
			if(mid-a[i]<0) {
				cnt++;
				mid = tmp;
			}
			mid -= a[i];
		}
		if(mid !=tmp) cnt++;
		return cnt<=m;
	}
}