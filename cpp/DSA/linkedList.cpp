  
//In this file I have attached the implementaion of Node of linked list with all the basic operations such as search, insert, delete.
//similar files will be uploaded for other data structures.

//class Node
class Node
{
   public:
	 int data;
	 Node *next;
	 Node(int data)
	 {
	    this->data = data;
		  this->next = NULL;
	 }
};



//printing the linked list

void print(Node * head) {
  Node * temp = head;
  while(temp!=NULL) {
    cout<<temp->data<<" ";
    temp = temp->next;
  }
}


//taking input of a linked list

// In this case until user enters -1 new node will be created and appended in the list and head of the created list will be returned
Node* takeInput() {
	int data;
	cin >> data;
	Node *head = NULL;
	Node *tail = NULL;
	while(data != -1) {
		Node *newNode = new Node(data);
		if(head == NULL) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail -> next = newNode;
			tail = tail -> next;
		}

		cin >> data;
	}
	return head;
}



//calculating length of linked list
int length(Node *head)
{
    int count = 0;
    while(head != NULL) {
        count++;
        head = head->next;
    }
    
    return count;
}


//getting element at specific index
void printIthNode(Node *head, int i)
{
    int l = 0;
    Node * temp = head;
    Node * temp1 = head;
    while(temp != NULL) {
        l++;
        temp = temp -> next;
    }
    
    if(i >= l) {
        return;
    }
   
    int pos = 0;
    
    while(pos < i) {
        temp1 = temp1 -> next;
        pos++;
    }
    
    cout<<temp1->data;
}


//delete node at given position
Node *deleteNode(Node *head, int pos)
{
    if(head == NULL) {
        return NULL;
    } 
    
    if(pos == 0) {
        return head->next;
    }
    Node *t = head;
    int len = 0;
    while(t != NULL) {
        len++;
        t = t -> next;
    }
    if(pos >= len) {
        return head;
    }
    

    Node * temp = head;
    int i = 0;
    while(i< pos-1) {
        i++;
        temp = temp -> next;
    }
    temp->next = temp->next->next;
    return head;
}


//inserting new element
int length(Node *head) {
    if(head == NULL) {
        return 0;
    }
    
    return 1 + length(head->next);
}

Node* insertNodeHelper(Node * mainHead,Node *head, int i, int data, int count) {
    if(count == i-1) {
        Node * temp = head->next;
        Node * newNode = new Node(data);
        head->next = newNode;
        newNode->next = temp;
        return mainHead;
    }
    
    return insertNodeHelper(mainHead, head->next,i,data,count+1);
}



Node* insertNode(Node *head, int i, int data) {
    if(i == 0) {
        Node * newNode = new Node(data);
        newNode->next = head;
        head = newNode;
        return head;
    }
    int l = length(head);
    if(i> l) {
        return head;
    }
    
    if(i == l) {
        Node * newNode = new Node(data);
        Node * temp = head;
        while(temp->next != NULL) {
            temp = temp->next;
        }
        temp->next = newNode;
        return head;
    } 
	return insertNodeHelper(head, head, i, data, 0);
}
