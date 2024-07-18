#include <iostream>
#include <climits>

using namespace std;
const int MAX_V = 101;
int dist[MAX_V][MAX_V];


int main(){
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int n, m, x, y, z;
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			dist[i][j] = INT_MAX;
		}
	}


	for (int i = 0; i < m; i++) {
		cin >> x >> y >> z;
		if (dist[x][y] > z)
			dist[x][y] = z;
	}
	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dist[i][k] != INT_MAX && dist[k][j] != INT_MAX)
					dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
			}
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (i == j || dist[i][j] == INT_MAX) cout << 0 << ' ';
			else cout << dist[i][j] << " ";
		}
		cout << '\n';
	}
	return 0;
}
