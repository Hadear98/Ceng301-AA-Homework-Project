/*QUESTION 3- Given an amount and the denominations of coins available, please write a code that calculates how
many ways change can be made for amount. There is a limitless supply of each coin type. To solve the problem you can
use either recursive approach or dynamic programming approach. Signature of the function could be:
public long getWays(int amount, List<int> coinTypes) {
...
}
Sample: For instance, if amount=3 and coinTypes =[8, 3, 1, 2], the return value of the code must be “3” as there can be
only three ways ({1,1,1}, {1, 2}, and {3}) to give change back.
*/

#include<bits/stdc++.h>
using namespace std;


int getWays(int amount, int ind, vector<int> &coinTypes){
    if(ind==0){
// if it is true, then 1 is returned. If false, then 0 is returned.
        return (amount%coinTypes[ind]==0);
    }

    int notTake = 0, take = 0; 

    notTake = getWays(amount, ind-1, coinTypes);
	
// //we first need to check whether the current coin value is smaller than the amount or not
    if(amount >= coinTypes[ind]) take = getWays(amount-coinTypes[ind], ind, coinTypes);

    return (notTake + take); // get total no of ways
}

int main(){
    int amount; cin>>amount;
    int n; cin>>n;
    vector<int> coinTypes(n);

    for(int i=0; i<n; i++){
        cin>>coinTypes[i];
    }

    cout<<"Total no. of ways: "<<getWays(amount, n-1, coinTypes);
}

/*
Time Complexity
Since for every index, we make two choices of take and not take
So the time complexity for worst, best and average case is O(2^n)
*/
