#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>

using namespace std;
const int MAX_V = 501;
vector<pair<int, int>> adj[MAX_V];
long long dist[MAX_V];
int n, m, a, b, c, negative_cycle=0;

void bellman_ford(int st) {
	fill(dist, dist + MAX_V, INT_MAX);
	dist[st] = 0;
	for (int iter = 1; iter <= n; iter++) {
		// n번의 루프 : 모든 간선 확인작업 n-1번 + 음의사이클확인 1번
		for (int cur = 1; cur <= n; cur++) {
			if (dist[cur] == INT_MAX) continue;
			for (auto& u : adj[cur]) {
				int next = u.first, cost = u.second;
				if (dist[next] > dist[cur] + cost) {
					dist[next] = dist[cur] + cost;
					if (iter == n)
						negative_cycle = 1;
				}
			}
		}
	}
}


int main(){
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		cin >> a >> b >> c;
		adj[a].push_back({ b,c });
	}
	bellman_ford(1);

	if (negative_cycle) cout << -1;
	else {
		for (int i = 2; i <= n; i++) {
			if (dist[i] == INT_MAX) cout << -1 << '\n';
			else cout << dist[i] << '\n';
		}
	}

	return 0;
}

