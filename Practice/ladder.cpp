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

    vi A(7, 0);
    for(int i=0;i<7;i++){
        cin>>A[i];
    }

    int i = 0;
    while(n > 0){

        n -= A[i%7];
        i++;
        // cout<<n<<"\n";
        
        if(n <= 0){
            cout<<i%8;
            int b = i/7;
            // (b > 0) ? cout<<i%7 : cout<<i%7 + 1;
        }
    }
    // cout<<i%7;
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