#include <bits/stdc++.h>

using namespace std;
int visited[501][501];
int dy[] = {-1, 0, 1, 0}, dx[] = {0, 1, 0, -1};
int n, m, roomcnt=1;
vector<vector<int>> lnd;
map<int,int> sizemem;
void bfs(int y, int x){
    int tmp = 1;
    visited[y][x]=1; 
    lnd[y][x] = roomcnt;
    queue<pair<int,int>> q;
    q.push({y,x});
    while(q.size()){
        tie(y,x) = q.front(); q.pop();
        for(int k=0; k<4; k++){
            int ny = y + dy[k];
            int nx = x + dx[k];
            if(ny<0 || ny>=n || nx<0 || nx>=m) continue;
            if(!lnd[ny][nx] || visited[ny][nx]) continue;
            q.push({ny, nx});
            visited[ny][nx] = 1; tmp++;
            lnd[ny][nx] = roomcnt;
        }
    }
    sizemem[roomcnt]=tmp;
}

int solution(vector<vector<int>> land) {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    n = land.size();
    m = land[0].size();
    lnd = land;
    int oilmax=0;
    for(int i=0; i<m; i++){
        int oilv = 0; set<int> s;
        for(int j=0; j<n; j++){
            if(!land[j][i]) continue;
            if(!visited[j][i]){
                bfs(j, i);
                oilv+= sizemem[roomcnt];  
                s.insert(roomcnt); 
                roomcnt++; 
            }
            else {
                auto it = find(s.begin(), s.end(), lnd[j][i]);
                if(it == s.end()) {
                    oilv +=sizemem[lnd[j][i]];
                    s.insert(lnd[j][i]);
                }
            }
            
        }
        oilmax = max(oilmax, oilv);
    }

    return oilmax;
}