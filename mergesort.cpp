#include<iostream>
using namespace std;

void merge(int array1[],int size1,int array2[],int size2,int *output){
 int i=0,j=0,k=0;

 while(i<size1 && j<size2){
     if(array1[i]<array2[j]){
         output[k]=array1[i];
         i++;
         k++;
     }
     else{
         output[k]=array2[j];
         j++;
         k++;

     }
 }

 while(i<size1){
     output[k]=array1[i];
         i++;
         k++;
 }

 while(j<size2){
       output[k]=array2[j];
         j++;
         k++;
 }

}
void mergeSort(int *input,int size){
 if(size<=1){
        return;
    }
 int mid=size/2;
 int size1=mid,size2=size-mid;

 int array1[500],array2[500];

 for(int i=0;i<mid;i++){
     array1[i]=input[i];
 }
 int k=0;
 for(int i=mid;i<size;i++){
     array2[k]=input[i];
     k++;
 }

 mergeSort(array1,size1);
 mergeSort(array2,size2);

 merge(array1,size1,array2,size2,input);


}

int main(){

    
    int length;
    cin>>length;

    int * input=new int[length];

    for(int i=0;i<length;i++){
    cin>>input[i];  
    }
    mergeSort(input,length);

    for(int i=0;i<length;i++){
        cout<<input[i]<<" ";
    }
}
