#include <bits/stdc++.h>
using namespace std;

int cnt, n;
void bfs(int here, vector<vector<int>> v){
    int visited[101];
    memset(visited,0,sizeof(visited));
    queue<int> q;
    visited[here]=1; 
    q.push(here); cnt++;
    while(q.size()){
        int h = q.front(); q.pop();
        for(int a : v[h]){
            if(visited[a]) continue;
            visited[a] = 1;
            cnt++; 
            q.push(a);
        }
    }
}

int solution(int n_, vector<vector<int>> wires) {
    int answer = 987654321, tmp=0; n = n_;
    for(int i=0; i<n-1; i++){
        vector<vector<int>> v(n+1);
        for(int j=0; j<n-1; j++){
            if(i==j) continue;
            v[wires[j][0]].push_back(wires[j][1]);
            v[wires[j][1]].push_back(wires[j][0]);
        }
        bfs(wires[0][0], v); 
        tmp = cnt - (n-cnt); 
        if(tmp <0) tmp *= -1; 
        answer = (tmp < answer) ? tmp : answer;
        cnt=0;

    }
    
    return answer;
}