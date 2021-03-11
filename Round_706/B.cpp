#include<bits/stdc++.h>
using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;

void print(set<ll>st){
	for(auto i: st){
		cout<<i<<" ";
	}
	cout<<endl;
}

ll mex(set<ll>st){

	ll i = 0;
	for(auto j: st){
		if(i != j){
			return i;
		}
		i++;
	}
	return i;
}
void solve()
{
    ll n, k;
    cin>>n>>k;

    set<ll>st;
    for(ll i=0;i<n;i++){
    	ll x;
    	cin>>x;
    	st.insert(x);
    }
    // print(st);

    ll mx = *st.rbegin();
    ll me = mex(st); 

    ll ans = 0;
    if(me < mx){
    	ans = st.size();
    	
    	// while(k--){
    	ll c = ceil((double)(me + mx)/2.0);
    	st.insert(c);
    	// }
    	if(k != 0) ans = st.size();
    } else{
    	ans = st.size() + k;
    }

    cout<<ans<<endl;
}	

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    #ifndef ONLINE_JUDGE
    // freopen("input.txt", "r", stdin);
    // freopen("output.txt", "w", stdout);
    #endif

    ll t;
    cin>>t;
    while(t--)
        solve();
    return 0;
}

/*
output
4
4
3
5
3
*/