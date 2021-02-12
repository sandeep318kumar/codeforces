#include<bits/stdc++.h>
using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;

bool prime(int x){
	for(ll i=2;i<=sqrt(x);i++){
		if(x%i == 0)
			return false;
	}
	if(x != 1)
		return true;
	return false;
}
void solve()
{
    ll a, b;
    cin>>a>>b;

    ll res = 0;
    ll t = b+1;

    while(!prime(t)) t++;
    if(t - b <= 1 && t < a){
        res += (t - b);
        b = t;
    }
    if(b < a && b == 2){
        b++;
        res++;
    }
    cout<<"B is: "<<b<<endl;
    // b = 7;
    while(a != 0){
    	// cout<<a<<" "<<b<<endl;
    	if( a == b){
    		res++;
    		b++;
    	} 
    	else{
    		res++;
    		a = a/b;
    	}
    }
    cout<<res<<endl;
    fflush(stdout);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    ll t;
    cin>>t;
    while(t--){ 
        solve();
        // cout<<"Hello there\n";
        cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    }
    return 0;
}