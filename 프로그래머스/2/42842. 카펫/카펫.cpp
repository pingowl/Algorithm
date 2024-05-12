#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    int sum_, mult, x1, x2, tmp;
    sum_ = (brown + 4)/2;
    mult = yellow + brown;
    tmp = sqrt(sum_ * sum_ - 4 * mult);
    x1 = ( sum_ + tmp) / 2;
    x2 = ( sum_ - tmp) / 2;
    answer.push_back(max(x1, x2));
    answer.push_back(min(x1, x2));
    return answer;
}