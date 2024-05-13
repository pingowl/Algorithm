#include <bits/stdc++.h>
using namespace std;

map<int, int> mp;
int  visited[8], len;
string num;
void chk(int n){
    if(n==0 || n==1)
        return;
    for(int i=2; i<n; i++){
        if(n % i == 0) 
            return;
    }
    mp[n]++;
}
void dfs(string s){

    for(int i=0; i<len; i++){
        if(visited[i]) continue;
        visited[i] = 1;
        chk(stoi(s+num[i]));
        dfs(s+num[i]);
        visited[i] = 0;
    }
}
int solution(string numbers) {
    len = numbers.length();
    num = numbers;
    dfs("");

    return mp.size();
}