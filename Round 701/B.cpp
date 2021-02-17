#include<bits/stdc++.h>
using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;

void solve()
{
    ll n, q, k;
    cin>>n>>q>>k;
    vector<ll>A(n);
    for(ll i=0;i<n;i++){
        cin>>A[i];
    }   
    while(q--){
    	ll l, r;
    	cin>>l>>r;
    	ll res = 0;
        res += (k - A[l-1] + A[r-1] - 2*(r - l) - 1);
	    cout<<res<<endl;
    }
    
    // res += (A[1] - 1 - 2);
    // res += (A[n-2] - k - 1);
    // cout<<res<<endl;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    // ll t;
    // cin>>t;
    // while(t--){ 
        solve();
        cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    // }
    return 0;
}