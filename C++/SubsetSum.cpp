
class Solution{   
public:
    bool isSubsetSum(int N, int arr[], int sum){
        // code here 
        if(N<0)
        return false;
        if( sum==0)
            return true;
        if(isSubsetSum(N-1 , arr , sum-arr[N-1]))
            return true;
        
        if(isSubsetSum(N-1,arr,sum))
            return true;
        return false;
        
        
    }
};
