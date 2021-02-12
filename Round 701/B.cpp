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
    	vl B;
    	B.push_back(1);
    	for(ll i = l-1;i<r;i++){
    		B.push_back(A[i]);
    	}
    	B.push_back(k);
    	ll res = 0;
	    for(ll i=1;i<B.size()-1;i++){
	    	res += (B[i+1] - B[i-1] - 2);
	    }
	    res+=2;
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