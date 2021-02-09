#include<bits/stdc++.h>
// #include<ofstream>
using namespace std;

// void solve()
// {
//     string s;
//     cin>>s;
//     bool flag = true;

//     for(int i=0;i<s.size();i++){
//         if(flag == true){
//             if(s[i] == 'a')
//                 s[i] = 'b';
//             else s[i] = 'a';
//         } else{
//             if(s[i] == 'z')
//                 s[i] = 'y';
//             else
//                 s[i] = 'z';
//         }
//         flag = !flag;
//     }
//     cout<<s<<endl;
// }
int main()
{
    // int t;
    // cin>>t;
    // while(t--){ 
    //     solve();
    // }
    // return 0;
    ofstream ff;
    ff.open("input.txt");
    for(int i=1;i<210;i++){
        ff<<i<<endl;
    }
}
