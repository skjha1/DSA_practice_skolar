#include <bits/stdc++.h>
using namespace std;
bool compare(int myList_1, int myList_2){
   return ( int(myList_1)<int(myList_2) );
}
int main(){
   //create a list
   list<int> myList_1 = {2, 4, 1 };
   list<int> myList_2 = {7, 6, 5 };
   myList_1.sort();
   myList_2.sort();
   //using merge() function to merge the lists
   myList_1.merge(myList_2);
   myList_2.push_back (3);
   myList_1.merge(myList_2,compare);
   cout<<"List Elements are : ";
   for(auto i = myList_1.begin(); i!=myList_1.end(); ++i)
      cout<< ' ' << *i;
   return 0;
}
