import java.util.*;
class Solution {
    
    // list에 블럭 저장
    List<List<Point>> t = new ArrayList<>();
    List<List<Point>> b = new ArrayList<>();
    
    public int solution(int[][] game_board, int[][] table) {
        int n = table.length;
        
        // game_board: 0=빈칸, table: 1=블럭
        //game_board 0, 1 바꿔주기
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                game_board[i][j] = (game_board[i][j]==1) ? 0:1;
            }
        }
        
        boolean[][] visitedT = new boolean[n][n];
        boolean[][] visitedB = new boolean[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // table에서 블럭 추출
                if(table[i][j]==1 && !visitedT[i][j])
                    bfs(i, j, table, visitedT, t);
                
                // game_board에서 빈공간 추출
                if(game_board[i][j]==1 && !visitedB[i][j])
                    bfs(i, j, game_board, visitedB, b);
            }
        }
        
        // table의 블럭과 game_board의 빈공간들을 회전하면서 비교하기
        return putBlock();
    }
    
    public int putBlock(){
        int cnt = 0;
        int sizeT = t.size();
        int sizeB = b.size();
        
        boolean[] visited = new boolean[sizeB];
        
        for(int i=0; i<sizeT; i++){
            for(int j=0; j<sizeB; j++){
                // visited 또는 블럭 크기 다를 떄
                if(visited[j] || t.get(i).size() != b.get(j).size())
                    continue;
                if(rotate(t.get(i), b.get(j))){
                    visited[j] = true; // 보드의 빈칸에 블럭을 넣음
                    cnt += b.get(j).size();
                    break;
                }
            }
        }
        
        
        return cnt;
    }
    
    public boolean rotate(List<Point> block, List<Point> hole){
        
        Collections.sort(hole);
        
        // 시계방향 회전 : 0, 90, 180, 270도
        for(int i=0; i<4; i++){
            // 회전할 때마다 블럭 정렬
            Collections.sort(block);
            
            //회전하면서 좌표가 바뀌기 때문에, 다시 (0,0) 기준으로 세팅
            int y0 = block.get(0).y;
            int x0 = block.get(0).x;            
            for(int j=0; j<block.size(); j++){
                block.get(j).y -= y0;
                block.get(j).x -= x0;
            }
            
            boolean check = true;
            
            for(int j=0; j<hole.size(); j++){
                if(hole.get(j).y != block.get(j).y || hole.get(j).x != block.get(j).x){
                    check = false;
                    break;
                }                
            }
            
            if(check){
                return true;
            }else{
                // 시계방향 90도 회전 
                for(int j=0; j<block.size(); j++){
                    int temp = block.get(j).x;
                    block.get(j).x = block.get(j).y;
                    block.get(j).y = -temp;
                }
            }
        }
        
        return false;
    }
    
    public void bfs(int x, int y, int[][] board, boolean[][] visited, List<List<Point>> list){
        
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int n = board.length;
        
        visited[x][y] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        
        // 각 블럭은 (0,0) 부터 시작
        List<Point> tmp = new ArrayList<>();
        tmp.add(new Point(0,0));
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            for(int i=0; i<4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                
                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                if(visited[nx][ny] || board[nx][ny]==0) continue;
                
                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
                tmp.add(new Point(nx-x, ny-y));
            }
        }
        
        list.add(tmp);
    }
    
    static class Point implements Comparable<Point>{
        int x, y;
        
        Point(int x, int y){ 
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Point o){
            if(this.x == o.x)
                return this.y - o.y;
            else
                return this.x - o.x;
        }
    }
}