#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n;
    cin>>n;
    n *= 2;
    vector<int>A(n);
    for(int i=0;i<n;i++)
        cin>>A[i];
        
    sort(A.begin(), A.end());
    for(int i=0;i<n-1;i++){
        multiset<int>st;
        for(int j = 0;j<n-1;j++){
            if(i != j)
            st.insert(A[j]);
        }

        int x = A[i] + A[n-1];
        vector<pair<int, int>>ans;
        ans.push_back({A[i], A[n-1]});
         //updating x here to max value and that's last value
        int curr = A[n-1];

        while(!st.empty()){
            // remove last element
            auto a = *(--st.end());
            st.erase(--st.end());

            // now find out other value
            auto it = st.find(curr - a);
            if(it == st.end())
                break;
                
            ans.push_back({a, curr - a});
            st.erase(it);
            curr = a;
        }
        if(st.empty()){
            cout<<"YES\n";
            cout<<x<<endl;
            for(auto &x: ans){
                cout<<x.first<<" "<<x.second<<endl;
            }
           return;
        }
    }
    cout<<"NO\n";   
}
int main()
{
    int t;
    cin>>t;
    while(t--){ 
        solve();
    }
    return 0;
}
