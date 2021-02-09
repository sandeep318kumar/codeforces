#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;
int main()
{
    ll t;
    cin>>t;
    while(t--){
        ll x, y;
        cin>>x>>y;
        if( x != y){
            cout<< 2 * min(x, y) + (2 * abs(x - y)) - 1;
        }
        else
            cout<<2*x;
                    cout<<endl;   }

    return 0;
}
