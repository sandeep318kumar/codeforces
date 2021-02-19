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
    vector<ll>x(n), y(n);
    for(ll i=0;i<n;i++){
        cin>>x[i];
        cin>>y[i];
    }

    sort(x.begin(), x.end());
    sort(y.begin(), y.end());

    int res = 0;
    
    if(n%2 != 0){
    	res = 1;
    } else{
    	int loc = n/2;
    	vector<pair<int, int> > B(4);
    	B[0] = make_pair(x[loc], y[loc]);
    	B[1] = make_pair(x[loc-1], y[loc-1]);
    	B[2] = make_pair(x[loc], y[loc-1]);
    	B[3] = make_pair(x[loc-1], y[loc]);
    	
    	vector<pair<int, int>> A;
    	A.push_back(B[0]);
    	res++;
    	for(int i = 1;i<4;i++){
    		bool flag = true;
    		for(int j = 0;j<A.size();j++){
    			if(B[i].first == A[j].first && B[i].second == A[j].second){
    				flag = false;
    				break;
    			}
    		}
    		if(flag){
    			A.push_back(B[i]);
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
    
    ll t;
    cin>>t;
    while(t--){ 
        solve();
        cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    }
    return 0;
}