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
    ll n, k;
    cin>>n>>k;

    ll a = n, b = 1;
    for(int i = 1;i<k;i++){
    	// for a
    	if(a == 1)	
    		a = n;
    	else
    		a--;

    	// for b
    	if(b == n){
    		b = 1;
    	} else { 
    		b++;
    	}
    	if( b == a){
    		if(b == n)
    			b = 1;
    		else b++;
    	}
    	// k--;
    }
    cout<<b<<endl;
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
        cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    }
    return 0;
}