#include<bits/stdc++.h>
using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;

bool prime(int n){
    for(int i = 2;i<= sqrt(n);i++){
        if(n%i == 0)
            return false;
    }
    if(n != 1)
        return true;
    else return false;
}

bool compare(pi a, pi b){
    return a.first < b.first;
}
void solve()
{
    int n;
    cin>>n;
    vector<pair<int, int>>A;

    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        A.push_back({a, i+1});
    }

    sort(A.begin(), A.end(), compare);

    // for(auto ss: A){
    //     cout<<ss.first<<" "<<ss.second<<endl;
    // }

    if(A.size() == 1){
        cout<<1;
        return;
    }

    if( A[0].first == A[1].first){
        cout<<"Still Rozdil";
    } else{
        cout<<A[0].second;
    }
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

    // ll t;
    // cin>>t;
    // while(t--)
        solve();
    return 0;
}