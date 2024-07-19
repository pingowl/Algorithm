import java.util.*;
import java.io.*;
public class Main {
	static int n,m;
	static final int INF=500_0001;
	static long dist[];
	static Edge[] map;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken()); // v
        m = Integer.parseInt(st.nextToken()); // e
        
        dist = new long[n+1];
        map = new Edge[m+1];
        Arrays.fill(dist, INF);
        
        int a,b,w;
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map[i] = new Edge(a,b,w);
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 음의 사이클 없는 경우
        if(!bellmanFord()) {
        	for(int i=2; i<=n; i++) {
        		sb.append(dist[i]==INF ? "-1\n" : dist[i]+"\n");
        	}
        }else {
        	sb.append("-1\n");
        }
        
        System.out.println(sb.toString());
        
	}
	static class Edge{
		int start, end, cost;
		public Edge(int s, int e, int c) {
			start=s; end=e; cost=c;
		}
	}
	static boolean bellmanFord() {
		dist[1]=0;
		
		// v 번
		for(int i=0; i<n; i++) {
			// 모든 간선
			for(int j=0; j<m; j++) {
				Edge e = map[j];
				int now = e.start;
				int next = e.end;
				if(dist[now]!= INF && dist[next]> dist[now]+e.cost ) {
					dist[next] = dist[now] + e.cost;
					if(i==n-1) 
						return true;
				}
			}
		}
		
		return false;
	}
}