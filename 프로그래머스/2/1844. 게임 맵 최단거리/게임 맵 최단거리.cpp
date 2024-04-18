#include <bits/stdc++.h>
using namespace std;
int visited[101][101];
const int dy[]={-1,0,1,0}, dx[]={0,1,0,-1};

void bfs(vector<vector<int>> maps, int y, int x){
    int n = maps.size();
    int m = maps[0].size();
    visited[y][x]=1;
    queue<pair<int,int>> q;
    q.push({y,x});
    while(q.size()){
        tie(y,x) = q.front(); q.pop();
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny<0 || ny>=n || nx<0 || nx>=m) continue;
            if(maps[ny][nx] && !visited[ny][nx]){
                visited[ny][nx] = visited[y][x] +1;
                q.push({ny,nx});
            }
                
        }
    }
}
int solution(vector<vector<int> > maps)
{
    int n = maps.size();
    int m = maps[0].size();
    bfs(maps, 0,0);
    int cnt = visited[n-1][m-1];
    return (cnt>0)? cnt : -1;
}