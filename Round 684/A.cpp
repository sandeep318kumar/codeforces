#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;
int main()
{
    int t;
    cin>>t;
    while(t--){
        int n, c0, c1, h;
        cin>>n>>c0>>c1>>h;
        string s;
        cin>>s;
        int sum = 0;
        int a = 0, b = 0;
        for(int i=0;i<s.length();i++){
            if(s[i] == '0'){
                a = c0;
                b = c1 + h;
            } else{
                b = c1;
                a = c0 + h;
            }
            sum += min(a, b);
        }
        cout<<sum<<endl;
    }
    return 0;
}
