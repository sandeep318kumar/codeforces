// // #include<iostream>
// #include<bits/stdc++.h>
// // #include<cmath>
// using namespace std;
// int main()
// {
// 	int n;
// 	int m;
// 	// cout<<"Enter n\n";
// 	cin>>n;
// 	int arrb[n];
	

// 	for(int i=0;i<n;i++){
// 		// cout<<"Hello\n";
// 		cin>>arrb[i];
// 		// cout<<arrb[i]<<" ";
// 	}
// 	cout<<endl;
// 	cin>>m;
// 	int arrg[m];
// 	for(int i=0;i<m;i++){
// 		cin>>arrg[i];
// 		// cout<<arrg[i]<<" ";
// 	}
// 	sort(arrb, arrb+n);
// 	sort(arrg, arrg+m);
// 	int result=0;	
// 	for (int i = 0; i < n; i++){
// 	    for (int j = 0; j < m; j++){
// 	        if (abs(arrb[i] - arrg[j]) <= 1)
// 	        {
// 	          	arrg[j]=-1;
// 	            result++;
// 	            break;
// 	        }
// 	    }
// 	}
// 	// cout<<"1\n";
//     cout<<result;
//     return 0;
// }


#include<iostream>
#include<bits/stdc++.h>
#include<cmath>
using namespace std;
int main()
{
	int n;
	int m;
	cin>>n;
	
	int arrb[n];
	for(int i=1;i<=n;i++){
		cin>>arrb[i];
	}

	cin>>m;
	int arrg[m];
	for(int i=1;i<=m;i++){
		cin>>arrg[i];
	}
	sort(arrb,arrb+n);
	sort(arrg,arrg+n);
	int result=0;	
	for (int i = 1; i <= n; i++){
	    for (int j = 1; j <= m; j++)
	        if (abs(arrb[i] - arrg[j]) <= 1)
	        {
	          arrg[j]=-1;
	            result++;
	            break;
	        }
	}
    cout<<result;
    return 0;
}