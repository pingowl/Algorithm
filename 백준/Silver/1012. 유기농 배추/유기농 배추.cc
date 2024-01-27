#include <bits/stdc++.h>
using namespace std;  


int t, n, m, k, x, y, adj[54][54], ans, ny, nx;
bool visited[54][54];
int dx[] = {0, 1, 0, -1};
int dy[] = {-1, 0, 1, 0};
void dfs(int y, int x){
    visited[y][x] =1;
    for(int i=0; i<4; i++){
        ny = y + dy[i];
        nx = x + dx[i];
        if(ny<0 || ny>=n || nx<0; nx>=m ) continue;
        if(adj[ny][nx]==1 && !visited[ny][nx]){
            dfs(ny,nx);
        }
    }
}
int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

	cin >> t;
	while(t--){
	    cin >> m >> n >>k;
    	for(int i=0; i<k; i++){
            cin >> x >> y;
            adj[y][x]=1;
    	}
    	for(int i=0; i<n; i++){
    	    for(int j=0; j<m; j++){
    	        if(adj[i][j]==1 && !visited[i][j]){
    	            ans++; dfs(i,j);
    	        }
    	    }
    	}
    	cout << ans << "\n";
    	ans=0;
    	memset(adj, 0, sizeof(adj));
    	memset(visited, 0, sizeof(visited));
	}

    return 0;
}