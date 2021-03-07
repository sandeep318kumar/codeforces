#include<bits/stdc++.h>
using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;

bool check(string s){
	// checking whether a string is valid parenthsis or not using stack
	stack <char> st;
	for(int i=0;i<s.size();i++){
		if(s[i] == '(')
			st.push('(');
		else{
			if(st.size() == 0)
				return false;
			else{
				if(st.top() == '(')
					st.pop();
				else
					return false;
			}
		}
	}
	return st.empty();
}

void solve()
{
    string s;
    cin>>s;

    // storing all possible values of A, B, and C
    // 0 -> A
    // 1 -> B
    // 2 -> C
   	char dir[8][3] = { { '(', '(', '('}, { ')', ')', ')'}, 
   						{ '(', '(', ')'}, { '(', ')', '('}, { ')', '(', '('}, 
   						{ '(', ')', ')'}, { ')', ')', '('}, { ')', '(', ')'},
   					};
   	for(int i=0;i<8;i++){
   		string s1;
   		for(auto j: s){
   			if(j == 'A'){
   				s1.push_back(dir[i][0]);
   			} else if(j == 'B'){
   				s1.push_back(dir[i][1]);
   			} else{
   				s1.push_back(dir[i][2]);
   			}
   		}
   		// cout<<s1<<", ";
   		if(check(s1)){
   			// if anyone solution is Yes then print yes and return
   			cout<<"Yes\n";
   			return;
   		}
   	}
   	cout<<"No\n";
}

// void solve()
// {
// 	string s;
// 	cin>>s;

// 	if(s[0] == s[s.size() -1 ]){
// 		cout<<"No\n";
// 		return;
// 	} else{
// 		map<char, char>mp;
// 		mp[s[0]] = '(';
// 		mp[s[s.size() -1]] = ')';
// 		string ss1, ss2;
// 		for(int i=0;i<s.size();i++){
// 			map<char, char>::iterator it;
// 			if(mp.count(s[i]) != 0){
// 				ss1.push_back(mp[s[i]]);
// 				ss2.push_back(mp[s[i]]);
// 			} else{
// 				ss1.push_back(')');
// 				ss2.push_back('(');
// 			}
// 		}
// 		// cout<<ss1<<" "<<ss2<<endl;
// 		if(check(ss1) || check(ss2)){
// 			cout<<"Yes\n";
// 		} else{
// 			cout<<"No\n";
// 		}
// 	}
// }

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