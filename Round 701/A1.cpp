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

    int res = 40; // some dummy value
    // here till 32 because 2^32 > 10^9
    // cout<<pow(2, 30)<<", "<<1e9<<endl;
    for(int i=0;i<31;i++){
        int temp = a, count = 0;
        
        if(b + i == 1) continue;
        while(temp != 0){
            count++;
            temp = temp/(b+i);
        }
        // cout<<b+i<<", "<<count+i<<endl;
        res = min(res, count+i);
    }
    cout<<res<<endl;
    fflush(stdout);
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
        // cout<<"Hello there\n";
        cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    }
    return 0;
}