#include<bits/stdc++.h>
using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;
// Peter and Book

bool prime(ll x){

    for(ll i = 2;i*i <= x;i++){
        if(x % i == 0)
            return false;
    }
    return true;
}

bool compare(pi a, pi b){
    if(a.first == b.first){
        return a.second < b.second;
    }

    return a.first > b.first;
}

void solve(){
    int n, k;
    cin>>n>>k;

    vector<pi>A;
    for(int i=0;i<n;i++){
        int a, b;
        cin>>a>>b;
        A.push_back({a, b});
    }

    sort(A.begin(), A.end(), compare);

    map<pi, int>mp;
    for(auto ss: A){
        // cout<<ss.first<<", "<<ss.second<<endl;
        mp[ss]++;
    }

    pi x = A[k-1];
    cout<<mp[x]<<endl;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif

    // ll t;
    // cin>>t;
    // while(t--)
        solve();
    return 0;
}