#include <bits/stdc++.h>
using namespace std;
int cnt, visited[201][201], m;

void dfs(vector<vector<int>> &computers, int a, int b){
    visited[a][b] = 1;
    for(int i=0; i<m; i++){
        if(computers[b][i] && !visited[b][i]){
            dfs(computers, b, i);
        }
    }
}
int solution(int n, vector<vector<int>> computers) {
    m = n;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(computers[i][j] && !visited[i][j]){
                dfs(computers, i,j);
                cnt++;
            }
        }
    }    
    return cnt;
}