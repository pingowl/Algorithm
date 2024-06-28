import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int[][] map = new int[18][18];
    static int ans;
    static int[][][] dp = new int[18][18][3]; // y,x,dir(0-garo,1-daegak,2-sero)
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][2][0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                // horizontal
                if(check(i,j+1,0)) dp[i][j+1][0] += dp[i][j][0];
                if(check(i+1,j+1,1)) dp[i+1][j+1][1] += dp[i][j][0];
                
                // vertical
                if(check(i+1,j,2)) dp[i + 1][j][2] += dp[i][j][2];
                if(check(i+1,j+1,1)) dp[i + 1][j + 1][1] += dp[i][j][2]; 
                
                // diagonal
                if(check(i,j+1,0)) dp[i][j + 1][0] += dp[i][j][1];
                if(check(i+1,j,2)) dp[i + 1][j][2] += dp[i][j][1];
                if(check(i+1,j+1,1)) dp[i + 1][j + 1][1] += dp[i][j][1];  
            }
        }
        ans = dp[n][n][0];
        ans += dp[n][n][1];
        ans += dp[n][n][2];
        System.out.println(ans);
    }
    
    public static boolean check(int y, int x, int d){
        if(d==0 || d==2){
            if(map[y][x]==0) return true;
        } else if (d==1){
            if(map[y][x]==0 && map[y-1][x]==0 && map[y][x-1]==0)
                return true;
        }
        return false;
    }
}