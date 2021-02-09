#include<bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin>>t;
    while(t--){ 
        long long int n;
        cin>>n;
        
        // if(n % 2 != 0){
        //     cout<<"Yes\n";
        // } else{
        //     bool flag = true;
        //     for(long long int i=3;i<=n/2;i+=2){
        //         if(n%i == 0){
        //             flag = false;
        //             break;
        //         }
        //     }
        //     if(flag == true){
        //         cout<<"No\n";
        //     } else cout<<"Yes\n";
        // }
        while(n%2 == 0){
            n = n/2;
        }
        if(n == 1){
            cout<<"No\n";
        } else cout<<"Yes\n";

    }
    return 0;
}
