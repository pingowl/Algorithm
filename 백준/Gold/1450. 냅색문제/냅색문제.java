import java.util.*;
import java.io.*;
public class Main {
	
	static int n, c, a[], ret=0;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	a[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> v = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();
        go(0, n/2 -1, v,0);
        go(n/2, n-1, v2,0);
        Collections.sort(v);
        Collections.sort(v2);
        //찾으려는 key 값을 초과하는 숫자가 배열 몇 번째에서 처음 등장하는지 찾기
        for(int x: v) {
        	if(c-x >= 0) {
        		ret += upperBound(v2, c-x);
        	}
        }
        System.out.println(ret);
	}	
	
	public static void go(int idx, int m, List<Integer> list, int sum) {
		if(sum > c) return;
		if(idx > m) {
			list.add(sum);
			return;
		}
		go(idx+1, m, list, sum+a[idx]);
		go(idx+1, m, list, sum);
	}
	
	public static int upperBound(List<Integer> list, int value) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) <= value) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}