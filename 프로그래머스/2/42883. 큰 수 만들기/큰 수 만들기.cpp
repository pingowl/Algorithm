#include <bits/stdc++.h>
using namespace std;

string solution(string number, int k) {
    string answer = "";
    int l=0, n;
    n = number.length();
    while(l<n && answer.length() <n-k){
        int mx=0;
        for(int i=l; i<(k+answer.length()+1); i++){
            if(mx < int(number[i]-'0')){
               mx = int(number[i]-'0');
               l = i+1;
            }
        }
        answer += to_string(mx);
    }
    return answer;
}