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
    int n, x;
    cin>>n>>x;
    queue<int>Q;
    vi A(n);
    for(int i=0;i<n;i++){
        cin>>A[i];
        // Q.push(A[i]);
        // A.push_back(y);
    }

    ll res = 0;
    int i = 0, j = 1;
    while(A[i%n] % j == 0){
    	res += A[i%n];
    	++i;
    	if(i == n){
    		j = j*x;
    	}
    }

    // ll sum = 0;
    // while(Q.front() % x == 0){
    // 	int y = Q.front();
    // 	sum += y;
    // 	Q.pop();
    // 	int z = y/x;
    // 	if(z % x == 0){
    // 		for(ll i = 0;i<x;i++){
		  //   	Q.push(z);
		  //   }
    // 	} else{
    // 		sum += y;
    // 		break;
    // 	}
    // }	
   
    // while(!Q.empty()){
    // 	sum += Q.front();
    // 	if(Q.front() % x == 0){
    // 		sum += Q.front();
    // 	} 
    // 	Q.pop();
    // }
    // cout<<sum<<endl;
    cout<<res<<endl;
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