import java.util.*;
import java.io.*;
public class Main {
	
	static int n;
	static Room[] rooms;
	static long ans, atk;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        atk = Long.parseLong(st.nextToken());
        long t,a,h;
        rooms = new Room[n];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	t = Long.parseLong(st.nextToken());
        	a = Long.parseLong(st.nextToken());
        	h = Long.parseLong(st.nextToken());
        	rooms[i] = new Room(t,a,h);
        }
        long l=1L,r=n*1000000L*1000000L, mid;
        // 최약의 경우: 방개수최대(n)  & 용사공격력=1 & 몬스터hp=1000000
        while(l<=r) {
        	mid = (l+r)/2L;
        	if(check(mid)) {
        		ans = mid;
        		r = mid-1;
        	}else {
        		l = mid+1;
        	}
        }
        System.out.println(ans);
	}
	static boolean check(long mid) {
		long hp = mid;
		long a = atk;
		for(int i=0; i<n; i++) {
			Room r = rooms[i];
			if(r.t==1) {
				long cnt = (long) Math.ceil(r.h/(double)a);
				hp -= (cnt-1)*r.a;
				if( hp<=0) return false;
//				int mon = r.h;
//				while(true) {
//					mon -= a;
//					if(mon<=0) break;
//					hp -= r.a;
//					if(hp<=0) return false;
//				}
			}else {
				a += r.a;
				hp = Math.min(mid, hp+r.h);
			}
		}
		return true;
	}
	public static class Room{
		public long t,a,h;
		public Room(long t, long a, long h) {
			this.t = t;
			this.a = a;
			this.h = h;
		}
	}
}