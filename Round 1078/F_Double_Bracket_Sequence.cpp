 #ifndef _GLIBCXX_NO_ASSERT
  #include <cassert>
  #endif
  #include <cctype>
  #include <cerrno>
  #include <cfloat>
  #include <ciso646>
  #include <climits>
  #include <clocale>
  #include <cmath>
  #include <csetjmp>
  #include <csignal>
  #include <cstdarg>
  #include <cstddef>
  #include <cstdio>
  #include <cstdlib>
  #include <cstring>
  #include <ctime>

  #if __cplusplus >= 201103L
  #include <ccomplex>
  #include <cfenv>
  #include <cinttypes>
  #include <cstdbool>
  #include <cstdint>
  #include <ctgmath>
  #include <cwchar>
  #include <cwctype>
  #include <exception>
  #include <stdexcept>
  #endif

  // C++
  #include <algorithm>
  #include <bitset>
  #include <complex>
  #include <deque>
  #include <exception>
  #include <fstream>
  #include <functional>
  #include <iomanip>
  #include <ios>
  #include <iosfwd>
  #include <iostream>
  #include <istream>
  #include <iterator>
  #include <limits>
  #include <list>
  #include <locale>
  #include <map>
  #include <memory>
  #include <new>
  #include <numeric>
  #include <ostream>
  #include <queue>
  #include <set>
  #include <sstream>
  #include <stack>
  #include <stdexcept>
  #include <streambuf>
  #include <string>
  #include <typeinfo>
  #include <utility>
  #include <valarray>
  #include <vector>

  #if __cplusplus >= 201103L
  #include <array>
  #include <atomic>
  #include <chrono>
  #include <condition_variable>
  #include <forward_list>
  #include <future>
  #include <initializer_list>
  #include <mutex>
  #include <random>
  #include <ratio>
  #include <regex>
  #include <scoped_allocator>
  #include <system_error>
  #include <thread>
  #include <tuple>
  #include <typeindex>
  #include <type_traits>
  #include <unordered_map>
  #include <unordered_set>
  #endif
using namespace std;

typedef long long ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;
// typedef for(int i = 0;i<n;i++) fori(n);

void solve()
{
    int n;
    cin>> n;
    string s;
    cin>> s;

    vi vis(n, 0);

    stack<int> a, b;
    for(int i = 0;i<n;i++) {
        if(s[i] == '(') a.push(i);
        else if(s[i] == ')') {
            if(!a.empty()) {
                // found a matching pair.
                vis[i] = 1;
                vis[a.top()] = 1;
                a.pop();
            }
        }
    }

    for(int i = 0;i< n;i++) {
        if(s[i] == '[') b.push(i);
        else if(s[i] == ']'){
            if(!b.empty()) {
                vis[i] = 1;
                vis[b.top()] = 1;
                b.pop();
            }
        }
    }

    // now I'll have few open and close brackets which didn't match.
    vector<int> open, close;

    for(int i = 0;i<n;i++) {
        if(vis[i] == 0 && (s[i] == '(' || s[i] == '[')) {
            open.push_back(i);
        } 
        if(vis[i] == 0 && (s[i] == ')' || s[i] == ']')) {
            close.push_back(i);
        }
    }

    // we can match 1 to another for all cases of these 3 {open open, open close, close close} => flip one.
    // in one case when close open or last close appear before first open and it is odd then we have to flip twice => 2.
    // for this ))[[ -> ans is 2, we can flip 1st and 4th.

    int ans = (open.size() + close.size()) / 2;
    // cout << "open ";
    // for(int i: open) {
    //     cout << i<< " ";
    // }
    // cout << "\nclose ";
    // for(int i : close) {
    //     cout << i << " ";
    // }
    // cout << endl;
    if(close.size() & 1) {
        if(open.empty()) {
            // bad pair.
            ans++;
        } else {
            if(close.back() < open[0]) ans++;
        }
    }

    cout << ans << "\n";
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif

    ll t;
    cin>>t;
    while(t--){ 
        solve();
        // cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    }
    return 0;
}