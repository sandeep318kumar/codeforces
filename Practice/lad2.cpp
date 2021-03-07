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

// magic numbers
void solve()
{
    cout<<"hello\n";
    int n;
    cin>>n;
    cout<<n<<endl;
    // int a, b, n;
    // cin>>a>>b >>n;

    // string num = to_string(a);
    // for(int i=0;i<n;i++){
    //     bool flag = true;
    //     for(int j = 0;j<10;j++){
    //         string temp = num;
    //         temp.push_back(j + '0');
    //         int x = stoi(temp);
    //         if(x % b == 0){
    //             flag = false;
    //             num = temp;
    //             break;
    //         }
    //     }

    //     if(flag){
    //         cout<<"-1";
    //         return;
    //     }
    // }
    // cout<<num;
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