#include<bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin>>t;
    while(t--){ 
        int n;
        cin>>n;
        int a = n % 2020;
        int b = n % 2021;
        if(a == 0 || b == 0){
            cout<<"Yes\n";
        } else {
            bool flag =  false;
            int x = n;
            x = x - 2020;
            while(x > 0){
                if(x % 2021 == 0){
                    flag = true;
                    break;
                }
                x = x - 2020;
            }
            if(flag == true)
                cout<<"Yes\n";
            else cout<<"No\n";
        }
    }
    return 0;
}
