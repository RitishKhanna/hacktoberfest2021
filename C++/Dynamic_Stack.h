#include <iostream>
using namespace std;

//Improving our code with templates and complexity to O(1)
template<typename t>

class node{
    t data;
    node<t>* next;
    node(t data){
        this->data=data;
        next=NULL;
    }
    template<typename s>
    friend class stack;
};

template<typename s>

class stack{
    node<s>* head=NULL;
    int curr_size=0;
    public:
    void push(s data){
        node<s> * newnode=new node<s>(data);
        newnode->next=head;
        head=newnode;
        curr_size++;
    }

    void pop(){
        if(head==NULL){
            cout<<"Stack is empty"<<endl;
            return;
        }
        node<s>* newnode=head;
        head=newnode->next;
        // cout<<"Popped element is: "<<newnode->data<<endl;
        delete newnode;
        curr_size--;
    }


    s top(){
        try {
        if(head!=NULL)
            return head->data;
        else
            throw 505;
        }
        catch(int error){
            cout<<"Stack is Empty"<<endl;
        }
    }

    int size(){
        return curr_size;
    }

    bool isempty(){
        if(head==NULL)
            return true;
        else
            return false;        
    }
};
/**
int main(){
    stack<float> s;
    cout<<"-----------------Empty stack test result----------------------"<<endl;
    cout<<"Is stack empty: ";s.isempty()?cout<<"yes"<<endl:cout<<"no"<<endl;
    cout<<"Top element of stack: "<<s.top()<<endl;
    cout<<"Size of stack: "<<s.size()<<endl;
    s.pop();
    cout<<"-----------------Filled stack test result----------------------"<<endl;
    s.push(1.3);
    s.push(2.3);
    s.push(3.3);
    s.push(4.3);
    cout<<"Is stack empty: ";s.isempty()?cout<<"yes"<<endl:cout<<"no"<<endl;
    cout<<"Top element of stack: "<<s.top()<<endl;
    cout<<"Size of stack: "<<s.size()<<endl;
    cout<<"-----------------Popped stack test result----------------------"<<endl;
    s.pop();
    cout<<"Top element of stack: "<<s.top()<<endl;
    cout<<"Size of stack: "<<s.size()<<endl;
    s.pop();
    cout<<"Top element of stack: "<<s.top()<<endl;
    cout<<"Size of stack: "<<s.size()<<endl;
    s.pop();
    cout<<"Top element of stack: "<<s.top()<<endl;
    cout<<"Size of stack: "<<s.size()<<endl;
    return 0;
}
**/
