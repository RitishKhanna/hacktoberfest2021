#include <iostream>
using namespace std;
 
class BST
{
    public:
    int data;
    BST *left, *right;
    BST(){}
    BST(int);
    void Insert(int);
    BST *p, *q;
    void Root(BST*&);
    void Display(BST*);
};
 
BST ::BST(int d){
    p=new BST();
    p -> data = d;
    p -> left = NULL;
    p -> right = NULL;
};
 
void BST ::Insert(int d)
{
    BST *temp = new BST;
    temp -> data = d;
    temp -> left = NULL;
    temp -> right = NULL;
    BST *q;
    q = p;

    while(q!= NULL){
        if (q -> data < temp -> data){
            if (q -> right == NULL){
                q -> right = temp;
                break;
            }
            else
                q = q -> right;
        }
        else{
            if (q -> left == NULL){
                q -> left = temp;
                break;
            }
            else
                q = q -> left;
        }
    }
}
 
void BST :: Display(BST *q){
    if (q == NULL)
        return;
    Display(q -> left);
    cout<<q -> data<< " ";
    Display(q -> right);
}

void BST ::Root(BST* &q){
    q = p;
}
 
int main()
{
    BST T(20);
    T.Insert(20);
    T.Insert(10);
    T.Insert(5);
    T.Insert(7);
    T.Insert(15);
    T.Insert(12);
    T.Insert(16);
    BST *q;
    T.Root(q);
    T.Display(q);
}
