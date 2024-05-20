#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    unordered_map<string, int> mp;
    for(vector<string> v: clothes){
        mp[v[1]]++;
    }
    for(auto itr = mp.begin(); itr != mp.end(); itr++){
        answer *= (itr->second)+1;
    }
    return answer-1;
}