import java.util.*;
import java.io.*;
public class Main {
	
	static int n,m, a[];
	static long ans, kid;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m;i++) {
        	a[i] = Integer.parseInt(st.nextToken());
        }
        if(n<=m) {
        	System.out.println(n); return;
        }
        long l=0, r=60000000000L, mid; // 시간이 mid일 때 n명 이상 태울 수 있는지
        // 최악: 20억(=n최대값)*30(=놀이기구 1개)
        while(l<=r) {
        	mid = (l+r)/2L;
        	if(check(mid)) {
        		r=mid-1;
        		ans = mid;
        	}else {
        		l=mid+1;
        	}
        }
        // 마지막 아이가 탈 놀이기구를 찾기
        kid = m; 
		for(int i=0; i<m; i++) {
			kid += (ans-1)/a[i];
		}
		for(int i=0; i<m; i++) {
			if(ans%a[i]==0) kid++;
			if(kid==n) {
				System.out.println(i+1);
				return;
			}
			
		}
        
	}
	static boolean check(long mid) {
		kid = m; // 탈 수 있는 아이의 총 수 
		for(int i=0; i<m; i++) {
			kid += mid/a[i];
		}
		return kid >= n;
	}
}