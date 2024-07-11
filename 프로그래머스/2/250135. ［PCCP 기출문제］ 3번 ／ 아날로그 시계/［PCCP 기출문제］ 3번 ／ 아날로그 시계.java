class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int ans = 0;
        
        int start = toSecond(h1,m1,s1);
        int end = toSecond(h2,m2,s2);
        
        ans = calc(end) - calc(start) + chknow(start);
        return ans;
    }
    static int toSecond(int h, int m, int s){
        return h*3600 + m*60 + s;
    }
    static int calc(int time){
        int sm = time*59/3600; // 1시간(=3600초) 동안 초침과 분침은 59번 만난다
                               // 1초에 59/3600 번 만난다
                               
        int sh = time*719/43200;  // 시침이 한 바퀴 도는데는 43200초(=12시간)
                                 // 시침이 한바퀴 돌 동안 시침과 초침이 719번 만난다
        
        int a = (43200 <= time) ? 2 : 1; // 0시, 12시에는 시침, 초침, 분침이 1번만 만나는 걸로 친다
        return sm+sh - a;
    }
    static int chknow(int time){
        boolean calc = time*59%3600==0 || time*719%43200==0; // 현재시간에 알람이 울리는지 체크한다.
        return calc ? 1 : 0;
    }
}