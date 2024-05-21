#include <bits/stdc++.h>
using namespace std;

int solution(int distance, vector<int> rocks, int n) {
    int answer = 0;
    int l=0, r, mid;
    r = distance;
    sort(rocks.begin(), rocks.end());
    rocks.push_back(distance);
    
    while(l <= r){
        mid = (l + r)/2;
        int removed=0, prevRock=0;
        
        for(int rock : rocks){
            int dist = rock - prevRock;
            if(dist < mid){
                removed++;
                if(removed > n)
                    break;
            }
            else{
                prevRock = rock;
            }
        }
        if(removed > n)
            r = mid-1;
        else{
            answer = mid;
            l = mid +1;
        }
    }
    
    return answer;
}