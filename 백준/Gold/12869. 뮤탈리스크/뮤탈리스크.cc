#include <bits/stdc++.h>
using namespace std;

const int INF = 99999999;
int n, a[3], visited[64][64][64];
int _a[6][3]={
    {9,3,1},
    {9,1,3},
    {3,9,1},
    {3,1,9},
    {1,9,3},
    {1,3,9}
};
struct A{
    int a, b, c;
};
queue<A> q;
int solve(int a, int b, int c){
    visited[a][b][c]=1;
    q.push({a,b,c});
    while(q.size()){
        int A = q.front().a;
        int B = q.front().b;
        int C = q.front().c;
        q.pop();
        if(visited[0][0][0]) break;
        for(int i=0; i<6; i++){
            int na = max(0,A-_a[i][0]);
            int nb = max(0,B-_a[i][1]);
            int nc = max(0,C-_a[i][2]);
            if(visited[na][nb][nc]) continue;
            visited[na][nb][nc] = visited[A][B][C]+1;
            q.push({na,nb,nc});
        }
    }
    return visited[0][0][0]-1;
}
int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> a[i];
    }
    
    cout << solve(a[0],a[1],a[2]) <<"\n";
    return 0;
}