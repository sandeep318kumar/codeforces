 // Author -> Sandeep Kumar: sk921815
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
    vl f(n + 1);
    vi a(n + 1);
    for(int i = 1;i<=n;i++) {
        cin>> f[i];
    }
    ll f_first = f[1];
    ll f_last = f[n];
    for(int i = 2;i<=n-1;i++) {
        a[i] = ((f[i + 1] - f[i]) - (f[i] - f[i - 1])) / 2;
        f_first -= a[i] * ( i - 1);
        f_last -= a[i] * (n - i);
    }
    a[1] = f_last / (n - 1);
    a[n] = f_first / (n - 1);


    for(int i = 1;i<=n;i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

int main()
{
    // use code runner for C++ in vs code and have input and output.txt file. also modify code runner executer map to this.code-runner.executorMap
    // "cpp": "cd $dir && mkdir -p build && g++ $fileName -o build/$fileNameWithoutExt && build/$fileNameWithoutExt < input.txt > output.txt",
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    #ifndef ONLINE_JUDGE
    // freopen("input.txt", "r", stdin);
    // freopen("output.txt", "w", stdout);
    #endif

    ll t;
    cin>>t;
    while(t--){ 
        solve();
        // cerr<<"Time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    }
    return 0;
}