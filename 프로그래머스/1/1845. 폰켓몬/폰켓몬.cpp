#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0, n;
    n = nums.size();
    map<int,int> mp;
    for(int i=0; i<n; i++){
        mp[nums[i]]++;
        if(mp.size() >= n/2)
            break;
    }
    
    answer = mp.size();
    return answer;
}