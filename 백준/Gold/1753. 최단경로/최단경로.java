import java.util.*;
import java.io.*;
public class Main {
	static int v,e,k, dist[];
	static List<Node>[] adj;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        
        dist = new int[v+1];
        adj = new ArrayList[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0; i<=v; i++) {
        	adj[i] = new ArrayList<>();
        }
        
        int a,b,w;
        for(int i=0; i<e; i++) {
        	st = new StringTokenizer(br.readLine());
        	a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b,w));
        }
        
        dijkstra(k);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=v; i++) {
        	if(dist[i]==Integer.MAX_VALUE) sb.append("INF\n");
        	else sb.append(dist[i]+"\n");
        }
        System.out.println(sb.toString());
        
	}
	static class Node implements Comparable<Node>{
		int end, weight;
		public Node(int end, int weight) {
			this.end = end;
			this.weight=weight;
		}
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			Node nowNode = pq.poll();
			int cur = nowNode.end;
			int d = nowNode.weight;
			
			if(dist[cur] < d) continue;
			for(Node no : adj[cur]) {
				int next = no.end;
				int nextDist = d + no.weight;
				if(nextDist < dist[next]) {
					dist[next] = nextDist;
					pq.add(new Node(next,nextDist));
				}
			}
		}
	}
}