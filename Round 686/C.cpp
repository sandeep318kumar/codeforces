#include<bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin>>t;
    while(t--){ 
        int n;
        cin>>n;
        int A[n];
        for(int i=0;i<n;i++){
            cin>>A[i];
        }
        map<int, vector<int>>mp;
        mp[A[0]].push_back(0);
        for(int i=1;i<n;i++){
            if(A[i] != A[i-1] && i != 1){
                mp[A[i-1]].push_back(i);
            }
        }
        int m = INT_MAX;
        mp[A[n-1]].push_back(n-1);

        if(mp.size() == 1){
            m = 0;
        }
        else{
            for(auto i:mp)
            {
                int m1 = i.second.size() - 1;
                if(i.second[0] != 0)
                    m1++;

                if(i.second[i.second.size()-1] != n-1)
                    m1++;
                m = min(m1, m);
            }
        }
        // cout<<"hi ";
        cout<<m<<endl;
    }
    return 0;
}
