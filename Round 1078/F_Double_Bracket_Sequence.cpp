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
const int INF = 1e9;

vector<vector<vector<int>>>dp;
// b1 for (, )
// b2 for [, ]
int check(string &s, int n, int i, int b1, int b2) {
    if(b1 < 0 || b2 < 0) return INF;
    if(i == n) {
        if(b1 == 0 && b2 == 0) return 0;
        return INF;
    }

    if(dp[i][b1][b2] != -1) return dp[i][b1][b2];
    // 4 brackets to put and try. (, ), [, ]
    int ans = INF;
    // trying (
    ans = min(ans, (s[i] != '(') + check(s, n, i + 1, b1 + 1, b2));

    // trying )
    if(b1 > 0) {
        ans = min(ans, (s[i] != ')') + check(s, n, i + 1, b1 - 1, b2));
    }

    // trying [
    ans = min(ans, (s[i] != '[' ) + check(s, n, i + 1, b1, b2 + 1));

    // trying ].
    if(b2 > 0) {
        ans = min(ans, (s[i] != ']') + check(s, n, i + 1, b1, b2 - 1));
    }
    return dp[i][b1][b2] = ans;
}
void solve()
{
    int n;
    cin>> n;
    string s;
    cin>> s;

    dp.assign(n+1, vector<vector<int>>(n+1, vector<int>(n + 1, INF)));
    dp[0][0][0] = 0;
    for(int i = 0;i<n;i++) {
        for (int b1 = 0;b1 <=i;b1++) {
            for(int b2 = 0;b2 <= i;b2++) {
                if(dp[i][b1][b2] == INF) continue;
                int curr = dp[i][b1][b2];
                
                // calculate 4 ways now (, ), [, ]
                dp[i + 1][b1 + 1][b2] = min(dp[i+1][b1 + 1][b2], curr + (s[i] != '(')); // (
                if(b1 > 0) {
                    dp[i+1][b1 - 1][b2] = min(dp[i+1][b1 -1][b2], curr + (s[i] != ')')); // )
                }

                dp[i+1][b1][b2 + 1] = min(dp[i + 1][b1][b2 + 1], curr + (s[i] != '[')); // [
                if(b2 > 0) {
                    dp[i + 1][b1][b2 - 1] = min(dp[i + 1][b1][b2 - 1], curr + (s[i] != ']'));
                }
            }
        }
    }
    cout << dp[n][0][0] << endl;
    // cout << check(s, n, 0, 0, 0) << "\n";
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
        // cerr<<"Time taken: "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    }
    return 0;
}