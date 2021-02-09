#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;
typedef pair<ll, ll> pp;

struct compare{
    constexpr bool operator()( pair<int, int> const& a, pair<int, int> const& b) const noexcept 
    { 
        return a.first > b.first; 
    } 
};
void solve()
{
    ll A, B, n;
    cin>>A>>B>>n;
    vector<ll>ai(n), bi(n);
    // priority_queue<pp, vector<pp>, compare>Q;
    queue<pp>Q;
    for(ll i =0;i<n;i++){
        cin>>ai[i];
    }
    for(ll i =0;i<n;i++){
        cin>>bi[i];
    }
    for(ll i=0;i<n;i++){
        Q.push({ai[i], bi[i]});
    }

    while(!Q.empty() && B > 0){
        pp x = Q.front();
        Q.pop();
        B -= x.first;
        x.second -= A;
        if(x.second > 0){
            Q.push(x);
        } 
    }

    if(Q.empty())
        cout<<"YES\n";
    else 
        cout<<"NO\n";


}
int main()
{
    int t;
    cin>>t;
    while(t--){ 
        solve();
        cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl; 
    }
    return 0;
}
