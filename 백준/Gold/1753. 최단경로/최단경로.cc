#include <iostream>
#include <queue>
#include <vector>
#include <climits>
using namespace std;
vector<pair<int, int>> adj[20001];
vector<int> dist(20001, INT_MAX);
int v, e, k;

void dijkstra(int k) {
	dist[k] = 0;
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
	pq.push({ 0,k });

	while(!pq.empty()) {
		int cur_dist = pq.top().first;
		int cur = pq.top().second;
		pq.pop();

		if (dist[cur] < cur_dist) continue;

		for (auto& k : adj[cur]) {
			int next_dist = k.first;
			int next = k.second;
			if (dist[next] > next_dist + cur_dist) {
				// 거리 갱신될 경우
				dist[next] = next_dist + cur_dist;
				pq.push({dist[next], next});
			}
		}
	}

	// 결과 출력
	for (int i = 1; i < v + 1; i++) {
		if (dist[i] == INT_MAX) cout << "INF\n";
		else cout << dist[i] << "\n";
	}
}

int main(){
	cin >> v >> e >> k;
	while (e--) {
		int a, b, c; cin >> a >> b >> c;
		adj[a].push_back({ c,b });
	}
	dijkstra(k); // 시작점 k
	return 0;
}