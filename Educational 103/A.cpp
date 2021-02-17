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
    ll n;
    cin>>n;
    vector<ll>A(n);
    for(ll i=0;i<n;i++){
        cin>>A[i];
    }
    sort(A.begin(), A.end());

    vector<ll>small(n, 0);
    int res = 0;
    for(int i=1;i<n;i++){
    	if(A[i] > A[i-1]){
    		small[i] = 1 + small[i-1];
    		res++;
    	} else{
    		small[i] = small[i-1];
    		if(A[i] == A[i-1] && small[i-1] != 0){
    			res++;
    		}
    	}
    }
    cout<<res<<endl;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    ll t;
    cin>>t;
    while(t--){ 
        solve();
        // cout<<"Hello\n";
        cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    }
    return 0;
}