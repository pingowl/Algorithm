#include <bits/stdc++.h>
using namespace std;  


int n, x, y, adj[104][104], ans, ny, nx, max_h, cnt;
bool visited[104][104];
int dx[] = {0, 1, 0, -1};
int dy[] = {-1, 0, 1, 0};
void dfs(int y, int x, int h){
    visited[y][x] =1;
    for(int i=0; i<4; i++){
        ny = y + dy[i];
        nx = x + dx[i];
        if(ny<0 || ny>=n || nx<0; nx>=n ) continue;
        if(adj[ny][nx]>h && !visited[ny][nx]){
            dfs(ny,nx, h);
        }
    }
}
int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

    cin >> n;
	for(int i=0; i<n; i++){
	    for(int j=0; j<n; j++){
            cin >> adj[i][j];
            if(max_h< adj[i][j]) max_h = adj[i][j];
	    }
	}
	for(int h=0; h<=max_h; h++){
	    for(int i=0; i<n; i++){
    	    for(int j=0; j<n; j++){
    	        if(adj[i][j]>h && !visited[i][j]){
    	            cnt++; dfs(i,j, h);
    	        }
    	    }
	    }
	    if(cnt> ans) ans = cnt;
	    cnt = 0;
	    memset(visited, 0, sizeof(visited));
	}

	cout << ans << "\n";
    return 0;
}