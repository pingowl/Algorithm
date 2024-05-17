#include <bits/stdc++.h>
using namespace std;

long long solution(int n, vector<int> times) {
    long long answer = 0, l=0, r, mid;
    sort(times.begin(), times.end());
    r = (long long) times.back() * n;
    
    while(l <= r){
        mid = (l + r) /2;
        long long done=0;
        for(int t : times){
            done += mid / t;
        }
        if(done < n)
            l = mid +1;
        else{
            answer = mid;
            r = mid -1;
        }            
    }
    
    return answer;
}