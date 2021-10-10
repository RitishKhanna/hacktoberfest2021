#include <bits/stdc++.h>
using namespace std;
 
int maxBit(int a[], int n)
{
    int max = a[0], count = 0;
    for (int i = 1; i < n; i++){
        if (max < a[i])
            max = a[i];
    }
    while(max){
        max = max / 10;
        count++;
    }
    return count;
}

 
void redixSort(int arr[], int n, int count)
{
    queue<int> q[10];
    for (int r = 1; r <= count; r++){
        int k = 0;
        for (int i = 0; i < n; i++)
            q[(arr[i]/(int)pow(10,r-1))%10].push(arr[i]);
        for (int j = 0; j <= 9; j++)
            while (!q[j].empty()){
                arr[k++] = q[j].front();
                q[j].pop();
            }
    }
}
 
void printArray(int arr[], int size)
{
    for (int i=0; i < size; i++)
        cout << arr[i] << " ";
    cout << endl;
}
 
int main()
{
    int arr[] = {2, 5, 90, 3390, 8076, 0, 234, 72};
    int n = sizeof(arr)/sizeof(arr[0]);
    int count = maxBit(arr, n);
    redixSort(arr, n, count);
    cout << "Sorted array: \n";
    printArray(arr, n);
    return 0;
}
