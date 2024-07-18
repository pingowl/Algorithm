import java.util.*;
import java.io.*;
public class Main {
	static int n,m, dist[][];
	static final int INF=9900001;//10,000*(100-1)+1
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        dist = new int[n+1][n+1];
        
        for(int i=1; i<=n;i++) {
        	Arrays.fill(dist[i], INF);
        	dist[i][i]=0;
        }
        
        int a,b,w;
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            dist[a][b]=Math.min(w, dist[a][b]);
        }
        
        floydWarshall(n);
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		if(dist[i][j]==INF) sb.append("0 ");
        		else sb.append(dist[i][j]+" ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb.toString());
        
	}
	static void floydWarshall(int n) {
		
		for(int k=1; k<=n; k++) { // 경유지 
			for(int i=1; i<=n; i++) { // 출발지
				if(i==k) continue;
				for(int j=1; j<=n; j++) { // 도착지 
					if(i==j || j==k) continue;
					if(dist[i][j] > dist[i][k]+ dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
				
		}
	}
}