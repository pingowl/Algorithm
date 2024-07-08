import java.util.*;
import java.io.*;
public class Main {
	
	static int n, m, c, a[], dp[][][]; // dp[bag_idx][item_bitmasking][capacity]
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        a = new int[n]; 
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        dp = new int[m][1<<14][c+1];
        System.out.println(go(0,0,c));
	}	
	static int go(int idx, int item, int capacity) {
		if(idx==m) return 0;
		if(dp[idx][item][capacity] !=0) return dp[idx][item][capacity];
		// 현재 배낭을 사용하지 않고 다음 배낭으로 넘어가는 경우
		dp[idx][item][capacity] = Math.max(dp[idx][item][capacity], go(idx+1,item,c));
		// 모든 아이템을 하나씩 확인
		for(int i=0; i<n; i++) {
			// i 번째 아이템이 이미 선택되었는지 확인 (비트마스크 사용)
			boolean itemUsed = 0 < ((1<<i) & item);
			// i 번째 아이템을 현재 배낭에 넣을 수 있는지 확인 (남은 용량 체크)
			boolean canAdd = (capacity - a[i]) >= 0;
			// 아이템이 이전에 선택되지 않았고, 현재 배낭에 넣을 수 있는 경우
			if(!itemUsed && canAdd) {
				// i 번째 아이템을 선택하고 현재 배낭에 넣은 후, 다음 상태로 이동
				dp[idx][item][capacity] = Math.max(dp[idx][item][capacity], 
						go(idx, item | (1 << i), capacity - a[i]) + 1);
			}			
		}
		return dp[idx][item][capacity];
	}
}