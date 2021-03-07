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
        ll n, x;
        cin>>n>>x;
        queue<ll>Q;
        for(ll i=0;i<n;i++){
            ll y;
            cin>>y;
            Q.push(y);
        }
        ll sum = 0;
        while(Q.front() % x == 0){
            cout<<Q.front()<<" ";
        	ll y = Q.front();
        	sum += Q.front();
        	Q.pop();
        	ll z = y/x;
        	if(z % x == 0){
        		for(ll i = 0;i<x;i++){
    	    		Q.push(z);
    	    	}
        	} else{
        		sum += y;
                break;
        	}
        }
        cout<<"\n sum is: "<<sum<<"\n";
        queue<ll> Q1 = Q;
        while(!Q1.empty()){
            cout<<Q1.front()<<" ";
            Q1.pop();
        }
        cout<<endl;
        while(!Q.empty()){
        	sum += Q.front();
            if(Q.front() % x == 0)
                sum += Q.front();
        	Q.pop();
        }
        cout<<sum<<endl;
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