import java.util.*;
class Solution {
    
    public static class Music{
        int idx, play;
        
        public Music(int idx, int play){
            this.idx = idx;
            this.play = play;
        } 
    }
    

    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        // 장르별 재생수 총합 저장
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]); 
        }
        
        // 총재생수 기준 내림차순으로 장르 저장
        ArrayList<String> genreMap = new ArrayList<>();
        for(String item : map.keySet()){
            genreMap.add(item);
        }
        genreMap.sort((o1, o2) -> map.get(o2) - map.get(o1)); 
        
        // 한 장르에서 가장 많이 플레이된 음악 선별
        for(String item: genreMap){
            ArrayList<Music> musics = new ArrayList<>();
            
            for(int i=0; i<genres.length; i++){
                if(item.equals(genres[i])){
                    musics.add(new Music(i, plays[i]));
                }
            }
            
            // Music 정렬
            musics.sort(new Comparator<Music>(){
                @Override
                public int compare(Music o1, Music o2){
                    if(o1.play == o2.play){
                        return o1.idx - o2.idx; // play값 동일하면 idx : 오름차순
                    }
                    return o2.play - o1.play; // play : 내림차순
                }
            });

            answer.add(musics.get(0).idx);
            if(musics.size() != 1){
                answer.add(musics.get(1).idx);
            }
        }
        

        return answer.stream().mapToInt(i->i).toArray();
    }
}