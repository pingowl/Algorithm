#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0, n;
    n = people.size();
    sort(people.begin(), people.end());
    for(int l=0, r=n-1; l<=r; r--){
        if(l==r){
            answer++; break;
        }
        if(people[l] + people[r] > limit){
            answer++; 
        } else{
            l++; 
            answer++;
        }
    }
    
    return answer;
}