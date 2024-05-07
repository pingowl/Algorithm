#include <bits/stdc++.h>
using namespace std;
int visited[9], n, cnt, mx;
vector<vector<int>> d;
void dfs(int a, int k){
    visited[a]=1; cout << a <<" ";
    cnt++;
    mx = max(mx, cnt);
    k -= d[a][1];
    for(int i=0; i<n; i++){
        if(visited[i]) continue;
        if(d[i][0] > k) continue;
        
        dfs(i, k);
        visited[i]=0; cnt--;
    }
    k +=  d[a][1];
}

int solution(int k_, vector<vector<int>> dungeons) {
    int answer = 0;
    d = dungeons;
    n = dungeons.size();
    for(int i=0; i<n; i++){
        if(k_<d[i][0]) continue;
        dfs(i, k_);
        answer = max(answer, mx);
        cnt=0; mx=0; 
        memset(visited,0,sizeof(visited)); cout <<"\n";
    }
    
    return answer;
}