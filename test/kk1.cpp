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
    ll m;
    cin>>m;
    vector<ll>B(m);
    for(ll i=0;i<m;i++){
    	cin>>B[i];
    }
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    int result=0;	
	for (int i = 0; i <n; i++){
	    for (int j = 0; j < m; j++){
	        if (abs(A[i] - B[j]) <= 1)
    	        {
	          	B[j]=-1;
	            result++;
	            break;
	        }
	    }
	}
	// cout<<"1\n";
    cout<<result;
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