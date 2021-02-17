#include<bits/stdc++.h>
using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;

bool compare(pi a, pi b){
    return a.first < b.first;
}
void solve()
{
    ll n;
    cin>>n;
    vector<int>cc(3);
    for(ll i=0;i<n;i++){
        int x;
        cin>>x;
        cc[x%3]++;
        
    }
    // 1, 2, 3
    int res = 0;
    while(1){
        for(int i = 0;i<3;i++){
            if(cc[i] > n/3){
                int diff = cc[i] - n/3;
                cc[(i+1)%3] += diff;
                res += diff;
                cc[i] -= diff; 
            }
        }

        bool flag = true;
        for(int i = 0;i<3;i++){
            if(cc[i] != n/3){
                flag = false;
                break;
            }
        }
        if(flag)    
            break;
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