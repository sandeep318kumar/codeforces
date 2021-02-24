#include<bits/stdc++.h>
using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;

bool check(int n1){
    vector<int>d(10, 0); // we have 10 digits for 0, 1, 2, to 9
    // and here indexing works in the the same way 

    while(n1){
        d[n1%10]++; // we have a digit so increase the value at that location by one
        n1 = n1/10; // divide it by 10
    }
    for(auto &x : d){
        if(x > 1) // if any value is greater than 1 means 2, 3 ..
            return false; // so means we have seen this digit twice
    }
    return true;// if have not returned false so return true and this would be our lucky number
}
void solve()
{
    int n;
    cin>>n;

    vi A(n+1, 0);
    A[1] = 1;
    for(int i = 2;i<=n;i++){
        
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