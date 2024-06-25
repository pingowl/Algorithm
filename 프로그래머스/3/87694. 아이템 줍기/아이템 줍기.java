import java.util.*;
class Solution {
    
    // 꺾이는 부분을 도형 크기 2배로 만들어 해결
    static int[][] map = new int[101][101];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        // map 그리기
        for(int[] r: rectangle){
            int x1 = r[0]*2;
            int y1 = r[1]*2;
            int x2 = r[2]*2;
            int y2 = r[3]*2;
            
            draw(y1,x1,y2,x2);
        }
        
        
        return bfs(characterY*2, characterX*2, itemY*2, itemX*2);
    }
    
    public static int bfs(int startY, int startX, int endY, int endX){
        
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        boolean[][] visited = new boolean[101][101];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startY, startX, 0}); 
        
        while(!q.isEmpty()){
            int tmp[] = q.poll();
            int y = tmp[0];
            int x = tmp[1];
            int cnt = tmp[2];
            
            if(y == endY && x == endX)
                return cnt/2;
            
            for(int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(ny<=0 || nx<=0 || ny>100 || nx>100)
                    continue;
                if(visited[ny][nx]==true || map[ny][nx] !=2)
                    continue;
                
                visited[ny][nx] = true;
                q.add(new int[]{ny, nx, cnt+1});
            }
        }
        return 0;
    }
    
    
    public static void draw(int y1, int x1, int y2, int x2){
        for(int i=y1; i <= y2; i++){
            for(int j=x1; j <=x2; j++){
                
                if(map[i][j] == 1) continue; // 다른 도형 내부
                
                if(i==y1 || i==y2 || j==x1 || j==x2)
                    map[i][j] = 2; // 테두리
                else
                    map[i][j] = 1; // 직사각형 내부
            }
        }
    }
}