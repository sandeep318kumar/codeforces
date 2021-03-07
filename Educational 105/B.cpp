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
    int n;
    cin>>n;
    int u1, d1, r1, l1;
	cin>>u1>>r1>>d1>>l1;
	int u = u1, r = r1, d = d1, l = l1; 
	if(u1 == n){
		r--;
		l--;
	} else if(u1 == n-1){
		if(l > r){
			l--;
		} else{
			r--;
		}
	}

	if(d1 == n){
		r--;
		l--;
	} else if(d1 == n-1){
		if(l > r){
			l--;
		} else{
			r--;
		}
	}

	if(l1 == n){
		u--;
		d--;
	} else if(l1 == n-1){
		if(u > d){
			u--;
		} else{
			d--;
		}
	}

	if(r1 == n){
		u--;
		d--;
	} else if(r1 == n-1){
		if(u > d){
			u--;
		} else{
			d--;
		}
	}

	// cout<<u<<d<<r<<l<<endl;
	if(u >= 0 && d >= 0 && r >= 0 && l >= 0){
		cout<<"Yes\n";
	}
	else
		cout<<"No\n";

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