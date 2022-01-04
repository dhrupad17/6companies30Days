#include <bits/stdc++.h>
using namespace std;

void findMinFromPattern(string s){
	stack<int> st; //stack declared using STL
	for(int i=0;i<=s.length();i++){
		//push i+1 at first, i+1 becuase i is 0-indexed 
		st.push(i+1); 
		//when string length is processed or pattern in I
		if(s.length()==i || s[i]=='I' ){ 
			//pop and print until stack is empty
			while(!st.empty()){ 
				cout<<st.top();
				st.pop();
			}
		}
	}
	cout<<endl;
}

int main(){
	cout<<"enter pattern\n";    
	string s;
	cin>>s;
	
	if(s.length()>8){
		cout<<"Not possible,length>8\n";
	}
	else{
		cout<<"The minimum number generated is:\n";
		findMinFromPattern(s);//function to print
	}
	
	return 0;
}
