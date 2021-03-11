// C++ program to create a directory in Linux 
#include <bits/stdc++.h> 
#include <iostream>
#include <direct.h> 
#include <sys/stat.h> 
#include <sys/types.h> 
using namespace std; 

int main() 
{ 
	// Creating a directory 
	cout<<"Enter directory name:\n";
	string s;
	cin>>s;
	if (mkdir(s.c_str()) == -1) 
		cerr << "Error : " << strerror(errno) << endl; 

	else{
		cout <<"Directory created"; 

		fstream f;
		string s1 = s + "/A.cpp";
		f.open(s1, ios::out); f.close();
		s1 = s + "/B.cpp";
		f.open(s1, ios::out); f.close();
		s1 = s + "/C.cpp";
		f.open(s1, ios::out); f.close();
		s1 = s + "/input.txt";
		f.open(s1, ios::out); f.close();
		s1 = s + "/output.txt";
		f.open(s1, ios::out); f.close();
	}	

	return 0;
}