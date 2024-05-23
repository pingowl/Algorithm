#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> scoville, int k) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i: scoville){
        pq.push(i);
    }
    while(pq.size() > 1 && pq.top()<k){
        int mix;
        mix = pq.top(); pq.pop();
        mix += 2* pq.top(); pq.pop();
        pq.push(mix);
        answer++;
    }
    if(pq.top() < k)
        answer = -1;
    
    return answer;
}