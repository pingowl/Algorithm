#include <bits/stdc++.h>
using namespace std;
int n, visited[52], ans=51;
vector<string> w;
string b, t;
bool chk(string a, string b){
    int cnt=0;
    for(int i=0; i<a.length(); i++){
        if(a[i] != b[i])
            cnt++;
    }
    if(cnt == 1)
        return true;
    return false;
}
void dfs(int a, int cnt){
    if(a != -1 && w[a]==t){
        ans = min(ans, cnt);
        return;
    }
    for(int i=0; i<n;i++){
        if(a == -1){
            if(visited[i] || !chk(b, w[i])) continue;
        } else{
            if(visited[i] || !chk(w[a], w[i])) continue;
        }
        visited[i]=1;
        dfs(i, cnt+1);
        visited[i]=0;
    }
}
int solution(string begin, string target, vector<string> words) {
    n = words.size();
    auto it = find(words.begin(), words.end(), target);
    if(it == words.end())
        return 0;
    w = words; b = begin; t = target;
    dfs(-1, 0);
    
    return ans;
}