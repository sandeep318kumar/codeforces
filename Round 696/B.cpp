#include<bits/stdc++.h>
using namespace std;

bool prime(int a){
    for(int i=2;i <= sqrt(a);i++)
        if(a%i == 0)
            return false;
    return true;
}
int main()
{
    int t;
    cin>>t;
    while(t--){ 
        int d;
        cin>>d;
        int t1, t2;
        t1 = 1 + d;
        while(!prime(t1))   t1++;
        t2 = t1 + d;
        while(!prime(t2))  t2++;
        cout<<t1*t2<<endl;
    }
    return 0;
}
