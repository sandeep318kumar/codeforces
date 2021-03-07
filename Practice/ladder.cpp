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

void solve()
{
    int n;
    cin>>n;

    vi A(8, 0);
    for(int i=1;i<8;i++){
        cin>>A[i];
    }

    int i = 0;
    while(n > 0){
        n -= A[i];
        if(n <= 0){
            cout<<i;
            return;
        }
        if(i == 7){
            i = 1;
        } else
            i++;
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