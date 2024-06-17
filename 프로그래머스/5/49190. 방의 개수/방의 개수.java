import java.util.*;

class Solution {
    
    public static class Pair{
        public int x, y;
        public Pair(int x, int y){ this.x = x; this.y = y;}
        
        @Override
        public int hashCode(){ return Objects.hash(x,y);}
        
        @Override
        public boolean equals(Object o){
            if(this == o ) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
    }
    
    public static List<Pair> makePairList(Pair pair){
        List<Pair> list = new ArrayList<>();
        list.add(pair);
        return list;
    } 
    
    
    public int solution(int[] arrows) {
        int answer = 0;
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
        
        Pair now = new Pair(0,0);
        Map<Pair, List<Pair>> visited = new HashMap<>();
        
        for(int arrow: arrows){
            for(int i=0; i<2; i++){ // 교차점 처리를 위한 스케일업 : 1칸 대신 2칸 이동
                Pair next = new Pair(now.x + dx[arrow], now.y + dy[arrow]);
                
                // 처음 방문하는 경우
                if (!visited.containsKey(next)){
                    visited.put(next, makePairList(now));
                    
                    if (visited.get(now) == null){
                        visited.put(now, makePairList(next));
                    } else {
                        visited.get(now).add(next);
                    }
                
                // 재방문 & 간선 처음 통과하는 경우
                } else if(visited.containsKey(next) && !visited.get(next).contains(now)){
                    visited.get(next).add(now);
                    visited.get(now).add(next);
                    
                    answer++;
                }
                now = next;
            }
        }
        
        return answer;
    }
}