#include <bits/stdc++.h>
using namespace std;  


int x, y, a[104][104], ny, nx;
int cnt, s, n, m, k, X1, X2, Y1, Y2;
bool visited[104][104];
int dx[] = {0, 1, 0, -1};
int dy[] = {-1, 0, 1, 0};
vector<int> v;
void dfs(int y, int x){
    visited[y][x]=1;
    for(int i=0; i<4; i++){
        ny = y + dy[i];
        nx = x + dx[i];
        if( ny<0 || ny>=n || nx<0 || nx>=m ) continue;
        if( a[ny][nx]==0 && !visited[ny][nx]){
            s++; dfs(ny, nx);
        }
    }
}
int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

    cin >> m >> n >> k;
    for(int i=0; i<k; i++){
        cin >> X1 >> Y1 >> X2 >> Y2; 
        for(int j=Y1; j<Y2; j++){
            for(int p=X1; p<X2; p++){
                a[p][j]=1;
            }
        }
    }
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if( a[i][j]==0 && !visited[i][j]){
                cnt++; s=1; dfs(i, j);
                v.push_back(s);
            }
        }
    }

    sort(v.begin(), v.end());
	cout << cnt << "\n";
	for(int i=0; i<cnt; i++){
	    cout << v[i] << " ";
	}
    return 0;
}