import java.util.*;

class delete_N_nodes
{
static class Node 
{ 
    int data; 
    Node next; 
}; 
static Node push( Node head_ref, int newnode_data) 
{ 
    Node newnode_node = new Node(); 
    newnode_node.data = newnode_data; 
    newnode_node.next = (head_ref); 
    (head_ref) = newnode_node;
    return head_ref;
} 
static void printList( Node head) 
{ 
    Node temp = head; 
    while (temp != null) 
    { 
        System.out.printf("%d ", temp.data); 
        temp = temp.next; 
    } 
    System.out.printf("\n"); 
} 
static void skipMdeleteN( Node head, int M, int N) 
{ 
    Node newnode = head, t; 
    int count; 
    while (newnode!=null) 
    {  
        for (count = 1; count < M && newnode != null; count++) 
            newnode = newnode.next; 
        if (newnode == null) 
            return; 
        t = newnode.next; 
        for (count = 1; count <= N && t != null; count++) 
        { 
            Node temp = t; 
            t = t.next; 
        } 
        newnode.next = t; 
        newnode = t; 
    } 
} 

// Driver code 
public static void main(String args[])
{ 
    /* Create following linked list 
    1.2.3.4.5.6.7.8.9.10 */
    Node head = null; 
    int M=2, N=3; 
    head=push(head, 10); 
    head=push(head, 9); 
    head=push(head, 8); 
    head=push(head, 7); 
    head=push(head, 6); 
    head=push(head, 5); 
    head=push(head, 4); 
    head=push(head, 3); 
    head=push(head, 2); 
    head=push(head, 1); 
    System.out.printf("M = %d, N = %d \nGiven" + "Linked list is :\n", M, N); 
    printList(head); 
    skipMdeleteN(head, M, N); 
    System.out.printf("\nLinked list after deletion is :\n"); 
    printList(head); 
} 
}