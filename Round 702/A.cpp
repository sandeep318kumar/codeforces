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
    deque<int>Q;
    for(ll i=0;i<n;i++){
        cin>>A[i];
        Q.push_back(A[i]);
    }
    int res = 0;
    while(Q.size() > 1){
    	int x = Q.front();
    	Q.pop_front();
    	int y = Q.front();
        // cout<<x<<" ";;
    	if(max(x, y) <= 2* min(x, y)){
    		continue;
    	} else{
    		// cout<<"hello\n";
    		res++;
    		if(x < y){
    			Q.push_front(2*x);
    		} else{
    			int z = x%2;
    			if(z == 0){
    				Q.push_front(x/2);
    			} else{
    				Q.push_front((x/2)+1);
    			}
    		}
    	}
    }
    cout<<res<<"\n";
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