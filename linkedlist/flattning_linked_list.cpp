// Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
// (i) a next pointer to the next node,
// (ii) a bottom pointer to a linked list where this node is head.
// Each of the sub-linked-list is in sorted order.
// Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
// Note: The flattened list will be printed using the bottom pointer instead of next pointer.


// code is here



#include <bits/stdc++.h>
using namespace std; 

/* Node structure  used in the program

stryct
*/

// int main(){
//     struct Node {
//         int data;
//         struct Node *next;
//         struct Node *bottom;
//         Node (int x){
//             data = x;
//             next  = NULL;
//             bottom = NULL:
//         }
        
//     };

// }

class Solution {
  public:
    Node *flatten(Node *root) {
        // Your code here
        if(root==NULL || root->next == NULL){
            return root;
        }
        
        root->next = flatten(root->next);
        root = mergeTwoLists(root, root->next);
        return root;
    }
    Node *mergeTwoLists(Node *a, Node *b){
        Node *temp = new Node(0);
        Node *res  = temp;
    while( a != NULL && b!= NULL){
        if(a->data < b->data){
            temp->bottom = a;
            a = a->bottom;
            temp = temp->bottom;
        }else{
            temp->bottom = b;
            b = b->bottom;
            temp = temp->bottom;
        }
    }
        
        if(a){
            temp->bottom = a;
        }else{
            temp->bottom = b;
        }
        return res->bottom;
    }
};
