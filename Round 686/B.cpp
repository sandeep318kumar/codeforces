#include<bits/stdc++.h>
using namespace std;

bool comp(pair<int, int>p1, pair<int, int>p2)
{
    return p1.first > p2.first;
}
int main()
{
    ofstream f("output.txt");
    int t;
    cin>>t;
    while(t--){ 
        int n;
        cin>>n;
        int A[n];
        vector<pair<int, int>>vec;
        map<int, vector<int>>mp;
        for(int i=0;i<n;i++){
            cin>>A[i];
            vec.push_back({A[i], i+1});
            mp[A[i]].push_back(i+1);
        }
        sort(vec.begin(), vec.end(), comp);
        int ff = 0;
        for(auto i:mp){
            if(i.second.size() == 1){
                ff = 1;
                f<<i.second[0];
                cout<<i.second[0];
                break;
            }
        }
        if(ff == 0){
            cout<<"-1";
            f<<"-1";
        }
            f<<endl;
        cout<<endl;
        mp.clear();
    }
    return 0;
}
