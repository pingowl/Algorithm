#include <bits/stdc++.h>
using namespace std;

struct cmp{
    bool operator()(vector<int> &a, vector<int> &b){
        return a[1] > b[1];
    }
};
int solution(vector<vector<int>> jobs) {
    int answer = 0, now=0;
    sort(jobs.begin(), jobs.end());
    priority_queue<vector<int>, vector<vector<int>>, cmp> pq;
    int i=0;
    while(i <jobs.size() || !pq.empty()){
        if( i< jobs.size() && now >= jobs[i][0]){
            pq.push(jobs[i++]);
            continue;
        }
        if(!pq.empty()){
            now += pq.top()[1];
            answer += now - pq.top()[0];
            pq.pop();
        } else{
            now = jobs[i][0];        
        }
    }
    return answer/ jobs.size();
}