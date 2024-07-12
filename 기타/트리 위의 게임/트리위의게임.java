import java.util.*;
import java.io.*;

class Main {
    static int n, a, b;
    static ArrayList<Integer>[] v;
    static int[] dp;

    static void dfs(int x, int parent) {
        int ret = Integer.MAX_VALUE;
        for (int nxt : v[x]) {
            if (nxt == parent) continue;
            dfs(nxt, x);
            ret = Math.min(ret, dp[nxt]);
        }
        if (ret == Integer.MAX_VALUE) ret = 0;
        dp[x] = x - ret; // <------- 핵심로직
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n=Integer.parseInt(br.readLine());
        v = new ArrayList[n+1];
        dp = new int[n+1];
        
        for(int i=0;i<=n;i++)
            v[i]=new ArrayList<>();
            
        for(int i=1;i<n;i++){
            st = new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            
            v[a].add(b);
            v[b].add(a);
        }
        
       dfs(1,0);
       
       for(int i=1;i<=n;i++){
           if(dp[i]>=0)
               System.out.println("1");
           else
               System.out.println("0");
       }
   } 
}