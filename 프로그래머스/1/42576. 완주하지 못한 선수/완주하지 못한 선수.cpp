#include <bits/stdc++.h>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    unordered_map<string, int> mp;
    for(string p : participant){
        mp[p]++;
    }
    for(string p : completion){
        mp[p]--;
    }
    for(auto iter = mp.begin(); iter != mp.end(); iter++){
        if(iter->second != 0){
            answer = iter->first;
            break;
        }
    }
    
    return answer;
}