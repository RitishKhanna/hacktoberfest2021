//In this file implementation of generic tress and some basic ques or functions such as height, traversal, maximum node are mentioned.

//Implementation of generic tree
//generic tree is a type of tree where the no of children of a node are not fixed.

    template <typename T>
    class TreeNode {
     public:
        T data;
        vector<TreeNode<T>*> children;
    
        TreeNode(T data) {
            this->data = data;
        }
    
        ~TreeNode() {
            for (int i = 0; i < children.size(); i++) {
                delete children[i];
            }
        }
    };


//printing the tree in level order

void printLevelWise(TreeNode<int>* root) {
    if(root == NULL) {
        return;
    }
    
    queue<TreeNode<int>*> pendingNodes;
    pendingNodes.push(root);
    
    while(!pendingNodes.empty()) {
        TreeNode<int> * frontNode = pendingNodes.front();
        pendingNodes.pop();
        cout<<frontNode->data<<":";
        for (int i = 0;i<frontNode->children.size();i++) {
            if(i == frontNode->children.size() - 1) {
                cout<<frontNode->children[i]->data;
            }else {
            cout<<frontNode->children[i]->data<<",";
            }pendingNodes.push(frontNode->children[i]);
        }
        cout<<endl;
    }
}


//sum of nodes of tree

int sumOfNodes(TreeNode<int>* root) {

    if(root == NULL) {
        return 0;
    }
    
    int sum = root->data;
    
    for (int i=  0;i<root->children.size();i++) {
        sum = sum + sumOfNodes(root->children[i]);
    }
    
    return sum;
}




//finding maximum node in tree

TreeNode<int>* maxDataNode(TreeNode<int>* root) {

    if(root == NULL) {
        return NULL;
    }
    
    TreeNode<int> *maxNode = root;
    
    for (int i = 0;i<root->children.size();i++) {
        TreeNode<int> * sans = maxDataNode(root->children[i]);
        if(sans->data > maxNode->data) {
            maxNode = sans;
        }
    }
    
    return maxNode;
}


//height of tree

int getHeight(TreeNode<int>* root) {
    // Write your code here
    if(root == NULL) {
        return 0;
    }
    
    int max = 0;
    
    for (int i = 0;i<root->children.size();i++) {
        int cheight = getHeight(root->children[i]);
        if(cheight > max) {
            max = cheight;
        }
    }
    
    return max + 1;
}



//postorder traversal


void printPostOrder(TreeNode<int>* root) {
    // Write your code here
    
    for (int i = 0;i<root->children.size();i++) {
        printPostOrder(root->children[i]);
    }
    
    cout<<root->data<<" ";
}


